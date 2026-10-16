package com.example.zadanie_animal;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import java.util.Random;

public abstract class Animal extends Canvas {

    protected GraphicsContext gc;
    protected Pane plocha;

    protected double x, y;
    protected double speed = 2;

    private static boolean stopped = false;
    private static final Random random = new Random();

    public Animal(Pane plocha) {
        super(40, 40);

        this.plocha = plocha;
        gc = getGraphicsContext2D();

        x = random.nextDouble()
                * Math.max(1, plocha.getWidth() - 40);

        y = random.nextDouble()
                * Math.max(1, plocha.getHeight() - 40);

        setLayoutX(x);
        setLayoutY(y);

        plocha.getChildren().add(this);

        AnimationTimer timer = new AnimationTimer() {
            private long lastTime = 0;

            @Override
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }

                double dt = Math.min(
                        (now - lastTime) / 1_000_000_000.0,
                        0.05
                );

                lastTime = now;

                if (!stopped) {
                    move(dt);
                }
            }
        };

        timer.start();
    }

    protected abstract void draw();

    protected abstract void move(double dt);

    protected void updatePosition() {
        setLayoutX(x);
        setLayoutY(y);
    }

    public static void toggleStop() {
        stopped = !stopped;
    }

    public static boolean isStopped() {
        return stopped;
    }
}