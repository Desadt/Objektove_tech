package com.example.zadanie_1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MyCircle extends GeometricShape {

    private Color color = Color.GREEN;

    public MyCircle(Pane plocha) {
        super(plocha);
        draw();
    }

    @Override
    protected void draw() {
        gc.clearRect(0, 0, 60, 60);
        gc.setFill(color);
        gc.fillOval(10, 10, 40, 40);
    }

    @Override
    protected void move() {
        setTranslateX(Math.cos(time) * 30);
        setTranslateY(Math.sin(time) * 30);
    }

    public void changeColor() {
        color = Color.BLUE;
        draw();
    }

    public static void changeAllColors(Pane plocha) {
        for (javafx.scene.Node node : plocha.getChildren()) {
            if (node instanceof MyCircle) {
                ((MyCircle) node).changeColor();
            }
        }
    }
}