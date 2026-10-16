package com.example.zadanie_weather;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane plocha;
    @FXML private Button btnRain;
    @FXML private void initialize() {
        WeatherObject.startAnimation();
    }

    @FXML private void addCloud() {
        new Cloud(plocha);
    }

    @FXML private void addRaindrop() {
        new Raindrop(plocha);
    }

    @FXML private void addSnowflake() {
        new Snowflake(plocha);
    }

    @FXML private void stopRain() {
        Raindrop.toggleRain();
        if (Raindrop.isStopped()) {
            btnRain.setText("Spustiť dážď");
        } else {
            btnRain.setText("Zastaviť dážď");
        }
    }

    @FXML private void changeClouds() {
        Cloud.changeAllColors(plocha);
    }

    @FXML private void moveLeft() {
        WeatherObject.moveAllLeft();
    }
}