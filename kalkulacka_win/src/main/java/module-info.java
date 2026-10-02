module com.example.kalkulacka_win {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kalkulacka_win to javafx.fxml;
    exports com.example.kalkulacka_win;
}