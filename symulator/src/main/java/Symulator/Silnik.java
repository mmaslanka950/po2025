package Symulator;

public class Silnik extends Komponent {

    private int maxObroty;
    private int obroty;

    public Silnik(String nazwa, double waga, double cena, int maxObroty) {
        super(nazwa, waga, cena);
        this.maxObroty = maxObroty;
        this.obroty = 0;
    }
    public void uruchom() {
        obroty = 678;
    }
    public void zatrzymaj() {
        obroty = 0;
    }
    public int getMaxObroty() {
        return maxObroty;
    }
    public int getObroty() {
        return obroty;
    }
}