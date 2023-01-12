package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class J_Path路径 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox();

        Path path = new Path();
        MoveTo mt = new MoveTo(0, 0); // 从哪开始移动

        // 线
        LineTo lt = new LineTo(100, 0);

        // 二次贝塞尔
        QuadCurveTo qc = new QuadCurveTo(100, 0, 100, 100);
        qc.setAbsolute(false); // 修改相对坐标

        // 水平线
        HLineTo ht = new HLineTo(100);
        ht.setAbsolute(false);

        // 三次贝塞尔
        CubicCurveTo cc = new CubicCurveTo(50, -50, 150, 50, 200, 0);
        cc.setAbsolute(false);

        // 垂直线
        VLineTo vt = new VLineTo(100);
        vt.setAbsolute(false);

        // 绘制弧长
        ArcTo ac = new ArcTo(100, 100, 0, 100, 100, true, true);
        ac.setAbsolute(false);

        ClosePath closePath = new ClosePath();

//        path.setFill(Color.BLUE);


        path.getElements().addAll(mt, lt, qc, ht, cc, vt, ac, closePath);

        // 还可以这样
//        MoveTo moveTo = new MoveTo(60, 60);
//        path.getElements().addAll(mt, lt, qc, ht, cc, vt, ac, closePath, moveTo, .....开始画);



        hBox.getChildren().addAll(path);


        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);

        AnchorPane.setLeftAnchor(hBox, 100.0);
        AnchorPane.setTopAnchor(hBox, 100.0);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
