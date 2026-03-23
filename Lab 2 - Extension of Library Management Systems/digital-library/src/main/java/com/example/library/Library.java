package com.example.library;
import java.util.*;

public class Library {
    private List<Book> books; 
    private List<Person> people; 

    public Library(){
        books = new ArrayList<>();
        people = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public void borrowBook(Person person, Book book) throws BookNotAvailableException, BorrowLimitExceededException{
        if(!book.isAvailable()){
            throw new BookNotAvailableException("The book is not available!!!!");
        }

        if(person.getBorrowedBooks().size() >= person.getMaxbooks()){
            throw new BorrowLimitExceededException("Borrowing Limit exceeded!!!");
        }

        person.borrowBook(book);
    }

    public void returnBook(Person person, Book book){
        person.returnBook(book);
    }

}
