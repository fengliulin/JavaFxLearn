package cc.chengheng;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Box;
import javafx.scene.shape.CullFace;
import javafx.scene.shape.DrawMode;
import javafx.stage.Stage;

public class B_Box立方体 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(30);

        ObservableList<Node> list = hBox.getChildren();
        for (int i = 0; i < 5; i++) {
            Box box = new Box(100, 100, 200);
            list.add(box);
        }

        Box shape1 = (Box) hBox.getChildren().get(0);
        shape1.setTranslateX(-50);
        shape1.setRotationAxis(new Point3D(1, 0, 0));
        shape1.setRotate(30);

        Box shape2 = (Box) hBox.getChildren().get(1);
        shape2.setTranslateX(-50);
        shape2.setRotationAxis(new Point3D(1, 1, 1));
        shape2.setRotate(30);

        shape2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("ff");
            }
        });

        Box shape3 = (Box) hBox.getChildren().get(2);
        shape3.setTranslateX(-50);
        shape3.setRotationAxis(new Point3D(1, 1, 1));
        shape3.setRotate(30);
        shape3.setDrawMode(DrawMode.LINE); // 设置绘图线条
        shape3.setCullFace(CullFace.BACK); // 设置踢出面


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
