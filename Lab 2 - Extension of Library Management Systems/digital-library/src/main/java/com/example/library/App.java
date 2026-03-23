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
        Book b7 = new Book("Math", "G", "77777");
        Book b8 = new Book("AI", "H", "88888");

        library.addBook(b5);
        library.addBook(b6);
        library.addBook(b7);
        library.addBook(b8);

        Student s2 = new Student("Mina");
        library.addPerson(s2);
        library.returnBook(s, b1);
        library.returnBook(f, b2);
        library.returnBook(s, b3);
        library.returnBook(f, b4);

        try {
            library.borrowBook(s2, b1);
            library.borrowBook(s2, b2);
            library.borrowBook(s2, b3);
            library.borrowBook(s2, b4);
            library.borrowBook(s2, b5);
            library.borrowBook(s2, b6);
            library.borrowBook(s2, b7);
            library.borrowBook(s2, b8); // should fail
        } catch (BookNotAvailableException | BorrowLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }
}
