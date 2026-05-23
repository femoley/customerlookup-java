package com.example.customerlookup.controller;

import com.example.customerlookup.dto.EmailUpdateRequest;
import com.example.customerlookup.model.Customer;
import com.example.customerlookup.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @Operation(
            summary = "Search customers",
            description = "Search customers by Id, First Name, Last Name, Email, or Account Number"
    )
    public List<Customer> searchCustomers(
            @Parameter(
                    description = "Search term value. Can be Id, First Name, Last Name, Email, or Account Number",
                    example = "John"
            )
            @RequestParam(required = false) String searchTerm) {
        return customerService.searchCustomers(searchTerm);
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<Customer> updateEmail(
            @PathVariable Integer id,
            @Valid @RequestBody EmailUpdateRequest request) {

        Customer updatedCustomer = customerService.updateEmail(id, request.getEmail());

        return ResponseEntity.ok(updatedCustomer);
    }

    @PutMapping("/emails")
    public ResponseEntity<String> updateEmails(
            @Valid @RequestBody List<EmailUpdateRequest> requests) {

        customerService.updateEmails(requests);

        return ResponseEntity.ok("Email updates saved successfully.");
    }
}
