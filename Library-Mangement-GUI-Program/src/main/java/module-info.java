module application.librarymangementguiprogram {
    requires javafx.controls;
    requires javafx.fxml;


    opens application.librarymangementguiprogram to javafx.fxml;
    exports application.librarymangementguiprogram;
}