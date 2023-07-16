package com.iamsinghankit.javafxlearning;

import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

/**
 * @author Ankit Singh
 */
public class CheckboxController {
    public CheckBox myCheckBox;
    public Label myLabel;
    public ImageView myImageView;

    Image offBulb = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/lightbuldoff.jpeg")));
    Image onBulb = new Image(getClass().getResourceAsStream("/lighbulbon.jpeg"));

    public void change(ActionEvent event) {
        if(myCheckBox.isSelected()){
            myLabel.setText("ON");
            myImageView.setImage(onBulb);
        }
        else{
            myLabel.setText("OFF");
            myImageView.setImage(offBulb);
        }
    }
}
