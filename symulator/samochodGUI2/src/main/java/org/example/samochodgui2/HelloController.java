package org.example.samochodgui2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HelloController {

    @FXML private ComboBox<String> samochodComboBox;
    @FXML private TextField modelField;
    @FXML private TextField nrRejField;
    @FXML private TextField samochodWagaField;
    @FXML private TextField predkoscField;

    @FXML private TextField skrzyniaNazwaField;
    @FXML private TextField skrzyniaCenaField;
    @FXML private TextField skrzyniaWagaField;
    @FXML private TextField biegField;


    @FXML private TextField silnikNazwaField;
    @FXML private TextField silnikCenaField;
    @FXML private TextField silnikWagaField;
    @FXML private TextField obrotyField;


    @FXML private TextField sprzegloNazwaField;
    @FXML private TextField sprzegloCenaField;
    @FXML private TextField sprzegloWagaField;
    @FXML private TextField sprzegloStanField;


    @FXML private ImageView carImage;
    @FXML private AnchorPane mapPane;



    @FXML
    private void onWlaczSamochod() {
        System.out.println("Włącz samochód");
    }

    @FXML
    private void onWylaczSamochod() {
        System.out.println("Wyłącz samochód");
    }

    @FXML
    private void onExtraButton() {
        System.out.println("Button kliknięty");
    }

    @FXML
    private void onZwiekszBieg() {
        System.out.println("Zwiększ bieg");
    }

    @FXML
    private void onZmniejszBieg() {
        System.out.println("Zmniejsz bieg");
    }

    @FXML
    private void onDodajGazu() {
        System.out.println("Dodaj gazu");
    }

    @FXML
    private void onUjmijGazu() {
        System.out.println("Ujmij gazu");
    }

    @FXML
    private void onWcisnijSprzeglo() {
        System.out.println("Wciśnij sprzęgło");
    }

    @FXML
    private void onZwolnijSprzeglo() {
        System.out.println("Zwolnij sprzęgło");
    }

    @FXML
    private void onDodajNowySamochod() {
        System.out.println("Dodaj nowy samochód");
    }

    @FXML
    private void onUsunSamochod() {
        System.out.println("Usuń samochód");
    }


    @FXML
    private void onMapClicked(MouseEvent e) {
        // współrzędne kliknięcia względem mapPane
        double x = e.getX();
        double y = e.getY();

        System.out.println("Klik na mapie: x=" + x + ", y=" + y);
    }
}






