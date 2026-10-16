module com.example.zadanie_robot {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zadanie_robot to javafx.fxml;
    exports com.example.zadanie_robot;
}