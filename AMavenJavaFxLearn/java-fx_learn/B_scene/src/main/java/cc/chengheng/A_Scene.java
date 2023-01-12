package cc.chengheng;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class A_Scene extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        HostServices hostServices = getHostServices();
        hostServices.showDocument(""); // 打开某个网页

        Button button = new Button("按钮");
        button.setPrefWidth(200);
        button.setPrefHeight(200);
        button.setCursor(Cursor.H_RESIZE);

        Group group = new Group();
        group.getChildren().add(button);



        // 一般根节点放置一个布局类的节点
        // 根node，场景多大，根节点组件的宽度和高度就多大
        // 场景的根节点，设置宽和高是无效的， 它会随着场景的大小， 场景的大小 会 和舞台的大小一样
        Scene scene = new Scene(group);

        scene.setCursor(Cursor.CLOSED_HAND); // 设置舞台的光标


        // 设置舞台的大小，在舞台上添加场景
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
