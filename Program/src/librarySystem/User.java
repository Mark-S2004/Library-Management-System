package librarySystem;

import java.util.UUID;

public abstract class User  {
    private UUID ID;
    private String Password;
    private String FirstName;
    private String LastName;
    private String type;
    private String Email;
    private String Address;
    private int Cellphone;
    private boolean isBlocked;

    public User(){
    }
    public User( String password, String firstName, String lastName, String type, String email, String address, int cellphone) {
        this.ID = UUID.randomUUID();
        Password = password;
        FirstName = firstName;
        LastName = lastName;
        this.type = type;
        Email = email;
        Address = address;
        Cellphone = cellphone;
        this.isBlocked = false;
    }

    @Override
    public String toString() {
        return "Name: " + this.FirstName + " " + this.LastName + "\nEmail: " + this.Email + "\nType: " + this.type;
    }

    public boolean isBlocked() {
            return isBlocked;
        }

        public int getCellphone() {
            return Cellphone;
        }

        public UUID getID() {
            return ID;
        }

        public String getAddress() {
            return Address;
        }

        public String getEmail() {
            return Email;
        }

        public String getFirstName() {
            return FirstName;
        }

        public String getLastName() {
            return LastName;
        }

        public String getPassword() {
            return Password;
        }

        public String getType() {
            return type;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public void setBlocked(boolean blocked) {
            isBlocked = blocked;
        }

        public void setCellphone(int cellphone) {
            Cellphone = cellphone;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public void setFirstName(String firstName) {
            FirstName = firstName;
        }

        public void setLastName(String lastName) {
            LastName = lastName;
        }

        public void setPassword(String password) {
            Password = password;
        }

        public void setType(String type) {
            this.type = type;
        }
        public void rent(Book book){
            if(book.getIsrented()){
                System.out.println("sorry book is already rented");
            }
            else{
                book.setIsrented(true);
            }
        }
        public Book searchBook(String title) {
            for (Book i : library.listBooks) {
                if (i.getTitle().equals(title)) return i;
            }
            System.out.println("sorry book is not found");
            return null;
        }
        public User searchUser(String first , String last){
            for(User i: library.listUsers){
                if(i.getFirstName().equals(first) && i.getLastName().equals(last)) return i;
            }
            System.out.println("sorry user is not found");
            return null;
        }
}
