package com.iamsinghankit.javafxlearning;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ankit Singh
 */
public class WebviewController implements Initializable {
    public Button button;
    public TextField textfield;
    public WebView webview;
    private WebEngine engine;
    private WebHistory webHistory;

    private double webZoom;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        engine = webview.getEngine();
        webZoom = 1;
        String homePage = "www.google.com";
        textfield.setText(homePage);
        loadPage();
    }

    public void loadPage() {
        engine.load("https://%s".formatted(textfield.getText()));
    }

    public void refreshPage() {
        engine.reload();
    }

    public void zoomIn() {
        webZoom += 1.25;
        webview.setZoom(webZoom);
    }

    public void zoomOut() {
        webZoom -= 0.75;
        webview.setZoom(webZoom);
    }

    public void displayHistory() {
        webHistory = engine.getHistory();
        var entries = webHistory.getEntries();
        for (WebHistory.Entry entry : entries) {
            System.out.println(entry);
        }
    }

    public void back() {
        webHistory = engine.getHistory();
        var entries = webHistory.getEntries();
        textfield.setText(entries.get(webHistory.getCurrentIndex()).getUrl());
        webHistory.go(-1);
    }

    public void forward() {
        webHistory = engine.getHistory();
        var entries = webHistory.getEntries();
        textfield.setText(entries.get(webHistory.getCurrentIndex()).getUrl());
        webHistory.go(+1);
    }

    public void executeJS() {
        engine.executeScript("""
                window.location = "https://www.youtube.com";
                """);
    }
}
