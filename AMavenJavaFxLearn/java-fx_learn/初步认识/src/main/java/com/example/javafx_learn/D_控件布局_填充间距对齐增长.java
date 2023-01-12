package com.example.javafx_learn;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 每个控件都有3个尺寸：min, pref, max
 * 但是，具体显示的尺寸是由外层容器决定的。
 */
public class D_控件布局_填充间距对齐增长 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        HBox hBox = new HBox();
        TextField textField = new TextField();
        Button selectBtn = new Button("选择文件");
        Button uploadBtn = new Button("开始上传");
        hBox.getChildren().addAll(textField, selectBtn, uploadBtn);

        // 填充
        hBox.setPadding(new Insets(10,20,30,40));

        // 间距
        hBox.setSpacing(10);

        // 对齐
        hBox.setAlignment(Pos.CENTER);

        // 增长  静态方法
        HBox.setHgrow(textField, Priority.ALWAYS);







        Scene scene = new Scene(hBox, 400, 60);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}