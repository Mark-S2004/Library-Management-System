package application.librarymangementguiprogram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import librarySystem.*;

import java.io.IOException;
import java.util.Objects;

public class librarianController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Book book;
    User user;
    @FXML
    TextField tffirstname = new TextField();
    @FXML
    TextField tflastname = new TextField();
    @FXML
    TextField tfbook = new TextField();
    @FXML
    Label labelx = new Label();
    @FXML
    Label labely = new Label();
    Librarian librarian = new Librarian();
    @FXML
    void rentBook(ActionEvent event){
        librarian.rent(librarian.searchBook(tfbook.getText()));
        System.out.println(librarian.searchBook(tfbook.getText()).getIsrented());
    }
    @FXML
    void switchTobookLibrarianScene(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bookLibrarian.fxml"));
        root = loader.load();
        bookLibrarianController controller = loader.getController();
        book = librarian.searchBook(tfbook.getText());
        user = librarian.searchUser(tffirstname.getText(), tflastname.getText());
        controller.setLibrarian(librarian);
        controller.setBook(book);
        controller.setUser(user);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void searchUser(ActionEvent event){
        User user =  librarian.searchUser(tffirstname.getText(),tflastname.getText());
        String result =user.getFirstName();
        String result2=user.getLastName();
        labelx.setText(result);
        labely.setText(result2);

    }
    @FXML
    void orderBook(ActionEvent event){
        librarian.addToBookOrderList(librarian.searchBook(tfbook.getText()),librarian.searchUser(tffirstname.getText(),tflastname.getText()));
    }
    @FXML
    void addUser(ActionEvent event){
        librarian.addUser(new Reader("pass", tffirstname.getText(),tflastname.getText(), "mark@g", "56 gama", 4676));
    }
    @FXML
    void removeUser(ActionEvent event){
        librarian.removeUser(librarian.searchUser(tffirstname.getText(), tflastname.getText()));
    }
    @FXML
    void addBook(ActionEvent event){
        librarian.addBook(new Book(tfbook.getText(), "Mark Saleh"));
    }
    @FXML
    void removeBook(ActionEvent event){
        librarian.removeBook(librarian.searchBook(tfbook.getText()));
    }
    @FXML
    void blockUser(ActionEvent event){
        librarian.blockUser(librarian.searchUser(tffirstname.getText(), tflastname.getText()));
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
