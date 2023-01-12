package com.example.javafx_learn;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 自定义容器
 */
class CustomImagePane extends Pane {
    @Override
    protected void layoutChildren() {
        ObservableList<Node> children = getChildren();

        if (children.size() == 0) {
            return;
        }

        double w = getWidth();
        double h = getWidth();

        // 对Imageview进行摆放，使其适应父窗口
        ImageView imageView = (ImageView) children.get(0);
        imageView.resizeRelocate(0, 0, w, h);
        imageView.setFitWidth(w);
        imageView.setFitHeight(h);
        imageView.setPreserveRatio(true);
    }
}


public class D_自定义容器 extends Application {

    @Override
    public void start(Stage stage) throws IOException {


        HBox hBox = new HBox();

        // 添加图片和显示图片
        Image image = new Image(FileRelativePath.getRelativePath() + "IMG_3818.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);

        // 图片放到自定义的容器里
        CustomImagePane imagePane = new CustomImagePane();
        imagePane.getChildren().add(imageView);

        hBox.getChildren().add(imagePane);


        Scene scene = new Scene(hBox, 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}



