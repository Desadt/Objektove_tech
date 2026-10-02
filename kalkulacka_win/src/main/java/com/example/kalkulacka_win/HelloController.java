package com.example.kalkulacka_win;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML private Label displayLabel;
    @FXML private Label saveLabel;
    private String operator = "";

    @FXML private void Cislo(ActionEvent event) {
        Button button = (Button) event.getSource();
        String number = button.getText();

        saveLabel.setText(saveLabel.getText() + number);
    }
    @FXML private void addition() {
        nastavOperaciu("+");
    }
    @FXML private void substraction() {
        nastavOperaciu("-");
    }
    @FXML private void multiply() {
        nastavOperaciu("x");
    }
    @FXML private void division() {
        nastavOperaciu("/");
    }
    @FXML private void power() {
        nastavOperaciu("^");
    }
    private void nastavOperaciu(String znak) {
        if (operator.isEmpty()) {
            saveLabel.setText(saveLabel.getText() + " " + znak + " ");
            operator = znak;
        }
    }
    @FXML private void equals() {
        String expression = saveLabel.getText();
        String[] values = expression.split(" ");

        if (values.length < 3) {
            return;
        }

        double firstNumber = Double.parseDouble(values[0]);
        double secondNumber = Double.parseDouble(values[2]);
        double result;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "x":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    displayLabel.setText("Chyba");
                    return;
                }
                result = firstNumber / secondNumber;
                break;
            case "^":
                result = Math.pow(firstNumber, secondNumber);
                break;
            default:
                return;
        }
        String s;
        if (result == (long) result) {
            s = String.format("%.6f",result);
            displayLabel.setText(s);
        } else {
            s = String.format("%.6f",result);
            displayLabel.setText(s);
        }
        operator = "";
    }
    @FXML private void clear() {
        displayLabel.setText("");
        saveLabel.setText("");
        operator = "";
    }
}