package librarySystem;

import java.util.ArrayList;

public class Reader extends User{
    public Reader(){
    }
    public Reader(String password, String firstName, String lastName, String email, String address, int cellphone)
    {
        super(password, firstName, lastName, "Reader", email, address, cellphone);
    }
    public void addToBookOrderList(Book book){
        for(User i: book.BookOrderList){
            if(i==this)  {
                System.out.println("this user is already in the list");
                return;}
        }
        book.BookOrderList.add(this);
    }
}