module com.example.animacia_auto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animacia_auto to javafx.fxml;
    exports com.example.animacia_auto;
}