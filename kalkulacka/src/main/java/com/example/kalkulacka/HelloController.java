package com.example.kalkulacka;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField tf1, tf2;
    @FXML private Label lb1;
    @FXML protected void scitanie(){
        int a = Integer.parseInt(tf1.getText());
        int b = Integer.parseInt(tf2.getText());
        lb1.setText("Result: "+String.valueOf(a+b));
    }

    @FXML protected void odcitanie(){
        int a = Integer.parseInt(tf1.getText());
        int b = Integer.parseInt(tf2.getText());
        lb1.setText("Result: "+String.valueOf(a-b));
    }

    @FXML protected void nasobenie(){
        int a = Integer.parseInt(tf1.getText());
        int b = Integer.parseInt(tf2.getText());
        lb1.setText("Result: "+String.valueOf(a*b));
    }

    @FXML protected void celo_delenie(){
        int a = Integer.parseInt(tf1.getText());
        int b = Integer.parseInt(tf2.getText());
        lb1.setText("Result: "+String.valueOf(a/b));
    }

    @FXML protected void desat_delenie(){
        double a = Double.parseDouble(tf1.getText());
        double b = Double.parseDouble(tf2.getText());
        String s = String.format("Result: %.2f", a/b);
        lb1.setText(s);
    }
}