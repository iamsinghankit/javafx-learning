package com.iamsinghankit.javafxlearning;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ankit Singh
 */
public class ProgressBarController implements Initializable {
    public ProgressBar myProgressBar;
    public Button myButton;
    public Label myLabel;

    BigDecimal progress = new BigDecimal("%.2f".formatted(0.0));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        myProgressBar.setStyle("-fx-accent: red;");
    }

    public void increaseProgress() {
        if (progress.doubleValue() < 1) {
            progress = new BigDecimal("%.2f".formatted(progress.doubleValue() + 0.1));
            myProgressBar.setProgress(progress.doubleValue());
            myLabel.setText((int) (progress.doubleValue() * 100) + "%");
        }
    }
}
