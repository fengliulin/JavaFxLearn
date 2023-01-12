package com.example.javafx_learn;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class 图片和按钮的添加 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        BorderPane root = new BorderPane();
        Label label = new Label("标签");
        root.setCenter(label);

        Button button = new Button("我是按钮");
        root.setLeft(button);

        // 给按钮添加事件
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(actionEvent.getSource());
            }
        });

        // 添加图片和显示图片
        Image image = new Image(FileRelativePath.getRelativePath() + "pao.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        root.setBottom(imageView);

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}