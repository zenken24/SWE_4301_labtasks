package com.example.library;

public class Book {
    private String title;
    private String author;
    private String ISBN; 
    private boolean avail;

    public Book(String title, String author, String ISBN){
        this(title, author, ISBN, true);
    }

    public Book(String title, String author, String ISBN, boolean avail){
        this.title = title; 
        this.author = author; 
        this.ISBN = ISBN; 
        this.avail = avail;
    }
     
    public String getTitle(){
        return title; 
    }

    public String getAuthor(){
        return author;
    }

    public String getISBN(){
        return ISBN;
    }

    public boolean isAvailable(){
        return avail;
    }

    public boolean setAvailable(boolean avail){
        this.avail = avail;
        return this.avail;
    }
}
