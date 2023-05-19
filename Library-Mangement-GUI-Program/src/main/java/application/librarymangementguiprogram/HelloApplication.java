package application.librarymangementguiprogram;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage)  {
        try {


            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("signin-signup.fxml")));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("application.css").toExternalForm();
            scene.getStylesheets().add(css);
            scene.getStylesheets();
            stage.setTitle("Library");
            stage.setScene(scene);
            stage.show();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (Exception a) {
            a.printStackTrace();
        }


    }


        public static void main(String[] args) {
        launch();
    }
}