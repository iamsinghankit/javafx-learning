package com.iamsinghankit.javafxlearning;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

/**
 * @author Ankit Singh
 */
public class MainController {

    @FXML
    private Circle circle;
    private double x;
    private double y;

    public void up(ActionEvent event){
        circle.setCenterY(y-=10);
    }

    public void down(ActionEvent event){
        circle.setCenterY(y+=10);
    }

    public void left(ActionEvent event){
        circle.setCenterX(x-=10);
    }
    public void right(ActionEvent event){
        circle.setCenterX(x+=10);
    }
}
