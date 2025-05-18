# Spring Boot REST API for Customers and Products

## Overview

This project is a **Spring Boot 3.3.x RESTful API** designed to manage **Customers** and **Products**. It provides full CRUD (Create, Read, Update, Delete) operations, proper exception handling, Swagger integration for API documentation, and logback-based logging.

The application is built using **Java 21**, follows Spring MVC architecture, and is structured for scalability and maintainability.

---

## Features

- RESTful endpoints using Spring Web MVC
- Full CRUD for:
  - **Customers**: first name, last name, emails, family members
  - **Products**: book title, price, quantity
- Exception handling using `@ControllerAdvice`
- API documentation via **Swagger (OpenAPI 3)** at http://localhost:8080/swagger-ui/index.html
- Centralized request/response logging
- Logback logging for app-level and HTTP trace logs
- Modular folder structure (`controller`, `service`, `repository`, `dto`, `entity`, `mapper`, `exception`)
- SQL-based DB support (H2 Embedded Database) at http://localhost:8080/h2-console/

---


## API Endpoints

### Product Endpoints
| Method | Endpoint         | Description          |
|--------|------------------|----------------------|
| POST   | `/api/products`  | Create a product     |
| GET    | `/api/products`  | Get all products     |
| GET    | `/api/products/{id}` | Get product by ID |
| PUT    | `/api/products/{id}` | Update product    |
| DELETE| `/api/products/{id}` | Delete product     |

### Customer Endpoints
| Method | Endpoint         | Description          |
|--------|------------------|----------------------|
| POST   | `/api/customers` | Create a customer    |
| GET    | `/api/customers` | Get all customers    |
| GET    | `/api/customers/{id}` | Get customer by ID |
| PUT    | `/api/customers/{id}` | Update customer   |
| DELETE| `/api/customers/{id}` | Delete customer    |

---

## Author

This project was coded by **Imran Hafizuddin** as part of the **Etiqa Java Technical Assessment**.

---



