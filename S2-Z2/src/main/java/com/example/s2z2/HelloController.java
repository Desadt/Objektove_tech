package com.example.s2z2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML private TextField tf_mm, tf_cm, tf_m, tf_km;

    @FXML protected void calculate(){
        if(!tf_mm.getText().equals("0")) {
            if (tf_mm.getText().contains(".")) {
                try {
                    double a = Double.parseDouble(tf_mm.getText());
                    tf_cm.setText("" + a / 10.0);
                    tf_m.setText("" + a / 1000.0);
                    tf_km.setText("" + a / 1000000.0);
                } catch (NumberFormatException e) {
                    tf_cm.setText("Bed format");
                    tf_m.setText("Bed format");
                    tf_km.setText("Bed format");
                }
            } else {
                try {
                    int a = Integer.parseInt(tf_mm.getText());
                    tf_cm.setText("" + a / 10.0);
                    tf_m.setText("" + a / 1000.0);
                    tf_km.setText("" + a / 1000000.0);
                }catch (NumberFormatException e){
                    tf_cm.setText("Bed format");
                    tf_m.setText("Bed format");
                    tf_km.setText("Bed format");
                }
            }
        } else if (!tf_cm.getText().equals("0")) {
            if (tf_cm.getText().contains(".")) {
                try {
                    double a = Double.parseDouble(tf_cm.getText());
                    tf_mm.setText("" + a * 10.0);
                    tf_m.setText("" + a / 100.0);
                    tf_km.setText("" + a / 100000.0);
                }catch (NumberFormatException e){
                    tf_mm.setText("Bad Format");
                    tf_m.setText("Bad Format");
                    tf_km.setText("Bad Format");
                }
            } else {
                try {
                    int a = Integer.parseInt(tf_cm.getText());
                    tf_mm.setText("" + a * 10.0);
                    tf_m.setText("" + a / 100.0);
                    tf_km.setText("" + a / 100000.0);
                }catch (NumberFormatException e){
                    tf_mm.setText("Bad Format");
                    tf_m.setText("Bad Format");
                    tf_km.setText("Bad Format");
                }
            }
        } else if (!tf_m.getText().equals("0")) {
            if (tf_m.getText().contains(".")) {
                try {
                    double a = Double.parseDouble(tf_m.getText());
                    tf_mm.setText("" + a * 1000.0);
                    tf_cm.setText("" + a * 100.0);
                    tf_km.setText("" + a / 1000.0);
                }catch (NumberFormatException e){
                    tf_mm.setText("Bad format");
                    tf_cm.setText("Bad format");
                    tf_km.setText("Bad format");
                }
            } else {
                try {
                    int a = Integer.parseInt(tf_m.getText());
                    tf_mm.setText("" + a * 1000.0);
                    tf_cm.setText("" + a * 100.0);
                    tf_km.setText("" + a / 1000.0);
                }catch (NumberFormatException e){
                    tf_mm.setText("Bad format");
                    tf_cm.setText("Bad format");
                    tf_km.setText("Bad format");
                }
            }
        } else if (!tf_km.getText().equals("0")) {
            if (tf_km.getText().contains(".")) {
                try {
                    double a = Double.parseDouble(tf_km.getText());
                    tf_mm.setText("" + a * 1000000.0);
                    tf_cm.setText("" + a * 100000.0);
                    tf_m.setText("" + a * 1000.0);
                }catch (NumberFormatException e){
                    tf_mm.setText("Bad format");
                    tf_cm.setText("Bad format");
                    tf_m.setText("Bad format");
                }
            } else {
                try {
                    int a = Integer.parseInt(tf_km.getText());
                    tf_mm.setText("" + a * 1000000.0);
                    tf_cm.setText("" + a * 100000.0);
                    tf_m.setText("" + a * 1000.0);
                }catch (NumberFormatException e){
                    tf_mm.setText("Bad format");
                    tf_cm.setText("Bad format");
                    tf_m.setText("Bad format");
                }
            }
        }
//        tf_mm.setDisable(true);
//        tf_cm.setDisable(true);
//        tf_m.setDisable(true);
//        tf_km.setDisable(true);
        tf_mm.setEditable(false);
        tf_cm.setEditable(false);
        tf_m.setEditable(false);
        tf_km.setEditable(false);
    }
    @FXML protected void clear(){
//        tf_mm.setDisable(false);
//        tf_cm.setDisable(false);
//        tf_m.setDisable(false);
//        tf_km.setDisable(false);
        tf_mm.setEditable(true);
        tf_cm.setEditable(true);
        tf_m.setEditable(true);
        tf_km.setEditable(true);
        tf_mm.setText("0");
        tf_cm.setText("0");
        tf_m.setText("0");
        tf_km.setText("0");
    }
}
