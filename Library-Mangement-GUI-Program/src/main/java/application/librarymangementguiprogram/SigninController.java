package application.librarymangementguiprogram;
import librarySystem.Librarian;
import librarySystem.User;
import java.io.IOException;
import java.util.Objects;

import librarySystem.library;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SigninController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    TextField tfEmail = new TextField();
    @FXML
    TextField tfPass = new TextField();

    public void switchToSignup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signup.fxml")));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void switchToUserScene(ActionEvent event) throws IOException {
        System.out.println(library.listUsers);
        User emailUser = null;
        for (User libraryUser: library.listUsers) {
            if (libraryUser.getEmail().equals(tfEmail.getText())) {
                emailUser = libraryUser;
                break;
            }
        }
        if (emailUser == null) {
            System.out.println("There is no users with this email. Sign up if don't have an account");
        } else {
            if (emailUser.getPassword().equals(tfPass.getText())) {
                if (emailUser instanceof Librarian) {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("librarian.fxml")));
                } else {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("reader.fxml")));
                }
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                System.out.println("Wrong Password");
            }
        }
    }
}

