package librarySystem;

public class Book {
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
