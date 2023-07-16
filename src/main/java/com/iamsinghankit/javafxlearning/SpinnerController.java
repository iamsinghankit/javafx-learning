package com.iamsinghankit.javafxlearning;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ankit Singh
 */
public class SpinnerController implements Initializable {
    public Label myLabel;
    public Spinner<Integer> mySpinner;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        var valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10);
        valueFactory.setValue(1);
        mySpinner.setValueFactory(valueFactory);
        mySpinner.valueProperty().addListener((observable, oldValue, newValue) -> {
            myLabel.setText(Integer.toString(newValue));
        });

    }
}
