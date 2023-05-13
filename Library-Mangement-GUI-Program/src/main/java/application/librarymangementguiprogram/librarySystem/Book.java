package application.librarymangementguiprogram.librarySystem;

import java.util.ArrayList;

public class Book {
     ArrayList<User> BookOrderList=new ArrayList();
    private String title, author;
    private boolean isrented;
    public Book(){
    }
    public Book (String title,String author){
        this.title=title;
        this.author=author;
    }
    public Book(String title, String author, boolean isrented ) {
        this.title = title;
        this.author = author;
        this.isrented = isrented;
    }

    @Override
    public String toString() {
        return "Title: " + this.title + "\nAuthor: " + this.author + "\nRented? " + this.isrented;
    }

    public void setTitle(String s){
        this.title=s;
    }
    public String getTitle(){
        return title;
    }
    public void setAuthor(String a){
        this.author=a;
    }
    public String getAuthor(){
        return author;
    }
    public void setIsrented(boolean e){
        this.isrented=e;
    }
    public boolean getIsrented(){
        return isrented;
}

}
