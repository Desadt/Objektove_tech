package com.example.zadanie_weather;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;

public abstract class WeatherObject extends Canvas {

    protected GraphicsContext gc;
    protected Pane plocha;
    protected double x, y;
    protected static Random random = new Random();
    private static ArrayList<WeatherObject> objekty = new ArrayList<>();

    public WeatherObject(Pane plocha, int w, int h) {
        super(w, h);
        this.plocha = plocha;
        gc = getGraphicsContext2D();
        x = random.nextDouble() * Math.max(1, plocha.getWidth() - w);
        y = random.nextDouble() * Math.max(1, plocha.getHeight() - h);
        updatePosition();
        plocha.getChildren().add(this);
        objekty.add(this);
    }

    protected abstract void draw();

    protected abstract void move(double dt);

    protected void updatePosition() {
        setLayoutX(x);
        setLayoutY(y);
    }

    protected void remove() {
        plocha.getChildren().remove(this);
        objekty.remove(this);
    }

    public static void moveAllLeft() {
        for (WeatherObject objekt : objekty) {
            objekt.x -= 20;
            objekt.updatePosition();
        }
    }

    public static void startAnimation() {
        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = 0;
            @Override
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }
                double dt = Math.min((now - lastTime) / 1_000_000_000.0, 0.05);
                lastTime = now;
                for (WeatherObject objekt :
                        new ArrayList<>(objekty)) {
                    objekt.move(dt);
                }
            }
        };
        timer.start();
    }
}