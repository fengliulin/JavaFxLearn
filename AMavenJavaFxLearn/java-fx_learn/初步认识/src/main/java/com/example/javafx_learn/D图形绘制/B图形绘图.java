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

public class B图形绘图 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Canvas canvas = new Canvas(300, 300);

        canvas.relocate(0, 0);


        // 把Canvas添加到Pane容器中
        root.getChildren().add(canvas);

        draw(canvas);

        Scene scene = new Scene(root, 400, 400, Color.ALICEBLUE); // scene背景色
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    private void draw(Canvas canvas) {

        // GraphicsContext 内部有个缓存区， 画图的操作实际是画到内存里，当显示窗体的时候， 一次绘制出来
        GraphicsContext gc = canvas.getGraphicsContext2D();
        /*
        strokeRect () 仅绘制线条 rectangle
        fillRect ()     仅绘制填充
         */

        // 绘制文字
        gc.setFont(new Font("宋体", 40));
        gc.setTextBaseline(VPos.CENTER);
        gc.fillText("文字添加", 0, 50);

        // 阴影
        //region 先设置渐变
        Stop[] stops = new Stop[]{
                new Stop(0, Color.BLACK),
                new Stop(1, Color.RED)
        };
        LinearGradient lg = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
        gc.setFill(lg);
        //endregion

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(3.0f);
        dropShadow.setColor(Color.color(0.4f, 0.4f, 0.4f));
        gc.fillText("dropShadow", 0, 150);

        // 绘制边框
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(4);
        gc.strokeRect(50, 50, 200, 100);

        // 绘制矩形
//        gc.setFill(Color.BLUE);
//        gc.fillRect(100, 50, 200, 100);
    }
}
