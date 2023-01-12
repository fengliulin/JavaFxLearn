package cc.chengheng;

import javafx.application.Application;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.DepthTest;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.net.URLDecoder;
import java.util.Base64;

public class B_MediaPlayer音乐播放 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(30);

        Button b1 = new Button("播放");
        Button b2 = new Button("停止");

        hBox.getChildren().addAll(b1, b2);

        URL url = getClass().getResource("/阿悠悠-责无旁贷.mp3");

        // 解码
        String decode = URLDecoder.decode(url.toExternalForm(), "utf-8");
        System.out.println(decode);

        Media media = new Media(url.toExternalForm());

        MediaPlayer mp = new MediaPlayer(media);



//        mp.setAutoPlay(true);
        mp.setBalance(0); // 1 声音在右声道， -1 在左声道，   0 左右声道

//        mp.setMute(true); // 设置静音

        // 控制播放开始时间和停止时间
        /*mp.setStartTime(Duration.seconds(20));
        mp.setStopTime(Duration.seconds(21));*/



        mp.setOnReady(new Runnable() {
            @Override
            public void run() {
                // 获取音乐的持续时间
                System.out.println(media.getDuration().toSeconds());

                // 获取音乐的总时间
                System.out.println(mp.getTotalDuration().toSeconds());

                // 获取当前音乐播放道哪一秒
                System.out.println(mp.getCurrentTime().toSeconds());

            }
        });


        mp.setOnHalted(new Runnable() {
            @Override
            public void run() {
                System.out.println("无法恢复的错误，无法在使用MediaPlayer");
            }
        });

        mp.setOnStalled(() -> {
            System.out.println("进入缓冲阶段");
        });

        mp.setOnRepeat(() -> {
            System.out.println("重复播放");
        });


        mp.setOnPlaying(() -> {
            System.out.println("正在播放状态");
        });

        mp.setOnReady(() -> {
            System.out.println("准备阶段");
        });

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mp.setVolume(0.3);
                mp.play();

                ObservableMap<String, Object> metadata1 = media.getMetadata();
                for (String key : metadata1.keySet()) {
                    System.out.println(key + "-" + metadata1.get(key));
                }
            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                mp.stop();
            }
        });

        //======================================================================

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);

        root.setDepthTest(DepthTest.ENABLE);

        AnchorPane.setLeftAnchor(hBox, 100.0);
        AnchorPane.setTopAnchor(hBox, 100.0);
        root.setStyle("-fx-background-color: #eeeeee00"); // 需要设置透明度


        // true启用3d渲染       SceneAntialiasing.BALANCED启用抗锯齿优化以平衡质量和性能
        Scene scene = new Scene(root, 1000, 1000, true, SceneAntialiasing.BALANCED);

        // 启动透视相机
        scene.setCamera(new PerspectiveCamera());


        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
