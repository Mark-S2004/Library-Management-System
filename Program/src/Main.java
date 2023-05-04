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
            renderReaderPage(user);
        } else {
            renderLibrarianPage(user);
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
    private static void renderReaderPage(User user) {
        System.out.println("Welcome " + user.getFirstName());
        System.out.println("Choose an action:\n" +
                "1: Search book\n" +
                "2: Search user\n" +
                "3: Order a book\n" +
                "4: Rent a book");
        guestChoice = scanner.nextInt();
    }
    private static void renderLibrarianPage(User user) {
        System.out.println("Welcome " + user.getFirstName());
        System.out.println("");
    }
}