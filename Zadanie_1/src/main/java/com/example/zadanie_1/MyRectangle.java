package com.example.zadanie_1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MyRectangle extends GeometricShape {

    public MyRectangle(Pane plocha) {
        super(plocha);
        draw();
    }

    @Override
    protected void draw() {
        gc.setFill(Color.RED);
        gc.fillRect(5, 15, 50, 30);
    }

    @Override
    protected void move() {
        setTranslateX(Math.sin(time) * 40);
    }
}