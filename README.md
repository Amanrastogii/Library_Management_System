# Library Management System

A Java-based Library Management System designed using Object-Oriented Programming (OOP), SOLID principles, and design patterns.

This project demonstrates clean architecture and modular design while implementing core library operations such as book management, patron management, lending, reservations, and recommendations.

---

# Features

## Book Management
- Add books to the library inventory
- Remove books
- Update book information
- Search books by:
  - Title
  - Author
  - ISBN

## Patron Management
- Register patrons
- Track borrowing history
- Maintain patron information

## Lending Process
- Checkout books
- Return books
- Prevent borrowing already borrowed books

## Inventory Management
- Track available books
- Track borrowed books

---

# Optional Extensions Implemented

## Reservation System
Allows patrons to reserve books that are currently borrowed.

When the book becomes available, the next patron in the reservation queue is notified.

## Recommendation System
Recommends books to patrons based on their borrowing history.

---

# Project Architecture

The system follows **Layered Architecture**:

Main
│
├── model
│ ├── Book
│ ├── Patron
│ └── Loan
│
├── repository
│ ├── BookRepository
│ ├── InMemoryBookRepository
│ ├── PatronRepository
│ └── InMemoryPatronRepository
│
├── service
│ ├── LendingService
│ ├── ReservationService
│ └── RecommendationService
│
├── strategy
│ ├── RecommendationStrategy
│ └── HistoryBasedRecommendation
│
└── observer
└── BookObserver


---

# OOP Concepts Used

## Encapsulation
Private fields in models with controlled access through getters and methods.

## Abstraction
Repository interfaces hide storage implementation details.

## Polymorphism
Recommendation strategies implement a common interface.

## Inheritance
Custom exceptions extend RuntimeException.

---

# SOLID Principles Applied

### Single Responsibility Principle (SRP)
Each class has a single responsibility:
- Repository handles storage
- Service handles business logic
- Model represents domain entities

### Open/Closed Principle (OCP)
New recommendation strategies can be added without modifying existing code.

### Dependency Inversion Principle (DIP)
Services depend on repository interfaces instead of concrete implementations.

---

# Design Patterns Used

RecommendationStrategy
↑
HistoryBasedRecommendation

## Strategy Pattern
Used for implementing different book recommendation algorithms.



## Observer Pattern
Used in reservation system to notify patrons when books become available.

---

# Java Collections Used

- **Map** → Store books and patrons
- **List** → Maintain borrowing history
- **Queue** → Manage reservation order (FIFO)

---

# Logging

Java logging framework is used to track important events such as:

- Book checkout
- Book return
- Borrowing errors

---

# How to Run the Project

1. Clone the repository
git clone https://github.com/YOUR_USERNAME/library-management-system.git
Open the project in IntelliJ IDEA or any Java IDE.
Run:
Main.java


---

# Future Improvements

- Multi-branch library support
- Database persistence
- REST API using Spring Boot
- Web-based user interface

---

# Author

Aman Rastogi



