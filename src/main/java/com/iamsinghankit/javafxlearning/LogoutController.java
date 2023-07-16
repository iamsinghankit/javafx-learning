package com.iamsinghankit.javafxlearning;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author Ankit Singh
 */
public class LogoutController {

    @FXML
    private Button logout;
    @FXML
    private AnchorPane scenePane;
    private Stage stage;


    public void logout(ActionEvent event) {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting? ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            stage = (Stage) scenePane.getScene().getWindow();
            System.out.println("You successfully logout!!");
            stage.close();
        }
    }
}
