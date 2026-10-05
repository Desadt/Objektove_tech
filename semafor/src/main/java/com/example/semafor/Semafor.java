package com.example.semafor;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Semafor extends Canvas {
    private GraphicsContext gs;
    private int stav = 0;
    private Timeline t;
    private boolean bezi = false;
    private boolean turnOff = false;

    public Semafor(){
        super(150,400);
        setLayoutX(150);
        this.gs = getGraphicsContext2D();
        Vykresli(Color.RED,Color.BLACK,Color.BLACK);
        setOnMousePressed(e -> ZmenStav());
        t = new Timeline(new KeyFrame(Duration.seconds(1),e -> ZmenStav()));
        t.setCycleCount(Timeline.INDEFINITE);
    }

    public void vypnutie(){
        turnOff = !turnOff;
    }

    public void start(){
        if(bezi){
            t.stop();
            bezi = false;
        }
        else{
            t.play();
            bezi = true;
        }
    }

    private void Vykresli(Color red, Color yellow, Color green){
        gs.setFill(Color.GRAY);
        gs.fillRect(0,0,150,400);
        gs.setFill(red);
        gs.fillOval(30,30,80,80);
        gs.setFill(yellow);
        gs.fillOval(30,30+80+10,80,80);
        gs.setFill(green);
        gs.fillOval(30,30+80+10+80+10,80,80);
    }

    protected void ZmenStav(){
        if(turnOff){
            if(stav == 1) stav = 0;
            else stav++;
            switch (stav){
                case 0: Vykresli(Color.BLACK,Color.BLACK,Color.BLACK); break;
                case 1: Vykresli(Color.BLACK,Color.YELLOW,Color.BLACK); break;
            }
        }
        else{
            if(stav == 3) stav = 0;
            else stav++;
            switch (stav){
                case 0: Vykresli(Color.RED,Color.BLACK,Color.BLACK); break;
                case 1: Vykresli(Color.RED,Color.YELLOW,Color.BLACK); break;
                case 2: Vykresli(Color.BLACK,Color.BLACK,Color.GREEN); break;
                case 3: Vykresli(Color.BLACK,Color.YELLOW,Color.BLACK); break;
        }
        }
    }
}
