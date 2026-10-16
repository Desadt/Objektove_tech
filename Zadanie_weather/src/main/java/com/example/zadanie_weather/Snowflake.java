package com.example.zadanie_weather;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Snowflake extends WeatherObject {

    private double speed = 65;
    private double time = 0;

    public Snowflake(Pane plocha) {
        super(plocha, 30, 30);
        draw();
    }

    @Override
    protected void draw() {
        gc.setStroke(Color.DEEPSKYBLUE);
        gc.setLineWidth(2);
        gc.strokeLine(15, 0, 15, 30);
        gc.strokeLine(0, 15, 30, 15);
        gc.strokeLine(4, 4, 26, 26);
        gc.strokeLine(26, 4, 4, 26);
    }

    @Override
    protected void move(double dt) {
        time += dt;
        y += speed * dt;
        setLayoutX(x + Math.sin(time * 3) * 15);
        setLayoutY(y);
        if (y > plocha.getHeight()) remove();
    }

    @Override
    protected void updatePosition() {
        setLayoutX(x + Math.sin(time * 3) * 15);
        setLayoutY(y);
    }
}