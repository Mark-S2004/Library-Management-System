package application.librarymangementguiprogram;

import librarySystem.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class readerController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    TextField tffirstname = new TextField();
    @FXML
    TextField tflastname = new TextField();
    @FXML
    TextField tfbook = new TextField();
    Reader reader = new Reader();
    Book book;
    @FXML
    void switchTobookReaderScene(ActionEvent event) throws IOException {
        book = reader.searchBook(tfbook.getText());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bookReader.fxml"));
        root = loader.load();
        bookReaderController controller = loader.getController();
        controller.setReader(reader);
        controller.setBook(book);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void searchUser(ActionEvent event){
        reader.searchUser(tffirstname.getText(),tflastname.getText());
    }
    @FXML
    void orderBook(ActionEvent event){
        reader.addToBookOrderList(reader.searchBook(tfbook.getText()));
    }
    @FXML
    void switchToSigninScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signin-signup.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
