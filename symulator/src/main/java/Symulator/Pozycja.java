package Symulator;

public class Pozycja {
    private double x;
    private double y;

    public Pozycja() {
        x = 0;
        y = 0;
    }
    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void aktualizujPozycje(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }
    
    public String getPozycja() {
        return "(" + x + ", " + y + ")";
    }
}