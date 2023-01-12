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
public class C_控件尺寸 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        //根节点：HBox
        HBox hbox = new HBox();
        //3个按钮
        Button b1 = new Button("中国");
        Button b2 = new Button("China");
        Button b3 = new Button("中华人民共和国");

        b1.setMinWidth(10);
        b1.setPrefWidth(150); // 首选、优先使用的宽度
        b1.setMaxWidth(400);

        b1.setMinHeight(20);
        b1.setMaxWidth(300);
        b1.setPrefHeight(150);


        hbox.getChildren().addAll(b1, b2, b3);


        Scene scene = new Scene(hbox, 400, 40);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}