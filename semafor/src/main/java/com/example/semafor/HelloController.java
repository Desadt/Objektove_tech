package com.example.semafor;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML private Pane root;
    Semafor s;

    @FXML protected void draw(){
        s = new Semafor();
        root.getChildren().add(s);
    }

    @FXML protected void zmenStav(){
        s.ZmenStav();
    }

    @FXML protected void auto(){
        s.start();
    }

    @FXML protected void turnOff(){
        s.vypnutie();
    }
}
