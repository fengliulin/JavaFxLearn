package cc.chengheng;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.DepthTest;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.function.Consumer;

public class A_AudioClip音效 extends Application {
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
        AudioClip ac = new AudioClip(url.toExternalForm());
//        mp.setBalance(-1); // 1 声音在右声道， -1 在左声道，   0 左右声道
//        ac.setPan();
//        ac.setPriority(1);
//        ac.setRate();
//        ac.setVolume();

        // 播放
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!ac.isPlaying()){ // 如果没有播放就执行
                     ac.play();
                }
            }
        });

        // 停止
        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ac.stop();
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
