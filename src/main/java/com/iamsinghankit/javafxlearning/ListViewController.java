package com.iamsinghankit.javafxlearning;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ankit Singh
 */
public class ListViewController implements Initializable {
    public Label myLabel;
    public ListView<String> myListView;

    String[] foods = {"Pizza", "Sushi", "Ramen", "ButterChicken"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myListView.getItems().addAll(foods);
        myListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            myLabel.setText(myListView.getSelectionModel().getSelectedItem());
            myLabel.setText(newValue);
        });
    }
}
