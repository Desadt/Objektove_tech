module com.example.kalku_thread {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.kalku_thread to javafx.fxml;
    exports com.example.kalku_thread;
}