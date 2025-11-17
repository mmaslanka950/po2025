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
        // np. obroty biegu jałowego
        obroty = 800;
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
    public void ustawObroty(int obroty) {
        if (obroty < 0) {
            this.obroty = 0;
        } else if (obroty > maxObroty) {
            this.obroty = maxObroty;
        } else {
            this.obroty = obroty;
        }
    }
}