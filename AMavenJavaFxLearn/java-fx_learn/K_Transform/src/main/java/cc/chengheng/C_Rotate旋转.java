package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Start Date: 2021/10/26
 * Author: 冯镠霖(fengliulin)
 */
public class C_Rotate旋转 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Rotate rotate = new Rotate(45, 0, 0);

        Button b1 = new Button("button1");
        b1.setPrefWidth(100);
        b1.setPrefHeight(100);
        b1.setLayoutX(100);
        b1.setLayoutY(100);

        Button b2 = new Button("button2");
        b2.setPrefWidth(100);
        b2.setPrefHeight(100);

        // 设置几个平移，会根据当前的位置在平移
        b2.getTransforms().addAll(rotate);

        AnchorPane an = new AnchorPane();
        an.setPrefWidth(600);
        an.setPrefHeight(600);
        an.setStyle("-fx-background-color: #ffb5c5");

        an.getChildren().addAll(b1, b2);

        AnchorPane root = new AnchorPane();
        root.getChildren().add(an);
        AnchorPane.setTopAnchor(an, 100.0);
        AnchorPane.setLeftAnchor(an, 100.0);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();

        System.out.println(b2.getLocalToParentTransform().getTx());

        // 转换的坐标实际还是个外围有一个正方形的坐标
        Bounds layoutBounds = b2.getLayoutBounds();
        Bounds bounds = b2.localToParent(layoutBounds);

        System.out.println();
    }
}
