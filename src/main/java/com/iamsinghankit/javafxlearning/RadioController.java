package com.iamsinghankit.javafxlearning;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

/**
 * @author Ankit Singh
 */
public class RadioController {
    public Label myLabel;
    public RadioButton rButton1, rButton2, rButton3;

    public void getFood(ActionEvent event) {
        if (rButton1.isSelected()) {
            myLabel.setText(rButton1.getText());
        } else if (rButton2.isSelected()) {
            myLabel.setText(rButton2.getText());
        } else if (rButton3.isSelected()) {
            myLabel.setText(rButton3.getText());
        }
    }
}
