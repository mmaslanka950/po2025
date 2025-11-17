package Symulator;

public class Samochod {
    private boolean stanWlaczenia;
    private String nrRejest;
    private String model;
    private double predkoscMax;

    private Pozycja aktualnaPozycja;
    private Silnik silnik;
    private SkrzyniaBiegow skrzynia;

    public Samochod(String nrRejest, String model, double predkoscMax,
                    Silnik silnik, SkrzyniaBiegow skrzynia) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.predkoscMax = predkoscMax;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.aktualnaPozycja = new Pozycja();
        this.stanWlaczenia = false;
    }
    public void wlacz() {
        silnik.uruchom();
        stanWlaczenia = true;
    }

    public void wylacz() {
        silnik.zatrzymaj();
        skrzynia.naLuz();      // tu dochodzi zerowanie biegu
        stanWlaczenia = false;
    }

    public void jedzDo(Pozycja cel) {
        if (stanWlaczenia) {
            this.aktualnaPozycja = cel;
        }
    }
    public void jedz(double deltaX, double deltaY) {
        if (stanWlaczenia) {
            aktualnaPozycja.aktualizujPozycje(deltaX, deltaY);
        }
    }

    public Pozycja getAktPozycja() {
        return aktualnaPozycja;
    }

    public double getWaga() {
        return silnik.getWaga() + skrzynia.getWaga();
    }

    public double getAktPredkosc() {
        double v = silnik.getObroty() * skrzynia.getAktPrzelozenie() * 0.001;
        return Math.min(v, predkoscMax);
    }
    public String getOpisStanu() {
        return "Samochod " + nrRejest + " (" + model + ")\n" +
                " wlaczony: " + stanWlaczenia + "\n" +
                " pozycja: " + aktualnaPozycja.getPozycja() + "\n" +
                " bieg: " + skrzynia.getAktBieg() + "\n" +
                " obroty: " + silnik.getObroty() + "\n" +
                " predkosc: " + getAktPredkosc();
    }
}