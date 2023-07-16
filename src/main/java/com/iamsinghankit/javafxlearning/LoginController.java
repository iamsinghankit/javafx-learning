package com.iamsinghankit.javafxlearning;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Ankit Singh
 */
public class LoginController {

    @FXML
    private TextField name;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void login(ActionEvent event)throws IOException {

        String username = name.getText();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/login2.fxml"));
        root = loader.load();
        Login2Controller login2 = loader.getController();
        login2.displayName(username);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
