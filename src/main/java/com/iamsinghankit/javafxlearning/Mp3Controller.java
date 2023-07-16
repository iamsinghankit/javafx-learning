package com.iamsinghankit.javafxlearning;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.*;

/**
 * @author Ankit Singh
 */
public class Mp3Controller implements Initializable {

    private final int[] speeds = {25, 50, 75, 100, 125, 150, 200};
    @FXML
    public ComboBox<String> speedComboBox;
    @FXML
    public Slider volumeSlider;
    @FXML
    private ProgressBar songProgressBar;
    @FXML
    private Label songLabel;
    @FXML
    private Pane pane;
    @FXML
    private Button playButton, pauseButton, resetButton, previousButton, nextButton;
    private Media media;
    private MediaPlayer mediaPlayer;
    private List<File> songs;
    private int songNumber;
    private Timer timer;
    private boolean running;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        songs = new ArrayList<>();
        var directory = new File("/Users/ankitsingh/Music/Music/Media.localized/SonyLIV/Unknown Album");
        var files = directory.listFiles();
        if (files != null) {
            songs.addAll(Arrays.asList(files));
        }
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        songLabel.setText(songs.get(songNumber).getName());

        for (int speed : speeds) {
            speedComboBox.getItems().add(speed + "%");
        }
        speedComboBox.setOnAction(this::changeSpeed);
        volumeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
        });
        songProgressBar.setStyle("-fx-accent: #00ffd9;");
    }

    public void changeSpeed(ActionEvent event) {
        if (speedComboBox.getValue() == null) {
            mediaPlayer.setRate(1);
        } else {
            mediaPlayer.setRate(Integer.parseInt(speedComboBox.getValue().substring(0, speedComboBox.getValue().length() - 1)) * 0.01);
        }
    }

    public void next() {
        if (songNumber < songs.size() - 1) {
            songNumber++;
            mediaPlayer.stop();
            if (running) {
                cancelTimer();
            }
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());
        } else {
            songNumber = 0;
            mediaPlayer.stop();
            if (running) {
                cancelTimer();
            }
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());
        }
        play();
    }

    public void previous() {
        if (songNumber > 0) {
            songNumber--;
            mediaPlayer.stop();
            if (running) {
                cancelTimer();
            }
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());
        } else {

            songNumber = songs.size() - 1;
            mediaPlayer.stop();
            if (running) {
                cancelTimer();
            }
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());
        }
        play();
    }

    public void reset() {
        songProgressBar.setProgress(0);
        mediaPlayer.seek(Duration.seconds(0));
    }

    public void pause() {
        cancelTimer();
        mediaPlayer.pause();
    }

    public void play() {
        beginTimer();
        mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
        changeSpeed(null);
        mediaPlayer.play();
    }

    private void beginTimer() {
        timer = new Timer();
        var task = new TimerTask() {
            @Override
            public void run() {
                running = true;
                double current = mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                songProgressBar.setProgress(current / end);
                if (current / end == 1) {
                    cancelTimer();
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    private void cancelTimer() {
        running = false;
        timer.cancel();
    }
}
