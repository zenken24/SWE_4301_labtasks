package com.example.library;

import org.junit.Test;

import com.example.library.Book;
import com.example.library.BookNotAvailableException;
import com.example.library.BorrowLimitExceededException;
import com.example.library.Library;
import com.example.library.Student;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

public class LibraryTest {

    @Test
    public void testBorrow() throws Exception {
        Library library = new Library();

        Book b1 = new Book("Java", "A", "123");
        Student s = new Student("Nika");

        library.addBook(b1);
        library.addPerson(s);

        library.borrowBook(s, b1);

        assertFalse(b1.isAvailable());
    }

    @Test
    public void testReturn() throws Exception {
        Library library = new Library();

        Book b1 = new Book("Java", "A", "123");
        Student s = new Student("Nika");

        library.addBook(b1);
        library.addPerson(s);

        library.borrowBook(s, b1);
        library.returnBook(s, b1);

        assertTrue(b1.isAvailable());
    }

    @Test
    public void testBorrowUnavailable() throws Exception {
        Library library = new Library();

        Book b1 = new Book("Java", "A", "123");
        Student s1 = new Student("Nika");
        Student s2 = new Student("Rina");

        library.addBook(b1);
        library.addPerson(s1);
        library.addPerson(s2);

        library.borrowBook(s1, b1);

        try {
            library.borrowBook(s2, b1);
            fail("Expected BookNotAvailableException");
        } catch (BookNotAvailableException e) {
            // test passed
        }
    }

    @Test
    public void testLimit() throws Exception {
        Library library = new Library();

        Student s = new Student("Nika");

        Book b1 = new Book("B1", "A", "1");
        Book b2 = new Book("B2", "A", "2");
        Book b3 = new Book("B3", "A", "3");
        Book b4 = new Book("B4", "A", "4");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);

        library.addPerson(s);

        library.borrowBook(s, b1);
        library.borrowBook(s, b2);
        library.borrowBook(s, b3);

        try {
            library.borrowBook(s, b4);
            fail("Expected BorrowLimitExceededException");
        } catch (BorrowLimitExceededException e) {
            // test passed
        }
    }
}