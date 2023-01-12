package cc.chengheng;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class E_Material材质贴图 extends Application {
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

        hBox.getChildren().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node node) {
                Shape3D shape = (Shape3D) node;
                PhongMaterial pm = new PhongMaterial();
//                pm.setDiffuseColor(Color.DARKGOLDENROD); // 设置漫反射颜色
//                pm.setSpecularColor(Color.RED); // 设置高光颜色
//                pm.setSpecularPower(10); // 设置高光强度

                // 贴图，要有一个法线贴图和原始的图
                pm.setDiffuseMap(new Image(getClass().getResource("/斜线边界判断.jpg").toExternalForm())); // 漫反射贴图
                pm.setBumpMap(new Image(getClass().getResource("/faxian.png").toExternalForm())); // 法线贴图

//                pm.setSelfIlluminationMap(); // 设置自发光贴图

                shape.setMaterial(pm);
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
