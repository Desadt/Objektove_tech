package com.example.zadanie_1;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML
    private Pane plocha;

    @FXML
    private void addRectangle() {
        new MyRectangle(plocha);
    }

    @FXML
    private void addCircle() {
        new MyCircle(plocha);
    }

    @FXML
    private void addSquare() {
        new MySquare(plocha);
    }

    @FXML
    private void changeColors() {
        MyCircle.changeAllColors(plocha);
    }

    @FXML
    private void moveDown() {
        GeometricShape.moveAllDown(plocha);
    }
}