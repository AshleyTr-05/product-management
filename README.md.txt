# Product Management System

## Student Information
- **Name:** Tran
- **Student ID:** [Your ID]
- **Class:** [Your Class]

## Technologies Used
- Spring Boot 3.3.x
- Spring Data JPA
- MySQL 8.0
- Thymeleaf
- Maven

## Setup Instructions
1. Import project into VS Code
2. Create database: `product_management`
3. Update `application.properties` with your MySQL credentials
4. Run: `mvn spring-boot:run`
5. Open browser: http://localhost:8080/products

## Completed Features
- [x] CRUD operations
- [x] Search functionality
- [x] Advanced search with filters
- [x] Validation
- [x] Sorting
- [ ] Pagination
- [ ] REST API (Bonus)

## Project Structure
src
└── main
    ├── java
    │   └── com
    │       └── example
    │           └── productmanagement
    │               ├── controller
    │               │   ├── DashboardController.java
    │               │   └── ProductController.java
    │               │
    │               ├── entity
    │               │   └── Product.java
    │               │
    │               ├── repository
    │               │   └── ProductRepository.java
    │               │
    │               ├── service
    │               │   ├── ProductService.java
    │               │   ├── ProductServiceImpl.java
    │               │   └── ProductManagementApplication.java
    │               
    ├── resources
    │   ├── static
    │   ├── templates
    │   │   ├── dashboard.html
    │   │   ├── product-form.html
    │   │   └── product-list.html
    │   │
    │   └── application.properties

## Database Schema
CREATE TABLE products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    price DECIMAL(38,2) NOT NULL,
    quantity INT NOT NULL,
    category VARCHAR(255) NOT NULL,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

## Known Issues
- OneDrive syncing -> lock the files 
