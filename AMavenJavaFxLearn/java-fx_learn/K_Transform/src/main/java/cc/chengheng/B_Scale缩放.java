package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Start Date: 2021/10/26
 * Author: 冯镠霖(fengliulin)
 */
public class B_Scale缩放 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 缩放原来的50%, 设置缩放后的位置
        Scale scale = new Scale(0.5, 0.5, 100, 100);

        Button b1 = new Button("button1");
        b1.setPrefWidth(100);
        b1.setPrefHeight(100);
        b1.setLayoutX(100);
        b1.setLayoutY(100);




        Button b2 = new Button("button2");
        b2.setPrefWidth(100);
        b2.setPrefHeight(100);

        // 设置几个平移，会根据当前的位置在平移
        b2.getTransforms().addAll(scale);

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


        // 获取边界的大小
        Bounds bd1 = b2.getLayoutBounds();
        Bounds bounds = b2.localToParent(bd1);

        System.out.println();

    }
}
