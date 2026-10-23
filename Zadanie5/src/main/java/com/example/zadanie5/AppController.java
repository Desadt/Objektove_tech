package com.example.zadanie5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class AppController {
    @FXML private ListView<String> list;
    @FXML private TextField name;
    private ObservableList<String> zoznam = FXCollections.observableArrayList();

    @FXML void initialize(){
        list.setItems(zoznam);
        name.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) add();
        });
        list.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.DELETE) remove();
        });
    }

    @FXML void add(){
        String a = name.getText();
        if(a == null) return;
        zoznam.add(a);
        name.clear();
        name.requestFocus();
    }
    @FXML void remove(){
        String a = list.getSelectionModel().getSelectedItem();
        if(a == null) return;
        zoznam.remove(a);
    }
    @FXML void load(){
        String a = list.getSelectionModel().getSelectedItem();
        name.setText(a);
    }
    @FXML void update(){
        String a = name.getText();
        if(a.isEmpty()) return;
        String b = list.getSelectionModel().getSelectedItem();
        zoznam.set(zoznam.indexOf(b),a);
        name.clear();
        name.requestFocus();
    }
}
