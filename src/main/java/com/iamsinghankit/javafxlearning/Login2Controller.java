package com.iamsinghankit.javafxlearning;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * @author Ankit Singh
 */
public class Login2Controller {
    @FXML
    private Label name;

    public void displayName(String username) {
        name.setText(name.getText()+ username);
    }
}
