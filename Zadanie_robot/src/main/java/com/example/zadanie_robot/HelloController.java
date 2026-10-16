package com.example.zadanie_robot;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML
    private Pane plocha;

    @FXML
    private Button btnAuto;

    private Robot robot;

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            robot = new Robot(plocha);
            robot.requestFocus();
        });
    }

    @FXML
    private void changeMode() {

        robot.toggleAutomatic();

        if (robot.isAutomatic()) {
            btnAuto.setText("Manuálny režim");
        } else {
            btnAuto.setText("Automatický režim");
        }
    }
}