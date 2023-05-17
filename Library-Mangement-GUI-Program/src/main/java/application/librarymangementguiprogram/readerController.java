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
    @FXML
    void rentBook(ActionEvent event){
        reader.rent(reader.searchBook(tfbook.getText()));
        System.out.println(reader.searchBook(tfbook.getText()).getIsrented());
    }
    @FXML
    void searchBook(ActionEvent event){
        reader.searchBook(tfbook.getText());
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
