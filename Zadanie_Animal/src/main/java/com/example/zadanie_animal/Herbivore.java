package com.example.zadanie_animal;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Herbivore extends Animal {

    private double startX, startY;
    private double size = 100;
    private int direction = 0;

    public Herbivore(Pane plocha) {
        super(plocha);

        startX = x;
        startY = y;

        draw();
    }

    @Override
    protected void draw() {
        gc.setFill(Color.GREEN);
        gc.fillOval(5, 5, 30, 30);

        gc.setFill(Color.BLACK);
        gc.fillOval(24, 12, 5, 5);
    }

    @Override
    protected void move(double dt) {

        double step = speed * 60 * dt;

        switch (direction) {
            case 0:
                x += step;
                if (x >= startX + size) {
                    x = startX + size;
                    direction = 1;
                }
                break;

            case 1:
                y += step;
                if (y >= startY + size) {
                    y = startY + size;
                    direction = 2;
                }
                break;

            case 2:
                x -= step;
                if (x <= startX) {
                    x = startX;
                    direction = 3;
                }
                break;

            case 3:
                y -= step;
                if (y <= startY) {
                    y = startY;
                    direction = 0;
                }
                break;
        }

        updatePosition();
    }
}