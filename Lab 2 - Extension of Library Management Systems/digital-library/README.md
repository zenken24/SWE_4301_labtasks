# Digital Library Management System

A Java-based library management system that demonstrates object-oriented programming concepts including inheritance, exception handling, and collection management.

## Overview

This project implements a library system where students and faculty can borrow and return books with enforced borrowing limits and availability checks.

## Features

- **Multi-user support**: Students (max 3 books) and Faculty (max 10 books)
- **Book management**: Add books to library and track availability
- **Borrowing system**: Borrow available books with limit enforcement
- **Return system**: Return borrowed books to make them available again
- **Exception handling**: Custom exceptions for unavailable books and exceeded borrowing limits
- **Unit testing**: Comprehensive JUnit tests for all functionality

## Project Structure

```
src/
├── main/java/com/example/library/
│   ├── App.java                           # Main entry point
│   ├── Library.java                       # Library management
│   ├── Book.java                          # Book entity
│   ├── Person.java                        # Base class for users
│   ├── Student.java                       # Student with 3-book limit
│   ├── Faculty.java                       # Faculty with 10-book limit
│   ├── BookNotAvailableException.java     # Exception for unavailable books
│   └── BorrowLimitExceededException.java # Exception for exceeded limits
└── test/java/com/example/library/
    └── AppTest.java                       # Unit tests
```

## How to Run

### Build
```bash
cd 'Lab 2 - Extension of Library Management Systems/digital-library'
mvn clean compile
```

### Test
```bash
mvn clean test
```

### Run
```bash
mvn clean test
java -cp target/classes com.example.library.App
```

## Example Output

```
The book is not available!!!!
Book returned: Java
Book borrowed: Java
The book is not available!!!!
```

## Class Descriptions

### Person
Base class for library users. Manages borrowed books and enforces borrowing limits.
- `borrowBook(Book)`: Borrow a book
- `returnBook(Book)`: Return a borrowed book

### Student
Extends Person with a maximum borrowing limit of **3 books**.

### Faculty
Extends Person with a maximum borrowing limit of **10 books**.

### Book
Represents a library book with title, author, ISBN, and availability status.

### Library
Central management system for books and people.
- `addBook(Book)`: Add book to library
- `addPerson(Person)`: Add user to library
- `borrowBook(Person, Book)`: Borrow a book with validation
- `returnBook(Person, Book)`: Return a borrowed book

### Exceptions
- `BookNotAvailableException`: Thrown when attempting to borrow an unavailable book
- `BorrowLimitExceededException`: Thrown when a user exceeds their borrowing limit

## Requirements

- Java 21+
- Maven 3.11.0+

## Testing

All tests pass successfully:
- `testBorrow()`: Verify book becomes unavailable after borrowing
- `testReturn()`: Verify book becomes available after returning
- `testBorrowUnavailable()`: Verify exception on unavailable book
- `testLimit()`: Verify exception on exceeded limit
