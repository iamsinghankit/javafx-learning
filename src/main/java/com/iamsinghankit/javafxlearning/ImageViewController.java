package com.iamsinghankit.javafxlearning;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Ankit Singh
 */
public class ImageViewController {
    //ImagView is a Node used for  painting images loaded with different images.
    // Image = Photograph
    //ImageView = picture frame

    Image shrek2 = new Image(getClass().getResourceAsStream("/shrek2.png"));
    @FXML
    private ImageView myImageView;
    @FXML
    private Button myButton;

    public void displayImage() {
        myImageView.setImage(shrek2);

    }
}
