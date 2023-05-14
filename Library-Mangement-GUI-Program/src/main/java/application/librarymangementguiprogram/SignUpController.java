package application.librarymangementguiprogram;

import application.librarymangementguiprogram.librarySystem.Librarian;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import java.io.IOException;
import java.util.Objects;

public class SignUpController {
        private Stage stage;
        private Scene scene;
        private Parent root;
        boolean x;
        @FXML
        Button btnLibrarian = new Button();
        @FXML
        Button btnReader = new Button();

        @FXML
        void chooseUser(ActionEvent e) throws IOException {

                if (e.getSource() == btnLibrarian) {
                        x = false;
                } else if (e.getSource() == btnReader) {
                        x = true;
                }


                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Signupform.fxml")));
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();


        }
        @FXML
        public void switchToScene4(ActionEvent event) throws IOException {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signin-signup.fxml")));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }


}




