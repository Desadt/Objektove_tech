package com.example.zadanie_1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class MySquare extends GeometricShape {

    public MySquare(Pane plocha) {
        super(plocha);
        draw();
    }

    @Override
    protected void draw() {
        gc.setFill(Color.ORANGE);
        gc.fillRect(10, 10, 40, 40);
    }

    @Override
    protected void move() {
        setTranslateY(Math.sin(time) * 40);
    }
}