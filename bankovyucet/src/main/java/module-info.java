module com.example.bankovyucet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bankovyucet to javafx.fxml;
    exports com.example.bankovyucet;
}