import java.util.*;

abstract class Person{
    String name; 
    String email; 

    abstract void displayDetails();

    Person(String name, String email){
        this.name = name; 
        this.email = email;
    }
}

class Student extends Person{
    List<Book> books = new ArrayList<>();

    Student(String name, String email){
        super(name, email);
    }
    @Override
    void displayDetails(){
        System.out.println("Name of Student: " + name);
        System.out.println("Email of Student: " + email);
    }
}

class Faculty extends Person{
    List<Book> books = new ArrayList<>();

    Faculty(String name, String email){
        super(name, email);
    }
    @Override
    void displayDetails(){
        System.out.println("Name of Faculty: " + name);
        System.out.println("Email of Faculty: " + email);
    }
}

class Book{
    String title; 
    String author; 
    String isbn; 
    double price; 
    static int totalBooksIssued = 0; 

    Book(String title, String author, String isbn, double price){
        this.title = title; 
        this.author = author; 
        this.isbn = isbn; 
        this.price = price; 
        totalBooksIssued++;

    }

    void displayInfo(){
        System.out.println("-----------------------");
        System.out.println("Name of the Title: " + title);
        System.out.println("Name of the Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Price of the book: " + price);
        System.out.println("Total issued book: " + totalBooksIssued);
    }
}

class Library{

    void printPersonDetails(Person p){
        p.displayDetails();
    }

}

public class App {
    public static void main(String[] args) throws Exception {

        System.out.println("----------------------------");
        Student akhiar = new Student("Md. Muntahi Hasan Akhiar", "muntahihasan@iut-dhaka.edu");
        akhiar.displayDetails();

        Student anika = new Student("Safia Aman Anika", "safiaaman@iut-dhaka.edu");
        anika.displayDetails();

        Faculty khadiza = new Faculty("Khadiza Sultana", "khadizasultana@iut-dhaka.edu");
        khadiza.displayDetails();
        
        Library lib = new Library();
        Book bk1 = new Book("No longer human", "Dazai Osamu", "3nde", 345.50);
        bk1.displayInfo();
    }
}
