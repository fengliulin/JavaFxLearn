package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class A_Canvas extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        // 创建画布拿到画笔
        Canvas canvas = new Canvas(500, 1000);
        GraphicsContext g = canvas.getGraphicsContext2D();

        // 先设置画笔什么样子，在去画
        g.setFill(Color.RED);
        g.fillRect(100, 100, 100, 100);

        g.setStroke(Color.BLUE);
        g.setLineWidth(4);
        g.strokeRect(200, 200, 100, 100);

        // 绘制线
        g.setStroke(Color.ORANGE);
        g.strokeLine(400, 100, 400, 200);

        // 绘制多边形
        g.fillPolygon(
                // 上下组成一个x和y， 3组就是3个点， 可以使用不同的点
                new double[]{100,100,200},
                new double[]{300,500,400},
                3
        );

        // 绘制文本
        g.setFont(Font.font(50));
        g.setStroke(Color.CHARTREUSE);
        g.setLineWidth(2);
        g.strokeText("hello world", 100, 700);

        g.drawImage(new Image(getClass().getResource("/未标题-2.jpg").toExternalForm()),0, 0);

        // 画像素
        PixelWriter pw = g.getPixelWriter();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                pw.setColor(i, j, Color.RED);
            }
        }

        g.setStroke(Color.RED);
        g.setLineWidth(3);
        g.setGlobalAlpha(0.5);
        g.save(); // 保存状态
        g.setEffect(new DropShadow());
        g.strokeLine(100,400,200,200);


        g.restore(); // 恢复保存前的状态

        g.strokeLine(300,400,300,200);

//        g.clearRect(); // 清除区域

        //======================================================================

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(canvas);

        AnchorPane.setLeftAnchor(canvas, 100.0);
        AnchorPane.setTopAnchor(canvas, 100.0);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
