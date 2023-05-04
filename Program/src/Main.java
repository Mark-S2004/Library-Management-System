import librarySystem.*;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static int guestChoice;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Librarian hanna = new Librarian(
                "pass", "hanna", "tarek",
                "hanna@g.com", "toto", 0123
        );
        Reader mark = new Reader(
                "pass", "hanna", "tarek",
                "hanna@g.com", "toto", 0123
        );
        Book book1 = new Book("Harry", "JK", false);
        Book book2 = new Book("Percy", "to", false);
        Book book3 = new Book("test", "toto", false);
        library.listBooks.add(book1);
        library.listBooks.add(book2);
        library.listBooks.add(book3);
        library.listUsers.add(hanna);
        library.listUsers.add(mark);

        start();
    }
    private static void start () {
        User user;
        System.out.println("Login: 1\nSign Up: 2");
        guestChoice = scanner.nextInt();
        if (guestChoice == 1) {
            user = login();
        } else {
            user = signup();
        }
        if (user instanceof Reader) {
            Reader reader=(Reader)user;
            renderReaderPage(reader);
        } else {
            Librarian librarian=(Librarian)user;
            renderLibrarianPage(librarian);
        }
    }
    private static User login () {
        String email, pass;
        User emailUser = null;
        System.out.println("Email: ");
        email = scanner.next();
        for (User libraryUser: library.listUsers) {
            if (libraryUser.getEmail().equals(email)) {
                emailUser = libraryUser;
                break;
            }
        }
        if (emailUser == null) {
            System.out.println("The email is invalid");
            start();
        }
        System.out.println("Password: ");
        pass = scanner.next();
        if (emailUser.getPassword().equals(pass)) {
            return emailUser;
        } else {
            System.out.println("Wrong password");
            start();
        }
        return null;
    }
    private static User signup () {
        String password, firstName, lastName, email, address;
        int cellphone;
        User user;
        System.out.println("Enter First name: ");
        firstName = scanner.next();
        System.out.println("Enter Last name: ");
        lastName = scanner.next();
        System.out.println("Enter email: ");
        email = scanner.next();
        System.out.println("Enter password: ");
        password = scanner.next();
        System.out.println("Enter address: ");
        address = scanner.next();
        System.out.println("Enter phone: ");
        cellphone = scanner.nextInt();
        System.out.println("Librarian: Press [1]\nReader: Press [2]");
        guestChoice = scanner.nextInt();
        if (guestChoice == 1) {
            user = new Librarian(password, firstName, lastName, email, address, cellphone);
        } else {
            user = new Reader(password, firstName, lastName, email, address, cellphone);
        }
        library.listUsers.add(user);
        return user;
    }
    private static void renderReaderPage(Reader user) {
        System.out.println("Welcome " + user.getFirstName());
        System.out.println("Choose an action:\n" +
                "1: Search book\n" +
                "2: Search user\n" +
                "3: Order a book\n" +
                "4: Rent a book\n" +
                "0: Sign out");
        guestChoice = scanner.nextInt();
        switch (guestChoice) {
            case 1:
                System.out.println("Enter book title: ");
                String title = scanner.next();
                user.searchBook(title);
                break;
            case 2:
                System.out.println("Enter user first name: ");
                String first = scanner.next();
                System.out.println("Enter user last name: ");
                String last = scanner.next();
                User resultUser = user.searchUser(first, last);
                resultUser.toString();
                break;
            case 3:
                System.out.println("Enter book title to order: ");
                title = scanner.next();
                Book book = user.searchBook(title);
                user.addToBookOrderList(book);
                break;
            case 4:
                System.out.println("Enter book title to rent: ");
                title = scanner.next();
                book = user.searchBook(title);
                user.rent(book);
                break;
            default:
                start();
                break;
        }
    }
    private static void renderLibrarianPage(Librarian user) {
        System.out.println("Welcome " + user.getFirstName());
        System.out.println("Choose an action:\n" +
                "1: Search book\n" +
                "2: Search user\n" +
                "3: Order a book\n" +
                "4: Rent a book\n" +
                "5: Block user\n" +
                "6: Add a book to library\n" +
                "7: Remove book from library\n" +
                "8: Add a user to library\n" +
                "9: Remove user from library\n" +
                "0: Sign out");
        guestChoice = scanner.nextInt();
        switch (guestChoice) {
            case 1:
                System.out.println("Enter book title: ");
                String title = scanner.next();
                user.searchBook(title);
                break;
            case 2:
                System.out.println("Enter user first name: ");
                String first = scanner.next();
                System.out.println("Enter user last name: ");
                String last = scanner.next();
                User resultUser = user.searchUser(first, last);
                resultUser.toString();
                break;
            case 3:
                System.out.println("Enter user first name: ");
                first = scanner.next();
                System.out.println("Enter user last name: ");
                last = scanner.next();
                User reader = user.searchUser(first, last);
                System.out.println("Enter book title to order: ");
                title = scanner.next();
                Book book = user.searchBook(title);
                user.addToBookOrderList(book, reader);
                break;
            case 4:
                System.out.println("Enter book title to rent: ");
                title = scanner.next();
                book = user.searchBook(title);
                user.rent(book);
                break;
            case 5:
                System.out.println("Enter user first name to block: ");
                first = scanner.next();
                System.out.println("Enter user last name to block: ");
                last = scanner.next();
                reader = user.searchUser(first, last);
                user.blockUser(reader);
                break;
            case 6:
                System.out.println("Enter book title to add to library: ");
                title = scanner.next();
                book = user.searchBook(title);
                user.addBook(book);
                break;
            case 7:
                System.out.println("Enter book title to remove from library: ");
                title = scanner.next();
                book = user.searchBook(title);
                user.removeBook(book);
                break;
            case 8:
                System.out.println("Enter user first name to add to library: ");
                first = scanner.next();
                System.out.println("Enter user last name to add to library: ");
                last = scanner.next();
                reader = user.searchUser(first, last);
                user.addUser(reader);
                break;
            case 9:
                System.out.println("Enter user first name to remove from library: ");
                first = scanner.next();
                System.out.println("Enter user last name to remove from library: ");
                last = scanner.next();
                reader = user.searchUser(first, last);
                user.removeUser(reader);
                break;
            default:
                start();
                break;
        }
    }
}