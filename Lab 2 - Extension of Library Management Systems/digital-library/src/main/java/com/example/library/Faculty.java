package com.example.library;

import java.util.ArrayList;

public class Faculty extends Person {
    public Faculty(String name){
        //can borrow max 10 books
        super(name, 10, new ArrayList<>());
    }
}
