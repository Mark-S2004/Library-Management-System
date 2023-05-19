package application.librarymangementguiprogram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import librarySystem.*;

import java.io.IOException;
import java.util.Objects;

public class bookReaderController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Book book;
    Reader reader;
    @FXML
    Label bookLabel=new Label();
    @FXML
    Label authorLabel=new Label();

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public void setBook(Book book) {
        this.book = book;
        bookLabel.setText(book.getTitle());
        authorLabel.setText(book.getAuthor());
    }
    @FXML
    void rentBook(ActionEvent event){
        reader.rent(book);
        System.out.println(book.getIsrented());
    }
    @FXML
    void switchTopreviouspage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("reader.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
