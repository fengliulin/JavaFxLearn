package cc.chengheng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class A_鼠标拖动按钮_拖动窗体_窗体添加圆角 extends Application {
    public static void main(String[] args) {
        launch();
    }

    double x = 0;
    double y = 0;

    double screenX = 0;
    double screenY = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button btn = new Button("button");

        // 拖动移动按钮
        btn.setOnMousePressed(event -> {
            x = event.getX(); // 获取的是按钮相对的鼠标坐标位置
            y = event.getY();

            System.out.println(event.getSceneX());
            System.out.println(x);
        });

        // 鼠标拖动一下触发一下，拖动一下触发一下
        btn.setOnMouseDragged(event -> {
            AnchorPane.setTopAnchor(btn, event.getSceneY() - y);
            AnchorPane.setLeftAnchor(btn, event.getSceneX() - x);

        });


        //================================================================
        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(btn);

        // 设置窗体圆角
        Background background = new Background(new BackgroundFill(Paint.valueOf("#FFB5C5"), new CornerRadii(15), new Insets(0)));
        an.setBackground(background);

        //设置外边框
        an.setBorder(new Border(new BorderStroke(Color.valueOf("#912CEE"), BorderStrokeStyle.SOLID, new CornerRadii(40), new BorderWidths(2), new Insets(0))));

        AnchorPane.setTopAnchor(btn, 100.0);
        AnchorPane.setLeftAnchor(btn, 100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);

        scene.setFill(Paint.valueOf("#FFB5C500"));

        primaryStage.initStyle(StageStyle.TRANSPARENT);


        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();


        primaryStage.setMaximized(true);

        // 拖动移动窗体
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                screenX = event.getScreenX() - primaryStage.getX();
                screenY = event.getScreenY() - primaryStage.getY();

                System.out.println(screenX);
                System.out.println(screenY);
            }
        });

        scene.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - screenX);
            primaryStage.setY(event.getScreenY() - screenY);
        });
    }
}
