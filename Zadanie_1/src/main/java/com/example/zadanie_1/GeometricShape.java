package com.example.zadanie_1;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import java.util.Random;

public abstract class GeometricShape extends Canvas {

    protected GraphicsContext gc;
    protected double time = 0;

    private static final Random random = new Random();

    public GeometricShape(Pane plocha) {
        super(60, 60);

        gc = getGraphicsContext2D();

        double x = random.nextDouble()
                * Math.max(0, plocha.getWidth() - 120) + 30;

        double y = random.nextDouble()
                * Math.max(0, plocha.getHeight() - 120) + 30;

        setLayoutX(x);
        setLayoutY(y);

        plocha.getChildren().add(this);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                time += 0.03;
                move();
            }
        };

        timer.start();
    }

    protected abstract void draw();

    protected abstract void move();

    public static void moveAllDown(Pane plocha) {
        for (javafx.scene.Node node : plocha.getChildren()) {
            if (node instanceof GeometricShape) {
                node.setLayoutY(node.getLayoutY() + 30);
            }
        }
    }
}