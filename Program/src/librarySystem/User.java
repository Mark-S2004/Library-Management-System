package librarySystem;

public abstract class User  {
        private int ID;
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
        public User(int id, String password, String firstName, String lastName, String type, String email, String address, int cellphone, boolean isBlocked) {
            ID = id;
            Password = password;
            FirstName = firstName;
            LastName = lastName;
            this.type = type;
            Email = email;
            Address = address;
            Cellphone = cellphone;
            this.isBlocked = isBlocked;
        }

        public boolean isBlocked() {
            return isBlocked;
        }

        public int getCellphone() {
            return Cellphone;
        }

        public int getID() {
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

        public void setID(int ID) {
            this.ID = ID;
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
        void rent(Book book){
            book.setIsrented(true);
        }
        Book searchBook(Book book) {
            for (Book i : library.listBooks) {
                if (i == book) return i;
            }
            return null;
        }
        User searchUser(User user){
            for(User i: library.listUsers){
                if(i==user) return i;
            }
            return null;
        }
    }
