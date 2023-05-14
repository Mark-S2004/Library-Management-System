package application.librarymangementguiprogram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignUpFormController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private boolean userType;

    public void setUserType(boolean x) {
        userType = x;
    }

    @FXML
    void switchToUserScene(ActionEvent event) throws IOException {
        if (userType) {
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("reader.fxml")));
        } else {
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
