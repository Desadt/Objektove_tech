module com.example.animacia_lopta {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animacia_lopta to javafx.fxml;
    exports com.example.animacia_lopta;
}