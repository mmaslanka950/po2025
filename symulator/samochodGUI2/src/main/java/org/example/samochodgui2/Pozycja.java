package org.example.samochodgui2;

public class Pozycja {
    private double x;
    private double y;

    public Pozycja() {
        x = 0;
        y = 0;
    }

    public void aktualizujPozycje(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
    
    public String getPozycja() {
        return "(" + x + ", " + y + ")";
    }
}