module com.example.zadanie_weather {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zadanie_weather to javafx.fxml;
    exports com.example.zadanie_weather;
}