module org.example.javafxgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javafxgui to javafx.fxml;
    exports org.example.javafxgui;
}