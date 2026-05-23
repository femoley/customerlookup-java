package com.example.customerlookup.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EmailUpdateRequest {

    @NotNull(message = "Customer ID is required.")
    private Integer customerId;

    @NotBlank(message = "Email address is required.")
    @Email(message = "Email address must be valid.")

    private String email;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
