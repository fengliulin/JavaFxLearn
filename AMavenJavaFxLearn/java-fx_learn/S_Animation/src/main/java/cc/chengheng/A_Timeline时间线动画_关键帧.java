package cc.chengheng;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.function.Consumer;

public class A_Timeline时间线动画_关键帧 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(30);

        ToggleButton tb1 = new ToggleButton("播放");
        ToggleButton tb2 = new ToggleButton("暂停");
        ToggleButton tb3 = new ToggleButton("停止");
        ToggleButton tb4 = new ToggleButton("tb4");

        ToggleGroup group = new ToggleGroup();
        tb1.setToggleGroup(group);
        tb2.setToggleGroup(group);
        tb3.setToggleGroup(group);
        tb4.setToggleGroup(group);

        hBox.getChildren().addAll(tb1, tb2, tb3, tb4);

        Button bu = new Button("Button");
// 时间线动画
        Timeline timeline = new Timeline();

        tb1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                group.getToggles().forEach(new Consumer<Toggle>() {
                    @Override
                    public void accept(Toggle toggle) {
                        timeline.play();
                    }
                });
            }
        });




        KeyValue kv1 = new KeyValue(bu.translateXProperty(), 0);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(0),
                "kf1", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        },kv1);

        KeyValue kv2 = new KeyValue(bu.translateXProperty(), 300);
        KeyFrame kf2 = new KeyFrame(Duration.seconds(5),
                "kf2", new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        },kv2);

        timeline.getKeyFrames().addAll(kf1, kf2);


        //======================================================================

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox, bu);

        root.setDepthTest(DepthTest.ENABLE);

        AnchorPane.setLeftAnchor(bu, 100.0);
        AnchorPane.setTopAnchor(bu, 100.0);
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
