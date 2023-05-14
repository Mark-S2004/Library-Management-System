package application.librarymangementguiprogram;
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
        @FXML
        Button btnLibrarian = new Button();
        @FXML
        Button btnReader = new Button();
        @FXML
        void chooseUser(ActionEvent e) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Signupform.fxml"));
                root = loader.load();
                SignUpFormController controller = loader.getController();
                if (e.getSource() == btnLibrarian) {
                        controller.setUserType(false);
                } else if (e.getSource() == btnReader) {
                        controller.setUserType(true);
                }
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
}




