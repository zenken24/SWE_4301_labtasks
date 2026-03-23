package com.example.library;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Library library = new Library();

        Book b1 = new Book("Java", "A", "12345");
        Book b2 = new Book("Object", "B", "67890");
        Book b3 = new Book("Data", "C", "11223");
        Book b4 = new Book("Algo", "D", "44556");

        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);
        library.addBook(b4);

        Student s = new Student("Nika");
        Faculty f = new Faculty("Ash");

        library.addPerson(s);
        library.addPerson(f);

        //borowing books
        try {
            library.borrowBook(s, b1);
            library.borrowBook(f, b2);
            library.borrowBook(s, b3);
            library.borrowBook(f, b4);
        }
        catch(BookNotAvailableException | BorrowLimitExceededException e){
            System.out.println(e.getMessage());
        }
        //borowing books that are already booked
        try {
            library.borrowBook(s, b4);
        } catch (BookNotAvailableException | BorrowLimitExceededException e) {
            System.out.println(e.getMessage());  
        }
        //returning book
        library.returnBook(s, b1);
        System.out.println("Book returned: " + b1.getTitle());

        //boroowing returned book 
        try{
            library.borrowBook(s, b1);
            System.out.println("Book borrowed: " + b1.getTitle());
        }catch(BookNotAvailableException | BorrowLimitExceededException e){
            System.out.println(e.getMessage());
        }

        //borowing unavailable book 
        b1.setAvailable(false); 
        try{
            library.borrowBook(s, b1);
        }catch(BookNotAvailableException | BorrowLimitExceededException e) {
            System.out.println(e.getMessage());  //error message if book is not available
        }

        Book b5 = new Book("DB", "E", "55555");
        Book b6 = new Book("OS", "F", "66666");

        library.addBook(b5);
        library.addBook(b6);

        try {
            library.borrowBook(s, b1);
            library.borrowBook(s, b3);
            library.borrowBook(s, b5);
            library.borrowBook(s, b6); //should fail
        } catch (BookNotAvailableException | BorrowLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }
}
