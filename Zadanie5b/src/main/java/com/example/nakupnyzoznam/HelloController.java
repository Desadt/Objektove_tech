package com.example.nakupnyzoznam;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class HelloController {
    @FXML private TextField nazovField;
    @FXML private TextField pocetField;
    @FXML private ListView<ShoppingItem> list;
    @FXML private Label pocetLabel;

    private final ObservableList<ShoppingItem> polozky = FXCollections.observableArrayList();

    @FXML
    private void initialize(){
        list.setItems(polozky);
        polozky.addListener((ListChangeListener<ShoppingItem>) change -> aktualizujPocet());
        aktualizujPocet();
        list.getSelectionModel().selectedItemProperty().addListener((obs, stara, nova) -> {
            if(nova != null){
                nazovField.setText(nova.getNazov());
                pocetField.setText(String.valueOf(nova.getPocetKusov()));
            }
        });
        list.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.DELETE){
                odstran();
                e.consume();
            }
        });
    }

    @FXML
    private void pridaj(){
        Integer pocet = overVstup();
        if(pocet == null) return;
        polozky.add(new ShoppingItem(nazovField.getText().trim(), pocet));
        vycistiVstup();
    }

    @FXML
    private void uprav(){
        ShoppingItem vybrana = list.getSelectionModel().getSelectedItem();
        if(vybrana == null){
            zobrazChybu("Najprv označ položku, ktorú chceš upraviť.");
            return;
        }
        Integer pocet = overVstup();
        if(pocet == null) return;
        vybrana.setNazov(nazovField.getText().trim());
        vybrana.setPocetKusov(pocet);
        list.refresh();
        vycistiVstup();
    }

    @FXML
    private void odstran(){
        int index = list.getSelectionModel().getSelectedIndex();
        if(index < 0) return;
        polozky.remove(index);
        vycistiVstup();
    }

    private Integer overVstup(){
        String nazov = nazovField.getText().trim();
        if(nazov.isEmpty()){
            zobrazChybu("Zadaj názov položky.");
            return null;
        }
        try {
            int pocet = Integer.parseInt(pocetField.getText().trim());
            if(pocet <= 0){
                zobrazChybu("Počet kusov musí byť kladné celé číslo.");
                return null;
            }
            return pocet;
        } catch(NumberFormatException e){
            zobrazChybu("Počet kusov musí byť kladné celé číslo.");
            return null;
        }
    }

    private void aktualizujPocet(){
        pocetLabel.setText("Celkový počet položiek: " + polozky.size());
    }

    private void vycistiVstup(){
        list.getSelectionModel().clearSelection();
        nazovField.clear();
        pocetField.clear();
        nazovField.requestFocus();
    }

    private void zobrazChybu(String sprava){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Neplatný vstup");
        alert.setHeaderText(null);
        alert.setContentText(sprava);
        alert.showAndWait();
    }
}
