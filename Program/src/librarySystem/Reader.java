package librarySystem;

import java.util.ArrayList;

public class Reader extends User{
    public Reader(){
    }
    public Reader(int id, String password, String firstName, String lastName, String email, String address, int cellphone, boolean isBlocked)
    {
        super( id, password, firstName, lastName, "Reader", email, address, cellphone, isBlocked);
    }
    void addToBookOrderList(){
        for(User i: library.BookOrderList){
            if(i==this)  return;
            else library.BookOrderList.add(this);
        }

    }
}