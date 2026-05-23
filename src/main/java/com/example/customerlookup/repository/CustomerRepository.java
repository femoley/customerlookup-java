package com.example.customerlookup.repository;

import com.example.customerlookup.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCaseOrAccountNumberContainingIgnoreCase(
            String firstName,
            String lastName,
            String email,
            String accountNumber
    );

    Optional<Customer> findByAccountNumber(String accountNumber);

    Optional<Customer> findByEmailIgnoreCase(String email);

    boolean existsByEmailIgnoreCaseAndIdNot(String email, Integer id);
}
