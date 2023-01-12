package cc.chengheng;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.*;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.ByteBuffer;

public class A_鼠标拖拽移动_拖拽进入_拖拽退出 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox(20);
        Button b1 = new Button("button1");
        Button b2 = new Button( "button2");
        hbox.getChildren().addAll(b1, b2);

        // 鼠标拖拽移动
        b1.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                System.out.println("鼠标拖拽");
            }
        });

        //region Description
        // 设置拖动检测，拖动的时候执行一次
        b1.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                b1.startFullDrag(); // 完整的拖拽，会执行setOnMouseDragOver
                System.out.println("拖动检测");
            }
        });

        // 滑过拖动区域
        b1.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                System.out.println("setOnMouseDragOver");
            }
        });
        //endregion

        // 鼠标拖拽进入
        b2.setOnMouseDragEntered(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                System.out.println("拖拽进入");
            }
        });

        // 鼠标拖拽退出
        b2.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {
            @Override
            public void handle(MouseDragEvent event) {
                System.out.println("拖拽退出");
            }
        });

        // 鼠标释放
        b1.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("鼠标释放");
            }
        });

        AnchorPane an = new AnchorPane();

        an.getChildren().add(hbox);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
