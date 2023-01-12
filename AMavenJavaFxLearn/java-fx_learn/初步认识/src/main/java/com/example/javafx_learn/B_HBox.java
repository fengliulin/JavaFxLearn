package com.example.javafx_learn;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * HBox是一种水平布局的容器，可以容纳N个子节点
 */
public class B_HBox extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER); // 水平居中
        hBox.setPadding(new Insets(10));
        TextField textField = new TextField();
        Button selectBtn = new Button("选择文件");
        Button uploadBtn = new Button("开始上传");
        hBox.getChildren().addAll(textField, selectBtn, uploadBtn);
        // 让文本框根据窗体大小自动增长
        HBox.setHgrow(textField, Priority.ALWAYS);


        Scene scene = new Scene(hBox, 400, 40);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(B_HBox.class, args);
    }
}