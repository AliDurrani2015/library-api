# Trigger CI workflow
# Retry build

#  Library Management API (Spring Boot)

A RESTful API for managing books and borrowers in a library system. Built with **Java 21**, **Spring Boot**, **Maven**, and **Docker**.

[![CI](https://github.com/AliDurrani2015/library-api/actions/workflows/ci.yml/badge.svg)](https://github.com/AliDurrani2015/library-api/actions)

---

# Features:

-  Manage books (CRUD)
-  Manage borrowers (add/list)
-  Borrow and return books (only one per borrower)
-  Input validation and centralized error handling
-  In-memory H2 database (no setup required)
-  Dockerized app
-  CI/CD pipeline using GitHub Actions
-  Unit tests with JUnit and Mockito

---

# Technologies Used:

- Java 21
- Spring Boot 3.5.x
- Spring Web
- Spring Data JPA
- H2 In-Memory Database
- Maven
- Docker
- GitHub Actions (CI/CD)

---

# API Endpoints:

# Books:

| Method | Endpoint            | Description      |
|--------|---------------------|------------------|
| GET    | `/api/books`        | List all books   |
| POST   | `/api/books`        | Add a new book   |
| PUT    | `/api/books/{id}`   | Update a book    |
| DELETE | `/api/books/{id}`   | Delete a book    |

---

# Borrowers:

| Method | Endpoint               | Description         |
|--------|------------------------|---------------------|
| GET    | `/api/borrowers`       | List all borrowers  |
| POST   | `/api/borrowers`       | Add a new borrower  |

---

# Borrow / Return:

| Method | Endpoint                                 | Description        |
|--------|------------------------------------------|--------------------|
| POST   | `/api/borrow/{borrowerId}/book/{bookId}` | Borrow a book      |
| POST   | `/api/return/{borrowerId}/book/{bookId}` | Return a book      |

---

# Sample JSON Payloads:

# Add Book:

```json
{
  "title": "Effective Java",
  "author": "Joshua Bloch"
}

