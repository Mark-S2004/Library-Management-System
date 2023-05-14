package application.librarymangementguiprogram;

import application.librarymangementguiprogram.librarySystem.Librarian;
import application.librarymangementguiprogram.librarySystem.Reader;
import application.librarymangementguiprogram.librarySystem.library;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignUpFormController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private boolean userType;
    @FXML
    TextField tfFirstName = new TextField();
    @FXML
    TextField tfLastName = new TextField();
    @FXML
    TextField tfEmail = new TextField();
    @FXML
    TextField tfPass = new TextField();
    @FXML
    TextField tfAddress = new TextField();
    @FXML
    TextField tfPhone = new TextField();


    public void setUserType(boolean x) {
        userType = x;
    }

    @FXML
    void switchToUserScene(ActionEvent event) throws IOException {
        if (userType) {
            Reader user = new Reader(
                    tfPass.getText(), tfFirstName.getText(), tfLastName.getText(),
                    tfEmail.getText(), tfAddress.getText(), Double.parseDouble(tfPhone.getText())
            );
            library.listUsers.add(user);
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("reader.fxml")));
        } else {
            Librarian user = new Librarian(
                    tfPass.getText(), tfFirstName.getText(), tfLastName.getText(),
                    tfEmail.getText(), tfAddress.getText(), Double.parseDouble(tfPhone.getText())
            );
            library.listUsers.add(user);
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("librarian.fxml")));
        }
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
