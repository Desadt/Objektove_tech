package com.example.animacia_auto;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Auto extends Canvas {

    private GraphicsContext gc;
    private Pane ploch;
    private Timeline casovac;
    private boolean auto = true;
    private boolean ide = true;
    private int smer = 1;
    private int rychlost = 3;

    public Auto(double x, double y, Pane ploch) {
        super(80, 40);
        this.ploch = ploch;
        setLayoutX(x);
        setLayoutY(y);
        gc = getGraphicsContext2D();
        vykresli();

        casovac = new Timeline(
                new KeyFrame(Duration.millis(30), e -> pohniAutomaticky()));
        casovac.setCycleCount(Animation.INDEFINITE);
        casovac.play();

        setOnKeyPressed(evt -> spracuj(evt));
        setFocusTraversable(true);
        requestFocus();

        setOnMouseClicked(evt -> klik());
    }

    private void vykresli() {
        gc.setFill(Color.RED);
        gc.fillRect(0, 0, getWidth(), getHeight());
    }

    public boolean isauto() {
        return auto;
    }

    public void prepniRezim() {
        auto = !auto;
    }

    private void klik() {
        if (ide) {
            casovac.stop();
            ide = false;
        } else {
            casovac.play();
            ide = true;
        }
        requestFocus();
    }
    private void pohniAutomaticky() {
        if (!auto) {
            return;
        }

        setLayoutX(getLayoutX() + smer * rychlost);

        if (getLayoutX() + getWidth() >= ploch.getWidth()) {
            smer = -1;
        }
        if (getLayoutX() <= 0) {
            smer = 1;
        }
    }

    private void spracuj(KeyEvent evt) {
        if (auto) {
            return;
        }

        KeyCode k = evt.getCode();
        if (k == KeyCode.LEFT) {
            setLayoutX(getLayoutX() - 10);
        }
        if (k == KeyCode.RIGHT) {
            setLayoutX(getLayoutX() + 10);
        }
        if (getLayoutX() < 0) {
            setLayoutX(0);
        }
        if (getLayoutX() + getWidth() > ploch.getWidth()) {
            setLayoutX(ploch.getWidth() - getWidth());
        }
        if (getLayoutY() < 0) {
            setLayoutY(0);
        }
        if (getLayoutY() + getHeight() > ploch.getHeight()) {
            setLayoutY(ploch.getHeight() - getHeight());
        }
    }
}