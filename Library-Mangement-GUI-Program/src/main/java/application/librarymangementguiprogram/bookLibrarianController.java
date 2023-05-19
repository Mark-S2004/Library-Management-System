package application.librarymangementguiprogram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import librarySystem.Book;
import librarySystem.Librarian;
import librarySystem.User;

import java.io.IOException;
import java.util.Objects;

public class bookLibrarianController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Book book;
    User user;
    Librarian librarian;
    @FXML
    Label bookLabel=new Label();
    @FXML
    Label authorLabel=new Label();

    public void setUser(User user) {
        this.user = user;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public void setBook(Book book) {
        this.book = book;
        bookLabel.setText(book.getTitle());
        authorLabel.setText(book.getAuthor());
    }

    @FXML
    void rentBook(ActionEvent event){
        librarian.rent(book);
        System.out.println(book.getIsrented());
    }
    @FXML
    void orderBook(ActionEvent event){
        librarian.addToBookOrderList(book, user);
    }
    @FXML
    void switchTopreviouspage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("librarian.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
