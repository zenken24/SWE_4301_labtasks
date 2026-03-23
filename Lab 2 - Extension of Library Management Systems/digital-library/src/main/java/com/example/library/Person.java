package com.example.library;

import java.util.*;

public class Person {
    private String name; 
    private int maxBooks;
    private List<Book> borrowedBooks; 

    public Person(String name, int maxBooks, List<Book> borrowedBooks){
        this.name = name; 
        this.maxBooks = maxBooks;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName(){
        return name; 
    }

    public int getMaxbooks(){
        return maxBooks; 
    }

    public List<Book> getBorrowedBooks(){
        return borrowedBooks;
    }

    public boolean borrowBook(Book book){
        if(borrowedBooks.size() < maxBooks && book.isAvailable()){
            borrowedBooks.add(book);
            book.setAvailable(false);
            return true; 
        }
        return false; 
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
        book.setAvailable(true);
    }
}
