package org.example.samochodgui2;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class DodajSamochodController {

    @FXML private TextField modelField;
    @FXML private TextField nrRejField;
    @FXML private TextField vmaxField;

    @FXML private ComboBox<String> engineComboBox;
    @FXML private ComboBox<String> gearboxComboBox;

    @FXML private Button confirmButton;
    @FXML private Button cancelButton;// to sie przyda jeszcze

    private HelloController mainController;

    public void setMainController(HelloController mainController) {
        this.mainController = mainController;
    }

    @FXML
    private void onConfirm() {
        if (mainController == null) {
            closeWindow();
            return;
        }

        String model = modelField.getText();
        String nrRej = nrRejField.getText();
        if (model == null || model.isBlank() ||
                nrRej == null || nrRej.isBlank()) {
            System.out.println("Model i nr rejestracyjny są wymagane.");
            return;
        }

        double vmax;
        try {
            vmax = Double.parseDouble(vmaxField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Niepoprawna prędkość maksymalna.");
            return;
        }

        String engineType = engineComboBox.getValue();
        String gearboxType = gearboxComboBox.getValue();

        if (engineType == null || gearboxType == null) {
            System.out.println("Wybierz silnik i skrzynię biegów.");
            return;
        }

        Silnik silnik;
        switch (engineType) {
            case "Benzyna 1.4":
                silnik = new Silnik("Benzyna 1.4", 100.0, 6000.0, 6000);
                break;
            case "Diesel 2.0":
                silnik = new Silnik("Diesel 2.0", 140.0, 9000.0, 5500);
                break;
            case "Benzyna 2.0":
            default:
                silnik = new Silnik("Benzyna 2.0", 120.0, 8000.0, 6500);
                break;
        }

        Sprzeglo sprzeglo = new Sprzeglo("Sprzęgło standardowe", 8.0, 500.0);

        SkrzyniaBiegow skrzynia;
        switch (gearboxType) {
            case "Manualna 5-biegowa":
                skrzynia = new SkrzyniaBiegow("Manualna 5-biegowa", 35.0, 1800.0, 5, sprzeglo);
                break;
            case "Manualna 6-biegowa":
            default:
                skrzynia = new SkrzyniaBiegow("Manualna 6-biegowa", 40.0, 2000.0, 6, sprzeglo);
                break;
        }

        Samochod car = new Samochod(nrRej, model, vmax, silnik, skrzynia);
        mainController.addCarToList(car);

        closeWindow();
    }

    @FXML
    private void onCancel() {
        closeWindow();
    }

    private void closeWindow() {
        Stage stage = (Stage) confirmButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void initialize() {
        engineComboBox.setItems(FXCollections.observableArrayList(
                "Benzyna 1.4",
                "Benzyna 2.0",
                "Diesel 2.0"
        ));

        gearboxComboBox.setItems(FXCollections.observableArrayList(
                "Manualna 5-biegowa",
                "Manualna 6-biegowa"
        ));
    }
}