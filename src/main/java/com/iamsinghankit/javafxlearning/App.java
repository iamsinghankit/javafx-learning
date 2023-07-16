package com.iamsinghankit.javafxlearning;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;


/**
 * @author Ankit Singh
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {

//        var root = new Group();
//        var scene = new Scene(root, 600,600,Color.LIGHTSKYBLUE);
        Parent root = FXMLLoader.load(getClass().getResource("/mp3.fxml"));
        var scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
        //   stage.setOnCloseRequest(event -> setupCloseButton(stage,event));
    }

    void setupKey(Scene scene) {
        scene.setOnKeyPressed(event -> {
            System.out.println("Key pressed: " + event.getCode());
        });
    }

    void setupCloseButton(Stage stage, WindowEvent event) {
        event.consume();// for cancelling closing
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Do you want to save before exiting? ");

        if (alert.showAndWait().get() == ButtonType.OK) {
            System.out.println("You successfully logout!!");
            stage.close();
        }
    }

    void setupCss(Scene scene) {
        var css = getClass().getResource("/application.css").toExternalForm();
        scene.getStylesheets().add(css);
    }

    void setupScene(Group root) {
        var text = new Text("WHOOOOA!!");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", 50));
        text.setFill(Color.LIMEGREEN);

        var line = new Line();
        line.setStartX(200);
        line.setStartY(200);
        line.setEndX(500);
        line.setEndY(200);
        line.setStrokeWidth(5);
        line.setStroke(Color.RED);
        line.setOpacity(0.5);
        line.setRotate(45);

        var rectangle = new Rectangle();
        rectangle.setX(100);
        rectangle.setY(100);
        rectangle.setWidth(100);
        rectangle.setHeight(100);
        rectangle.setFill(Color.BLUE);
        rectangle.setStrokeWidth(5);
        rectangle.setStroke(Color.BLACK);

        var triangle = new Polygon();
        triangle.getPoints().setAll(200.0, 200.0,
                300.0, 300.0,
                200.0, 300.0);
        triangle.setFill(Color.YELLOW);

        var circle = new Circle();
        circle.setCenterX(350);
        circle.setCenterY(350);
        circle.setRadius(50);
        circle.setFill(Color.ORANGE);

        var image = new Image("icon.png");
        var imageView = new ImageView(image);
        imageView.setX(400);
        imageView.setY(400);

        root.getChildren().add(rectangle);
        root.getChildren().add(imageView);
        root.getChildren().add(circle);
        root.getChildren().add(triangle);
        root.getChildren().add(text);
        root.getChildren().add(line);

    }


    void setupStage(Stage stage) {
        stage.setTitle("JavaFx Learning");
        stage.getIcons().add(new Image("icon.png"));
//       stage.setWidth(420);
//        stage.setHeight(420);
        stage.setResizable(false);
        stage.setX(50);
        stage.setY(50);
        //  stage.setFullScreen(true);
        stage.setFullScreenExitHint("You Can't escape unless you press q");// won't work in mac
        stage.setFullScreenExitKeyCombination(KeyCombination.valueOf("q"));
    }

}