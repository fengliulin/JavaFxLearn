package com.example.javafx_learn.B对话框;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Start Date: 2021/11/4
 * Author: 冯镠霖(fengliulin)
 */
public class DirectoryChooser目录选择器 extends Application {

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();

        Button openBtn = new Button("打开");

        openBtn.setOnAction(event -> {
            Stage stage = new Stage();
            DirectoryChooser dc = new DirectoryChooser();
            dc.setTitle("文件夹选择器");
            dc.setInitialDirectory(new File("/"));
            File file = dc.showDialog(stage);

            if (file != null) {
                System.out.println(file.getAbsolutePath());

                File[] files = file.listFiles();
                for (File file1 : files) {
                    System.out.println(file1);
                }
            }

        });


        root.getChildren().addAll(openBtn);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
