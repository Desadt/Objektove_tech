package com.example.zadanie_animal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML
    private Pane plocha;

    @FXML
    private Button btnStop;

    @FXML
    private void addHerbivore() {
        new Herbivore(plocha);
    }

    @FXML
    private void addCarnivore() {
        new Carnivore(plocha);
    }

    @FXML
    private void changeDirection() {
        Carnivore.changeAllDirections(plocha);
    }

    @FXML
    private void stopAnimals() {
        Animal.toggleStop();

        if (Animal.isStopped()) {
            btnStop.setText("Spustiť");
        } else {
            btnStop.setText("Zastaviť");
        }
    }
}