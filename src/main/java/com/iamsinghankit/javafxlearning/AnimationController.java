package com.iamsinghankit.javafxlearning;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ankit Singh
 */
public class AnimationController implements Initializable {
    @FXML
    private ImageView myImageView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // translate, moving image in scene
        var transition = new TranslateTransition();
        transition.setNode(myImageView);
        transition.setDuration(Duration.millis(1000));
        transition.setCycleCount(TranslateTransition.INDEFINITE);
        transition.setAutoReverse(true);
        transition.setByX(250);
//        transition.setByY(-250);
        transition.play();

        // rotate,
        var rotate = new RotateTransition();
        rotate.setNode(myImageView);
        rotate.setDuration(Duration.millis(500));
        rotate.setCycleCount(TranslateTransition.INDEFINITE);
        rotate.setByAngle(360);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setAxis(Rotate.Y_AXIS);
        rotate.setAutoReverse(true);
        rotate.play();

        //fade
        var fade = new FadeTransition();
        fade.setNode(myImageView);
        fade.setDuration(Duration.millis(500));
        fade.setCycleCount(TranslateTransition.INDEFINITE);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setAutoReverse(true);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

        //scale
        var scale = new ScaleTransition();
        scale.setNode(myImageView);
        scale.setDuration(Duration.millis(500));
        scale.setCycleCount(TranslateTransition.INDEFINITE);
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setAutoReverse(true);
        scale.setByX(2.0);
        scale.setByY(2.0);
        scale.play();

    }
}
