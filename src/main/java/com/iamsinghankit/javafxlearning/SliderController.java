package com.iamsinghankit.javafxlearning;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ankit Singh
 */
public class SliderController implements Initializable {
    public Label myLabel;
    public Slider mySlider;

    int temperature;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        temperature = (int) mySlider.getValue();
        myLabel.setText(temperature + "°c");

        mySlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            temperature = newValue.intValue();
            myLabel.setText(temperature + "°c");
        });
    }
}
