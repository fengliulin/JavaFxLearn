package com.example.javafx_learn.E媒体播放器;

import com.example.javafx_learn.FileRelativePath;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class A媒体播放器 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 视频URL
        URL resource = getClass().getResource("/");
        String path = resource.getPath() + "com/example/javafx_learn/E媒体播放器/" + "宣传片.mp4";
        File mediaFile = new File(path);
        String mediaUrl = mediaFile.toURI().toString();

        // 创建播放器
        Media media = new Media(mediaUrl);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(600);
        mediaView.setFitHeight(400);
        mediaView.setPreserveRatio(true);

        BorderPane root = new BorderPane();
        root.setCenter(mediaView);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
