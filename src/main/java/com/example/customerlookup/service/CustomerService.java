package com.example.customerlookup.service;

import com.example.customerlookup.dto.EmailUpdateRequest;
import com.example.customerlookup.model.Customer;
import com.example.customerlookup.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> searchCustomers(String searchTerm) {
        if (searchTerm == null || searchTerm.trim().isEmpty()) {
            return customerRepository.findAll();
        }

        String term = searchTerm.trim();

        return customerRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrAccountNumberContainingIgnoreCase(
                        term,
                        term,
                        term,
                        term
                );
    }

    public Customer updateEmail(Integer customerId, String newEmail) {
        String cleanedEmail = newEmail.trim();

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer was not found."));

        boolean emailExistsForAnotherCustomer =
                customerRepository.existsByEmailIgnoreCaseAndIdNot(cleanedEmail, customerId);

        if (emailExistsForAnotherCustomer) {
            throw new IllegalArgumentException("Email address already exists for another customer.");
        }

        customer.setEmail(cleanedEmail);

        return customerRepository.save(customer);
    }

    public void updateEmails(List<EmailUpdateRequest> requests) {
        for (EmailUpdateRequest request : requests) {
            updateEmail(request.getCustomerId(), request.getEmail());
        }
    }
}
