package com.example.animacia_lopta;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML
    private Pane root;

    private Lopta ball;

    @FXML
    public void initialize() {
        ball = new Lopta(50, 50, root);
        root.getChildren().add(ball);
    }
}