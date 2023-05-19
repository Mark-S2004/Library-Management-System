package application.librarymangementguiprogram;

import javafx.scene.control.Alert;
import librarySystem.Librarian;
import librarySystem.PassException;
import librarySystem.Reader;
import librarySystem.library;
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
        try{
        if (userType) {
            Reader user = new Reader(
                    tfPass.getText(), tfFirstName.getText(), tfLastName.getText(),
                    tfEmail.getText(), tfAddress.getText(), Double.parseDouble(tfPhone.getText())
            );
            if (user.getAddress().equals("") || user.getEmail().equals("") || user.getFirstName().equals("") || user.getLastName().equals("") || user.getPassword().equals("")) {
                throw new PassException("please fill all input fields");
            }
            library.listUsers.add(user);
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("reader.fxml")));
        }
        }
        catch(NumberFormatException n){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("please enter valid input");
            alert.showAndWait();
            return;
        }
        catch(PassException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
            return;
        }
        try {
            if (!userType) {

                Librarian user = new Librarian(
                        tfPass.getText(), tfFirstName.getText(), tfLastName.getText(),
                        tfEmail.getText(), tfAddress.getText(), Double.parseDouble(tfPhone.getText())
                );
                if (user.getAddress().equals("") || user.getEmail().equals("") || user.getFirstName().equals("") || user.getLastName().equals("") || user.getPassword().equals("")) {
                    throw new PassException("please fill all input fields");
                }
                library.listUsers.add(user);
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("librarian.fxml")));
            }
        }
        catch(NumberFormatException n){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("please enter valid input");
            alert.showAndWait();
            return;
        }
        catch(PassException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(e.getMessage());
            alert.showAndWait();
            return;
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
