package librarySystem;

public class Librarian extends User{
    public Librarian (int id, String password, String firstName, String lastName, String email, String address, int cellphone, boolean isBlocked) {
        super(id, password, firstName, lastName, "Librarian", email, address, cellphone, isBlocked);
    }
    public void addBook (Book book) {
        for (Book libraryBook: library.listBooks) {
            if (book == libraryBook) return;
        }
        library.listBooks.add(book);
    }
    public void removeBook (Book book) {
        library.listBooks.remove(book);
    }
    public void addUser (User user) {
        for (User libraryUser: library.listUsers) {
            if (user == libraryUser) return;
        }
        library.listUsers.add(user);
    }
    public void removeUser (User user) {
        library.listUsers.remove(user);
    }
    public void blockUser (User user) {
        user.setBlocked(true);
    }
    public void addToBookOrderList (Book book, User user) {
        for(User i: book.BookOrderList){
            if(i==user)  return;
        }
        book.BookOrderList.add(user);
    }
}
