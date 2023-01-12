package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 水屏布局和垂直布局
 */
public class C_HBox_VBox extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Button btn1 = new Button("Button1");
        Button btn2 = new Button("Button2");
        Button btn3 = new Button("Button3");
        Button btn4 = new Button("Button4");

        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: #9BCD9B");

        // 水平布局，依次横向排列 不换行
        HBox hBox = new HBox(); // VBox 竖起来排列，其它方法都一样
        hBox.setStyle("-fx-background-color: #E066ff");
        hBox.setPrefWidth(100);
        hBox.setPrefHeight(400);

        hBox.getChildren().addAll(btn1, btn2, btn3, btn4);


        ap.getChildren().add(hBox);
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}