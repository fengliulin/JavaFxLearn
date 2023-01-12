package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class C_MediaView extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // 视频URL
        URL resource = getClass().getResource("/宣传片.mp4");

        // 创建播放器
        Media media = new Media(resource.toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(600);
        mediaView.setFitHeight(400);
        mediaView.setPreserveRatio(true);

        Rectangle2D rectangle2D = new Rectangle2D(200, 0, 200, 200);

        mediaView.setViewport(rectangle2D);

        BorderPane root = new BorderPane();
        root.setCenter(mediaView);

        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
