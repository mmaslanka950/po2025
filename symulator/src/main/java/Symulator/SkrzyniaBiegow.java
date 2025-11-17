package Symulator;

public class SkrzyniaBiegow extends Komponent {
    private int aktualnyBieg;
    private int iloscBiegow;
    private double aktualnePrzelozenie;
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, double waga, double cena,
                          int iloscBiegow, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
        this.aktualnyBieg = 0;
        this.aktualnePrzelozenie = 0.0;
    }
    public void zwiekszBieg() {
        if (sprzeglo.isStanSprzegla() && aktualnyBieg < iloscBiegow) {
            aktualnyBieg++;
            przeliczPrzelozenie();
        }
    }
    public void zmniejszBieg() {
        if (sprzeglo.isStanSprzegla() && aktualnyBieg > 0) {
            aktualnyBieg--;
            przeliczPrzelozenie();
        }
    }
    public void naLuz() {
        aktualnyBieg = 0;
        przeliczPrzelozenie();
    }
    public int getAktBieg() {
        return aktualnyBieg;
    }
    public double getAktPrzelozenie() {
        return aktualnePrzelozenie;
    }
    private void przeliczPrzelozenie() {
        this.aktualnePrzelozenie = aktualnyBieg * 0.5;
    }
}