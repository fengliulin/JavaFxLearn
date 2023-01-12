package com.example.javafx_learn.D图形绘制;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Canvas的内部缓冲区
 * 在对Canvas进行绘制时，实际上是绘制到一块内部缓冲区里（内存绘图），并没有绘制到屏幕上。
 * 当窗口更新时，会把缓冲区里的图像一次性显示到屏幕窗口里。
 * Canvas canvas = new Canvas(400,300);
 * 创建一块画布，同时指定缓冲区大小为400x300
 * Canvas.setWidth
 * setHeight   更改缓冲区大小
 * <p>
 * Start Date: 2021/10/21
 * Author: 冯镠霖(fengliulin)
 */
public class A_Canvas内部缓冲区_canvas加入布局 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();

        MyShape ms = new MyShape();

        // 超不过窗口的大小，窗口改变，Pane宽和高也改变
        ms.setPrefWidth(9999);
        ms.setPrefHeight(9999);

        root.getChildren().add(ms);

        Scene scene = new Scene(root, 400, 400, Color.ALICEBLUE); // scene背景色
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @Deprecated
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

/**
 * 内部会先调用resize，在调用layoutChildren， 根据父容器的大小，会重设宽度和高度
 * // MyShape.setPrefWidth(9999);
 *         MyShape.setPrefHeight(9999); 这个是这只最大
 */
class MyShape extends Pane {
    Canvas canvas = new Canvas();

    public MyShape() {
        getChildren().add(canvas);
    }

    @Override
    public void resize(double width, double height) {
        super.resize(width, height);
        double w = getWidth();
        double h = getHeight();
        System.out.println("resize" +w);
        System.out.println("resize" +h);
        // 当Node的尺寸调整时，同时将canvas调整缓冲区的大小
        canvas.setWidth(width);
        canvas.setHeight(height);

        // 更新显示
        update();
    }

    // 在此绘制
    public void update() {
        //
        double w = getWidth();
        double h = getHeight();
        if (w <= 0 || h <= 0) return;

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, w, h);
        gc.setFill(Color.web("#890989"));
        gc.fillOval(0, 0, w, h); // 椭圆
    }

    @Override
    protected void layoutChildren() {
        // 获取Pane的大小
        double w = getWidth();
        double h = getHeight();
        System.out.println("layoutChildren" + w);
        System.out.println("layoutChildren" + h);

        // canvas 内部缓冲区大小
        canvas.setWidth(w);
        canvas.setHeight(w);

        if (w <= 0 || h <= 0) {
            return;
        }
        canvas.resizeRelocate(0, 0, w, h);
    }


}
