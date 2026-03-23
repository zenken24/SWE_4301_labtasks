package com.example.library;

import java.util.ArrayList;

public class Student extends Person{
    public Student(String name){
        //can borrow max 3 books
        super(name, 3, new ArrayList<>());
    }
}
