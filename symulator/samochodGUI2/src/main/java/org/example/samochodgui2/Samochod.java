package org.example.samochodgui2;

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
  public String getNrRejestr() {
        return nrRejest;
    }
    public String getModel() {
        return model;
    }
    public double getPredkoscMax() {
        return predkoscMax;// to mozer sie przyda na razie nie uzywam
    }
    public Silnik getSilnik() {
        return silnik;
    }
    public SkrzyniaBiegow getSkrzynia() {
        return skrzynia;
    }
    public Sprzeglo getSprzeglo() {
        return skrzynia != null ? skrzynia.getSprzeglo() : null;
    }
    public Pozycja getAktPozycja() {
        return aktualnaPozycja;// to mozer sie przyda na razie nie uzywam
    }
    public double getWaga() {
        double w = 0.0;
        if (silnik != null) w += silnik.getWaga();
        if (skrzynia != null) w += skrzynia.getWaga();
        if (getSprzeglo() != null) w += getSprzeglo().getWaga();
        return w;
    }
    public void wlacz() {
        if (silnik != null) {
            silnik.uruchom();
        }
        stanWlaczenia = true;
    }

    public void wylacz() {
        if (silnik != null) {
            silnik.zatrzymaj();
        }
        if (skrzynia != null) {
            skrzynia.naLuz();
        }
        stanWlaczenia = false;
    }

    public void jedzDo(Pozycja cel) {// to mozer sie przyda na razie nie uzywam
        if (stanWlaczenia && cel != null) {
            this.aktualnaPozycja = cel;
        }
    }
    public void jedz(double deltaX, double deltaY) {
        if (stanWlaczenia && aktualnaPozycja != null) {
            aktualnaPozycja.aktualizujPozycje(deltaX, deltaY);
        }
    }

    public double getAktPredkosc() {
        if (silnik == null || skrzynia == null) return 0.0;
        double v = silnik.getObroty() * skrzynia.getAktPrzelozenie() * 0.001;
        return Math.min(v, predkoscMax);
    }

    public void przyspiesz() {
        if (!stanWlaczenia || silnik == null) return;
        int noweObroty = silnik.getObroty() + 500;
        silnik.ustawObroty(noweObroty);
    }

    public void zwolnij() {
        if (!stanWlaczenia || silnik == null) return;
        int noweObroty = silnik.getObroty() - 500;
        silnik.ustawObroty(noweObroty);
    }

}