package Symulator;

public class Sprzeglo extends Komponent {

    private boolean stanSprzegla;
    public Sprzeglo(String nazwa, double waga, double cena) {
        super(nazwa, waga, cena);
        this.stanSprzegla = false;
    }

    public void wcisnij() {
        stanSprzegla = true;
    }

    public void zwolnij() {
        stanSprzegla = false;
    }
    public boolean isStanSprzegla() {
        return stanSprzegla;
    }
}