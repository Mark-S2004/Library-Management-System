package librarySystem;

import java.util.ArrayList;

public class library {
    public static ArrayList<Book> listBooks;

    {
       listBooks = new ArrayList<>();
       listBooks.add(new Book("To Kill a Mockingbird", "Harper Lee", false));
       listBooks.add( new Book("Great Expectations", "Charles Dickens", true));
       listBooks.add(new Book("Pride and Prejudice", "Jane Austen"));
       listBooks.add(new Book("1984", "George Orwell"));
       listBooks.add(new Book("The Hobbit", "J.R.R. Tolkien", false));
    }

    public static ArrayList<User> listUsers;
    {
        listUsers= new ArrayList<>();
        listUsers.add(new Reader("pass1","John","Doe","john@email.com","123 Main St",1234567890));
        listUsers.add(new Reader("pass2","Jane","Doe","jane@email.com","124 Main St",1234567891));
        listUsers.add(new Reader("pass3","Jack","Smith","jack@email.com","125 Main St",1234567892));
        listUsers.add( new Reader("pass4","Jill","Smith","jill@email.com","126 Main St",1234567893));
    }


}
