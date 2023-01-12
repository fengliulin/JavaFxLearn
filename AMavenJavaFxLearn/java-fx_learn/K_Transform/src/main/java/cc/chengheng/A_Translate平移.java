package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 * Start Date: 2021/10/26
 * Author: 冯镠霖(fengliulin)
 */
public class A_Translate平移 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Translate t1 = new Translate(100, 100);
        Translate t2 = new Translate(100, 100);

        Button b1 = new Button("button1");
        b1.setPrefWidth(100);
        b1.setPrefHeight(100);
        b1.setLayoutX(100);
        b1.setLayoutY(100);
        b1.getTransforms().add(t2);

        Button b2 = new Button("button2");
        b2.setPrefWidth(100);
        b2.setPrefHeight(100);

        // 设置几个平移，会根据当前的位置在平移
        b2.getTransforms().addAll(t1, t2);

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
    }
}
