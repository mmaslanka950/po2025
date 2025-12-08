package org.example.samochodgui2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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


    private final ObservableList<Samochod> cars = FXCollections.observableArrayList();
    private Samochod currentCar;


    @FXML
    private void initialize() {
        System.out.println("HelloController initialized");


        modelField.setEditable(false);
        nrRejField.setEditable(false);
        samochodWagaField.setEditable(false);
        predkoscField.setEditable(false);

        skrzyniaNazwaField.setEditable(false);
        skrzyniaCenaField.setEditable(false);
        skrzyniaWagaField.setEditable(false);
        biegField.setEditable(false);

        silnikNazwaField.setEditable(false);
        silnikCenaField.setEditable(false);
        silnikWagaField.setEditable(false);
        obrotyField.setEditable(false);

        sprzegloNazwaField.setEditable(false);
        sprzegloCenaField.setEditable(false);
        sprzegloWagaField.setEditable(false);
        sprzegloStanField.setEditable(false);

        try {
            Image image = new Image(
                    getClass().getResource("/images/car.png").toExternalForm()
            );
            carImage.setImage(image);
            carImage.setFitWidth(30);
            carImage.setFitHeight(20);
            carImage.setTranslateX(0);
            carImage.setTranslateY(0);
        } catch (Exception e) {
            System.out.println("Nie udało się wczytać obrazka /images/car.png");
            e.printStackTrace();
        }


        Sprzeglo sprzeglo = new Sprzeglo("Sprzęgło standardowe", 8.0, 500.0);
        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow("Manualna 6-biegowa", 40.0, 2000.0, 6, sprzeglo);
        Silnik silnik = new Silnik("Benzyna 2.0", 120.0, 8000.0, 6500);
        Samochod s = new Samochod("K1 Friz", "Audi A9", 200.0, silnik, skrzynia);
        addCarToList(s);


        samochodComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal == null) return;
            for (Samochod car : cars) {
                String desc = car.getModel() + " (" + car.getNrRejestr() + ")";
                if (desc.equals(newVal)) {
                    currentCar = car;
                    refresh();
                    break;
                }
            }
        });

        refresh();
    }


    public void addCarToList(Samochod car) {
        cars.add(car);
        if (currentCar == null) {
            currentCar = car;
        }
        updateSamochodComboBox();
        refresh();
    }

    private void updateSamochodComboBox() {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Samochod s : cars) {
            items.add(s.getModel() + " (" + s.getNrRejestr() + ")");
        }
        samochodComboBox.setItems(items);

        if (currentCar != null) {
            String currentDesc = currentCar.getModel() + " (" + currentCar.getNrRejestr() + ")";
            samochodComboBox.getSelectionModel().select(currentDesc);
        }
    }

    private void refresh() {
        if (currentCar == null) {
            modelField.setText("");
            nrRejField.setText("");
            samochodWagaField.setText("");
            predkoscField.setText("");

            skrzyniaNazwaField.setText("");
            skrzyniaCenaField.setText("");
            skrzyniaWagaField.setText("");
            biegField.setText("");

            silnikNazwaField.setText("");
            silnikCenaField.setText("");
            silnikWagaField.setText("");
            obrotyField.setText("");

            sprzegloNazwaField.setText("");
            sprzegloCenaField.setText("");
            sprzegloWagaField.setText("");
            sprzegloStanField.setText("");
            return;
        }


        modelField.setText(currentCar.getModel());
        nrRejField.setText(currentCar.getNrRejestr());
        samochodWagaField.setText(String.format("%.1f", currentCar.getWaga()));
        predkoscField.setText(String.format("%.1f", currentCar.getAktPredkosc()));


        SkrzyniaBiegow skrzynia = currentCar.getSkrzynia();
        if (skrzynia != null) {
            skrzyniaNazwaField.setText(skrzynia.getNazwa());
            skrzyniaCenaField.setText(String.valueOf(skrzynia.getCena()));
            skrzyniaWagaField.setText(String.valueOf(skrzynia.getWaga()));
            biegField.setText(String.valueOf(skrzynia.getAktualnyBieg()));
        }


        Silnik silnik = currentCar.getSilnik();
        if (silnik != null) {
            silnikNazwaField.setText(silnik.getNazwa());
            silnikCenaField.setText(String.valueOf(silnik.getCena()));
            silnikWagaField.setText(String.valueOf(silnik.getWaga()));
            obrotyField.setText(String.valueOf(silnik.getObroty()));
        }


        Sprzeglo sprzeglo = currentCar.getSprzeglo();
        if (sprzeglo != null) {
            sprzegloNazwaField.setText(sprzeglo.getNazwa());
            sprzegloCenaField.setText(String.valueOf(sprzeglo.getCena()));
            sprzegloWagaField.setText(String.valueOf(sprzeglo.getWaga()));
            sprzegloStanField.setText(sprzeglo.isWcisniete() ? "Wciśnięte" : "Zwolnione");
        }
    }


    @FXML
    private void onWlaczSamochod() {
        System.out.println("Włącz samochód");
        if (currentCar != null) {
            currentCar.wlacz();
        }
        refresh();
    }

    @FXML
    private void onWylaczSamochod() {
        System.out.println("Wyłącz samochód");
        if (currentCar != null) {
            currentCar.wylacz();
        }
        refresh();
    }

    @FXML
    private void onExtraButton() {
        System.out.println("Button klikniety i cosik sie dzieje");
    }

    @FXML
    private void onZwiekszBieg() {
        System.out.println("Zwiększ bieg");
        if (currentCar != null && currentCar.getSkrzynia() != null) {
            currentCar.getSkrzynia().zwiekszBieg();
        }
        refresh();
    }

    @FXML
    private void onZmniejszBieg() {
        System.out.println("Zmniejsz bieg");
        if (currentCar != null && currentCar.getSkrzynia() != null) {
            currentCar.getSkrzynia().zmniejszBieg();
        }
        refresh();
    }

    @FXML
    private void onDodajGazu() {
        System.out.println("Dodaj gazu");
        if (currentCar != null) {
            currentCar.przyspiesz();
        }
        refresh();
    }

    @FXML
    private void onUjmijGazu() {
        System.out.println("Ujmij gazu");
        if (currentCar != null) {
            currentCar.zwolnij();
        }
        refresh();
    }

    @FXML
    private void onWcisnijSprzeglo() {
        System.out.println("Wciśnij sprzęgło");
        if (currentCar != null && currentCar.getSprzeglo() != null) {
            currentCar.getSprzeglo().wcisnij();
        }
        refresh();
    }

    @FXML
    private void onZwolnijSprzeglo() {
        System.out.println("Zwolnij sprzęgło");
        if (currentCar != null && currentCar.getSprzeglo() != null) {
            currentCar.getSprzeglo().zwolnij();
        }
        refresh();
    }

    @FXML
    private void onDodajNowySamochod() {
        System.out.println("Dodaj nowy samochód");
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("DodajSamochod.fxml")
            );
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Dodaj nowy samochód");

            DodajSamochodController controller = loader.getController();
            controller.setMainController(this);

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onUsunSamochod() {
        System.out.println("Usuń samochód");
        if (currentCar != null) {
            cars.remove(currentCar);
            currentCar = cars.isEmpty() ? null : cars.get(0);
            updateSamochodComboBox();
            refresh();
        }
    }

    @FXML
    private void onMapClicked(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        System.out.println("Klik na mapie: x=" + x + ", y=" + y);

    }
}