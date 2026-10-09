package com.example.animacia_auto;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML
    private Pane root;

    @FXML
    private Button btn;

    private Auto car;

    @FXML
    public void initialize() {
        car = new Auto(50, 200, root);
        root.getChildren().add(car);
    }

    @FXML
    private void zmenRezim() {
        car.prepniRezim();

        if (car.isauto()) {
            btn.setText("Režim: AUTOMATIKA");
        } else {
            btn.setText("Režim: MANUÁL");
        }
        car.requestFocus();
    }
}