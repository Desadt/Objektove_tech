module com.example.zadanie_animal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.zadanie_animal to javafx.fxml;
    exports com.example.zadanie_animal;
}