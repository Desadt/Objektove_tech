package com.example.zadanie_animal;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Carnivore extends Animal {

    private int direction = 0;
    private boolean reverse = false;

    public Carnivore(Pane plocha) {
        super(plocha);

        // Začiatok pohybu na hornom okraji
        y = 0;
        updatePosition();

        draw();
    }

    @Override
    protected void draw() {
        gc.setFill(Color.RED);
        gc.fillRect(5, 5, 30, 30);

        gc.setFill(Color.BLACK);
        gc.fillOval(25, 12, 5, 5);
    }

    @Override
    protected void move(double dt) {

        double step = speed * 60 * dt;

        double maxX = Math.max(0, plocha.getWidth() - getWidth());
        double maxY = Math.max(0, plocha.getHeight() - getHeight());

        if (!reverse) {
            switch (direction) {
                case 0:
                    x += step;
                    if (x >= maxX) {
                        x = maxX;
                        direction = 1;
                    }
                    break;

                case 1:
                    y += step;
                    if (y >= maxY) {
                        y = maxY;
                        direction = 2;
                    }
                    break;

                case 2:
                    x -= step;
                    if (x <= 0) {
                        x = 0;
                        direction = 3;
                    }
                    break;

                case 3:
                    y -= step;
                    if (y <= 0) {
                        y = 0;
                        direction = 0;
                    }
                    break;
            }
        } else {
            switch (direction) {
                case 0:
                    x -= step;
                    if (x <= 0) {
                        x = 0;
                        direction = 3;
                    }
                    break;

                case 3:
                    y += step;
                    if (y >= maxY) {
                        y = maxY;
                        direction = 2;
                    }
                    break;

                case 2:
                    x += step;
                    if (x >= maxX) {
                        x = maxX;
                        direction = 1;
                    }
                    break;

                case 1:
                    y -= step;
                    if (y <= 0) {
                        y = 0;
                        direction = 0;
                    }
                    break;
            }
        }

        updatePosition();
    }

    public void changeDirection() {
        reverse = !reverse;
    }

    public static void changeAllDirections(Pane plocha) {
        for (javafx.scene.Node node : plocha.getChildren()) {
            if (node instanceof Carnivore) {
                ((Carnivore) node).changeDirection();
            }
        }
    }
}