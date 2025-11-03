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
    //tutaj jescze trzba dodac pare rzeczy albo cos pozmieniac w tym kodzie!!!!!!!!!!!!



        stanWlaczenia = false;
    }

    public void jedzDo(Pozycja cel) {
        if (stanWlaczenia) {
            this.aktualnaPozycja = cel;
        }
    }

    public Pozycja getAktPozycja() {
        return aktualnaPozycja;
    }

    public double getWaga() {
        return silnik.getWaga() + skrzynia.getWaga();
    }

    public double getAktPredkosc() {
        double v = silnik.getObroty() * 0.01;
        return Math.min(v, predkoscMax);
    }
}