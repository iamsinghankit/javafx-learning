package com.iamsinghankit.javafxlearning;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

/**
 * @author Ankit Singh
 */
public class ColorPickerController {
    public ColorPicker myColorPicker;
    public AnchorPane myPane;


    public void changeColor(ActionEvent event) {
        Color value = myColorPicker.getValue();
        myPane.setBackground(new Background(
                new BackgroundFill(value, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
