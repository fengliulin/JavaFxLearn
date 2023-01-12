package com.example.javafx_learn.D图形绘制;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;



public class 绘制正弦函数 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Canvas canvas = new Canvas(600, 600);

        canvas.relocate(0, 0);


        // 把Canvas添加到Pane容器中
        root.getChildren().add(canvas);

        draw(canvas);

        Scene scene = new Scene(root, 600, 600, Color.ALICEBLUE); // scene背景色
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void draw(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.RED);
        gc.setLineWidth(1);
        Double y = 0d;

        // 曲线的原理，就是画点
        for (double x = 0; x <= 360; x += 0.1)
        {
            /**
             * 100 是化成整数
             * Math.sin(-x * Math.PI / 180)： 当x为0时sin是多少，当x为1时sin是多少，
             * 乘以100，是为了观测数据，可以理解为半径
             *
             * 1度=π/180弧度，用弧度制计算正弦函数
             */
            y = 100 * Math.sin(-x * Math.PI / 180);

            gc.strokeLine(x+50, y+150, x+50, y+150);

        }
    }
}
