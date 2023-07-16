package com.iamsinghankit.javafxlearning;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Ankit Singh
 */
public class MediaController implements Initializable {
    @FXML
    private Button playButton, pauseButton, resetButton;
    @FXML
    private MediaView myMedia;

    private File file;
    private Media media;
    private MediaPlayer mediaPlayer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        file = new File("//Users/ankitsingh/Movies/TV/Media.localized/Home Videos/VID_20210402_181932.mp4");
        media = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        myMedia.setMediaPlayer(mediaPlayer);
    }

    public void playMedia() {
        mediaPlayer.play();
    }

    public void pauseMedia() {
        mediaPlayer.pause();
    }

    public void resetMedia() {
        if (mediaPlayer.getStatus() != MediaPlayer.Status.READY)
            mediaPlayer.seek(Duration.seconds(0.0));
    }
}
