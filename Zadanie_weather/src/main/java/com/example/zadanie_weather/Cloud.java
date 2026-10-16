package com.example.zadanie_weather;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Cloud extends WeatherObject {

    private Color color = Color.LIGHTGRAY;
    private double speed = 30;

    public Cloud(Pane plocha) {
        super(plocha, 90, 50);
        y = random.nextDouble() * 50;
        updatePosition();
        draw();
    }

    @Override
    protected void draw() {
        gc.clearRect(0, 0, 90, 50);
        gc.setFill(color);
        gc.fillOval(5, 20, 45, 25);
        gc.fillOval(25, 5, 45, 35);
        gc.fillOval(50, 20, 35, 25);
    }

    @Override
    protected void move(double dt) {
        x += speed * dt;
        if (x > plocha.getWidth()) x = -getWidth();
        updatePosition();
    }

    public void changeColor() {
        color = Color.BLUE;
        draw();
    }

    public static void changeAllColors(Pane plocha) {
        for (javafx.scene.Node node : plocha.getChildren()) {
            if (node instanceof Cloud) {
                ((Cloud) node).changeColor();
            }
        }
    }
}