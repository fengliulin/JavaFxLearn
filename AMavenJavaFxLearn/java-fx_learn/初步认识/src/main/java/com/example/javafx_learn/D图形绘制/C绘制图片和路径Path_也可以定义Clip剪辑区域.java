package com.example.javafx_learn.D图形绘制;

import com.example.javafx_learn.FileRelativePath;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Start Date: 2021/10/21
 * Author: 冯镠霖(fengliulin)
 */
public class C绘制图片和路径Path_也可以定义Clip剪辑区域 extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        Image image = new Image(FileRelativePath.getRelativePath() + "/IMG_3818.PNG");
        ImagePane imagePane = new ImagePane();
        imagePane.setImage(image);
        root.setCenter(imagePane);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class ImagePane extends Pane {
    Canvas canvas = new Canvas();
    Image image;

    public ImagePane() {
        getChildren().add(canvas);
    }

    public void setImage(Image image) {
        this.image = image;
        update();

    }

    @Override
    protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();

        canvas.setWidth(w);
        canvas.setHeight(h);
        canvas.resizeRelocate(0, 0, w, h);
        update();
    }

    /**
     *
     */
    public void update() {
        if (image == null) return;

        // 窗口大小
        double w = getWidth();
        double h = getHeight();

        // 图片的大小
        double imgw = image.getWidth();
        double imgh = image.getHeight();

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, w, h);


//		gc.drawImage(image,
//				0,0,imgw, imgh, // 要画图片的哪一部分
//				0, 0, w, h // 要画到哪里去
//				);

        // 居中、适应窗口、保持长宽比
        Rectangle2D source = new Rectangle2D(0, 0, image.getWidth(), image.getHeight());
        Rectangle2D target = new Rectangle2D(0, 0, w, h);
        Rectangle2D fitRect = FXImageUtils.centerInside(source, target);
        drawImage(gc, image, fitRect);
        drawPath();
    }

    // 画图
    private void drawImage(GraphicsContext gc, Image image, Rectangle2D r) {
        gc.drawImage(image,
                0, 0, image.getWidth(), image.getHeight(),
                r.getMinX(), r.getMinY(), r.getWidth(), r.getHeight()
        );
    }

    /**
     * 绘制路径
     */
    public void drawPath() {
        if (image == null) return;

        // 窗口大小
        double w = getWidth();
        double h = getHeight();
        if (w <= 0 || h <= 0) return;

        // 图片的大小
        double imgw = image.getWidth();
        double imgh = image.getHeight();

        GraphicsContext gc = canvas.getGraphicsContext2D();
//        gc.clearRect(0, 0, w, h);

        gc.save(); // 使用clip之前先备份一下初始绘制参数
        gc.beginPath();

        // 起点 (50,100)
        gc.moveTo(50, 100);

        // 画直线到 (100,100)
        gc.lineTo(100, 100);

        // 画圆弧: 中心点 (200,100), 半径(100), 起始角度180, 跨度 270度
        gc.arc(200, 100, 100, 100, 180, 270);

        // 画直线回到起始点
        gc.closePath();

        gc.stroke(); // 这个方法画

        // 设定剪辑区域
//        gc.clip();  // 只有内部的才会画出图，其他的不会画

        // 绘图
        /*gc.drawImage(image,
                0, 0, imgw, imgh,
                0, 0, w, h );*/


        gc.restore(); // 使用clip之前先备份一下初始绘制参数

    }
}

    class FXImageUtils {
        // 拉伸图片填满
        public static Rectangle2D fitXY(Rectangle2D source, Rectangle2D target) {
            return target;
        }

        public static Rectangle2D fitCenter(Rectangle2D source, Rectangle2D target) {
            double target_w = target.getWidth();
            double target_h = target.getHeight();

            double image_w = source.getWidth();
            double image_h = source.getHeight();

            if (image_w <= 0) image_w = 1;
            if (image_h <= 0) image_h = 1;

            double scaled_w = target_w;
            double scaled_h = image_h * target_w / image_w;
            if (scaled_h > target_h) {
                scaled_h = target_h;
                scaled_w = target_h * image_w / image_h;
            }

            // 坐在中心
            double x = (target_w - scaled_w) / 2;
            double y = (target_h - scaled_h) / 2;
            x += target.getMinX();
            y += target.getMinY();
            return new Rectangle2D(x, y, scaled_w, scaled_h);
        }

        // 居中显示 (或图片超出则按比例缩小, 否则原图显示)
        public static Rectangle2D centerInside(Rectangle2D source, Rectangle2D target) {
            if (source.getWidth() > target.getWidth() || source.getHeight() > target.getHeight())
                return fitCenter(source, target);

            double x = (target.getWidth() - source.getWidth()) / 2;
            double y = (target.getHeight() - source.getHeight()) / 2;
            x += target.getMinX();
            y += target.getMinY();

            return new Rectangle2D(x, y, source.getWidth(), source.getHeight());
        }

        // 居中显示 (或图片超出则截掉超出的部分, 否则原图显示)
        public static Rectangle2D centerCrop(Rectangle2D source, Rectangle2D target) {
            return null;
        }

    }


