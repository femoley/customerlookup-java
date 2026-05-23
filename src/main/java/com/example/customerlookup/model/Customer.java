package com.example.customerlookup.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "Customers",schema = "dbo",
        uniqueConstraints = {
                @UniqueConstraint(name = "UX_Customers_Email", columnNames = "Email")
        }
)

public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FirstName", nullable = false, length = 100)
    private String firstName;

    @Column(name = "LastName", nullable = false, length = 100)
    private String lastName;

    @Column(name = "Email", nullable = false, length = 200)
    private String email;

    @Column(name = "AccountNumber", nullable = false, length = 50)
    private String accountNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
