package com.example.nakupnyzoznam;

public class ShoppingItem {
    private String nazov;
    private int pocetKusov;

    public ShoppingItem(String nazov, int pocetKusov){
        this.nazov = nazov;
        this.pocetKusov = pocetKusov;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public int getPocetKusov() {
        return pocetKusov;
    }

    public void setPocetKusov(int pocetKusov) {
        this.pocetKusov = pocetKusov;
    }

    @Override
    public String toString() {
        return nazov + " – " + pocetKusov + " ks";
    }
}
