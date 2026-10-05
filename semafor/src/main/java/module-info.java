module com.example.semafor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.semafor to javafx.fxml;
    exports com.example.semafor;
}