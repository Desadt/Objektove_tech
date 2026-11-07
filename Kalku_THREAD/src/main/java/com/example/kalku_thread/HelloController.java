package com.example.kalku_thread;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.math.BigInteger;

public class HelloController {
    @FXML private TextField vstup;
    @FXML private TextArea faktOut, mocOut, fibOut;
    @FXML private ProgressBar faktPogress, mocPogress, fiboPogress;

    @FXML private void initialize(){
        faktPogress.setProgress(0.0);
        mocPogress.setProgress(0.0);
        fiboPogress.setProgress(0.0);
    }

    @FXML protected void onStart(){
        faktOut.clear();
        mocOut.clear();
        fibOut.clear();
        int cislo;
        try {
            cislo = Integer.parseInt(vstup.getText().trim());
            if(cislo < 1 || cislo > 100){
                vstup.setText("Zadajte cilo od 1 do 100");
                return;
            }
        }
        catch(NumberFormatException e) {
            vstup.setText("Zadajte cislo");
            return;
        }
        faktPogress.setProgress(0.0);
        mocPogress.setProgress(0.0);
        fiboPogress.setProgress(0.0);

        faktorial(cislo);
        mocnina(cislo);
        fibbonaci(cislo);
    }

    private void faktorial(int n){
        Runnable myRun = new Runnable() {
            @Override
            public void run() {
                BigInteger sum = BigInteger.ONE;
                for(int i = 1; i <= n; i++){
                    if(Thread.currentThread().isInterrupted()) return;
                    sum = sum.multiply(BigInteger.valueOf(i));
                    String text = sum.toString();
                    int pom = i;
                    Platform.runLater(() -> {
                        faktOut.appendText(text+"\n");
                        faktPogress.setProgress(pom/(double)n);
                    });
                    if(!pauza()) return;
                }
            }
        };
        Thread backroundThread = new Thread(myRun);
        backroundThread.setDaemon(true);
        backroundThread.start();
    }

    private void fibbonaci(int n){
        Runnable myRun = new Runnable() {
            @Override
            public void run() {
                BigInteger a = BigInteger.ZERO;
                BigInteger b = BigInteger.ONE;

                for(int i = 1; i <= n; i++){
                    if(Thread.currentThread().isInterrupted()) return;
                    BigInteger vys = a;
                    BigInteger dal = a.add(b);
                    a = b;
                    b = dal;
                    int pom = i;
                    String text = vys.toString();
                    Platform.runLater(() -> {
                        fibOut.appendText(text+"\n");
                        fiboPogress.setProgress(pom/(double)n);
                    });
                    if(!pauza()) return;
                }
            }
        };
        Thread backroundThread = new Thread(myRun);
        backroundThread.setDaemon(true);
        backroundThread.start();
    }

    private void mocnina(int n){
        Runnable myRun = new Runnable() {
            @Override
            public void run() {
                BigInteger vys = BigInteger.ONE;
                BigInteger zak = BigInteger.valueOf(n);
                for(int i = 1; i <= n; i++){
                    if(Thread.currentThread().isInterrupted()) return;
                    vys = vys.multiply(zak);
                    int pom = i;
                    String text = vys.toString();
                    Platform.runLater(() -> {
                        mocOut.appendText(text+"\n");
                        mocPogress.setProgress(pom/(double)n);
                    });
                    if(!pauza()) return;
                }
            }
        };
        Thread backroundThread = new Thread(myRun);
        backroundThread.setDaemon(true);
        backroundThread.start();
    }

    private boolean pauza(){
        try {
            Thread.sleep(500);
            return true;
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
