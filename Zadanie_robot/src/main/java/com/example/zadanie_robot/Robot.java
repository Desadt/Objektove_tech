package com.example.zadanie_robot;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Robot extends Canvas {

    private GraphicsContext gc;
    private Pane plocha;

    private double x = 100;
    private double y = 100;

    private double speed = 3;
    private boolean automatic = false;

    // 0 = hore, 1 = vpravo, 2 = dole, 3 = vlavo
    private int direction = 1;

    public Robot(Pane plocha) {
        super(60, 40);

        this.plocha = plocha;
        gc = getGraphicsContext2D();

        setFocusTraversable(true);

        plocha.getChildren().add(this);

        draw();
        updatePosition();

        setOnKeyPressed(e -> {
            if (!automatic) {
                KeyCode key = e.getCode();

                switch (key) {
                    case W:
                        direction = 0;
                        y -= speed;
                        break;

                    case D:
                        direction = 1;
                        x += speed;
                        break;

                    case S:
                        direction = 2;
                        y += speed;
                        break;

                    case A:
                        direction = 3;
                        x -= speed;
                        break;

                    default:
                        return;
                }

                checkBorders();
                updatePosition();
                draw();

                e.consume();
            }
        });

        setOnMouseClicked(e -> {
            automatic = !automatic;
            requestFocus();
        });

        AnimationTimer timer = new AnimationTimer() {

            @Override
            public void handle(long now) {

                if (automatic) {
                    autoMove();
                }
            }
        };

        timer.start();
    }

    private void draw() {

        gc.clearRect(0, 0, getWidth(), getHeight());

        gc.setFill(Color.DODGERBLUE);
        gc.fillRect(0, 0, 60, 40);

        gc.setFill(Color.YELLOW);

        switch (direction) {

            case 0:
                gc.fillRect(20, 0, 20, 6);
                break;

            case 1:
                gc.fillRect(54, 10, 6, 20);
                break;

            case 2:
                gc.fillRect(20, 34, 20, 6);
                break;

            case 3:
                gc.fillRect(0, 10, 6, 20);
                break;
        }
    }

    private void updatePosition() {
        setLayoutX(x);
        setLayoutY(y);
    }

    private void checkBorders() {

        double maxX = Math.max(0,
                plocha.getWidth() - getWidth());

        double maxY = Math.max(0,
                plocha.getHeight() - getHeight());

        if (x < 0) {
            x = 0;
        }

        if (y < 0) {
            y = 0;
        }

        if (x > maxX) {
            x = maxX;
        }

        if (y > maxY) {
            y = maxY;
        }
    }

    private void autoMove() {

        double maxX = Math.max(0,
                plocha.getWidth() - getWidth());

        double maxY = Math.max(0,
                plocha.getHeight() - getHeight());

        switch (direction) {

            case 0:
                y -= speed;

                if (y <= 0) {
                    y = 0;
                    direction = 2;
                }
                break;

            case 1:
                x += speed;

                if (x >= maxX) {
                    x = maxX;
                    direction = 3;
                }
                break;

            case 2:
                y += speed;

                if (y >= maxY) {
                    y = maxY;
                    direction = 0;
                }
                break;

            case 3:
                x -= speed;

                if (x <= 0) {
                    x = 0;
                    direction = 1;
                }
                break;
        }

        checkBorders();
        updatePosition();
        draw();
    }

    public void toggleAutomatic() {
        automatic = !automatic;
        requestFocus();
    }

    public boolean isAutomatic() {
        return automatic;
    }
}