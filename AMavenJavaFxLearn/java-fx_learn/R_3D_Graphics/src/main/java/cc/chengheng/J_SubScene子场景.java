package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class J_SubScene子场景 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(60);

        Box box = new Box(150, 150, 150);

        Cylinder cylinder = new Cylinder(50, 200, 64);

        Point3D p = new Point3D(1, 0, 0);
        cylinder.setRotationAxis(p);
        cylinder.setRotate(60);

        Sphere sphere = new Sphere(100, 64);

        hBox.getChildren().addAll(box, cylinder, sphere);

        // 点光源
        PointLight pl = new PointLight();
        pl.setColor(Color.RED);
//        al.setLightOn(false); // 关闭光，就变成了黑色
//        pl.getScope().addAll(cylinder); // 哪个组件有光，  不设置就全部都有光

        pl.setTranslateX(1200);
        pl.setTranslateY(400);
        pl.setTranslateZ(-300);


        //======================================================================
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox, pl);


        AnchorPane.setLeftAnchor(hBox, 100.0);
        AnchorPane.setTopAnchor(hBox, 100.0);
        root.setStyle("-fx-background-color: #eeeeee00"); // 需要设置透明度


        // true启用3d渲染       SceneAntialiasing.BALANCED启用抗锯齿优化以平衡质量和性能
        SubScene subScene = new SubScene(root, 1000, 1000, true, SceneAntialiasing.BALANCED);


        subScene.setCamera(new PerspectiveCamera());


        // 子场景可以放到容器中
        HBox h = new HBox(100);
        Button button = new Button("button");
        TextField textField = new TextField("dfdfd");

        h.getChildren().addAll(button, textField, subScene);

        Scene scene = new Scene(h);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1500);
        primaryStage.show();
    }
}
