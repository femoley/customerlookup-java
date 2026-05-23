# Customer Lookup API

A Spring Boot REST API for customer lookup and email maintenance using Java 17 and SQL Server.

## Technologies Used

- Java 17
- Spring Boot 3
- Spring Data JPA
- Hibernate
- SQL Server
- Maven
- IntelliJ IDEA

---

# Project Architecture

```text
Controller → Service → Repository → SQL Server
```

## Features
- Retrieve all customers
- Search customers
- Update customer email
- SQL Server integration
- REST API endpoints
- JPA/Hibernate entity mapping
- API Endpoints
- Get All Customers

# API Endpoints
## Get All Customers

GET

```text
http://localhost:8080/api/customers
```

## Search Customers

GET

```text
http://localhost:8080/api/customers?searchTerm=john
```

## Update Customer Email

PUT

```text
http://localhost:8080/api/customers/1/email
```

Request Body:

```text
{
  "customerId": 1,
  "email": "john.updated@email.com"
}
```

# SQL Server Configuration

## Update application.properties:

```text
spring.datasource.url=jdbc:sqlserver://localhost:1433;databaseName=LegacyCustomerLookupDb;encrypt=true;trustServerCertificate=true
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
```

# Run the Application
## Maven

```text
mvn spring-boot:run
```

## IntelliJ

Run:

```text
CustomerLookupApplication.java
```
Sample Response

```text
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@email.com",
    "accountNumber": "100001"
  }
]
```








