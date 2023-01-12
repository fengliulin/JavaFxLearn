package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.ParallelCamera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Box;
import javafx.stage.Stage;

public class G_ParallelCamera平行摄像机 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox1 = new HBox();
        hBox1.setPrefHeight(1000);
        hBox1.setPrefWidth(1000);

        HBox hBox = new HBox(60);

        Box box1 = new Box(150, 150, 150);
        Box box2 = new Box(150, 150, 150);
        Box box3 = new Box(150, 150, 150);

        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(box1, box2, box3);


        //======================================================================
        hBox1.setAlignment(Pos.BOTTOM_CENTER);

        hBox1.getChildren().addAll(hBox);

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox1);


        /*AnchorPane.setLeftAnchor(hBox, 100.0);
        AnchorPane.setTopAnchor(hBox, 100.0);*/
        root.setStyle("-fx-background-color: #eeeeee00"); // 需要设置透明度


        // true启用3d渲染       SceneAntialiasing.BALANCED启用抗锯齿优化以平衡质量和性能
        Scene scene = new Scene(root, 1000, 1000, true, SceneAntialiasing.BALANCED);

        // 启动平行线摄像机
        scene.setCamera(new ParallelCamera());


        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
