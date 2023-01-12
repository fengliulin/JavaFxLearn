package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Shape3D;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class F_PerspectiveCamera透视摄像机 extends Application {

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

        PerspectiveCamera camera = new PerspectiveCamera();

        // 设置摄像机位置，默认x0 y0， 就是场景的中间
        camera.setTranslateY(0);
        camera.setTranslateX(0);

        // Z轴，摄像机向前移动，导致物体变大，  如果是负数，向内移动，物体慢慢变小
        camera.setTranslateZ(1200);


        // 设置哪个轴旋转， 手指伸出来，和空间直角坐标系一样xyz
//        camera.setRotationAxis(Rotate.Z_AXIS);
//        camera.setRotate(60);

        // 视野
        camera.setFieldOfView(30);

        // 设置近景裁切， 离的比较近了就不渲染了
//        camera.setNearClip(1.2);

        // 启动透视相机
        scene.setCamera(camera);


        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
