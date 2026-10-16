package com.example.zadanie_weather;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Raindrop extends WeatherObject {

    private double speed = 220;
    private static boolean stopped = false;

    public Raindrop(Pane plocha) {
        super(plocha, 15, 30);
        draw();
    }

    @Override
    protected void draw() {
        gc.setFill(Color.DODGERBLUE);
        double[] xPoints = {7, 0, 7, 14};
        double[] yPoints = {0, 20, 29, 20};
        gc.fillPolygon(xPoints, yPoints, 4);
    }

    @Override
    protected void move(double dt) {
        if (stopped) return;
        y += speed * dt;
        updatePosition();
        if (y > plocha.getHeight()) remove();
    }

    public static void toggleRain() {
        stopped = !stopped;
    }

    public static boolean isStopped() {
        return stopped;
    }
}