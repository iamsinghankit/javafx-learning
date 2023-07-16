package com.iamsinghankit.javafxlearning;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ankit Singh
 */
public class ChoiceBoxController implements Initializable {
    public ChoiceBox<String> myChoice;
    public Label myLabel;

    String[] foods = {"pizza", "sushi", "ramen"};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myChoice.getItems().addAll(foods);
        myChoice.setOnAction(this::getFood);
    }

    public void getFood(ActionEvent event) {
        String myFood = myChoice.getValue();
        myLabel.setText(myFood);
    }
}
