package cc.chengheng;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class B_Polyline连接线 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox();

        Polyline p1 = new Polyline(0, 0, 100, 100, 200, 100);
        p1.setStrokeWidth(5);
        p1.setStroke(Paint.valueOf("#b03060"));
        p1.setFill(Color.CYAN);

        Polyline p2 = new Polyline();
        p2.getPoints().addAll(0.0, 0.0, 100.0, 100.0, 200.0, 100.0, 0.0,0.0);
        p2.setStrokeWidth(5);
        p2.setStroke(Paint.valueOf("#b03060"));
        p2.setStrokeMiterLimit(2); // 切角

        double[] doubles = {
                0,0,
                100,0,
                0,100,
                100,100,
                0,0
        };
        Polyline p3 = new Polyline(doubles);
        p3.setStrokeWidth(5);
        p3.setStroke(Paint.valueOf("#b03060"));
        p3.setFill(Color.CYAN);

        Polyline p4 = new Polyline(doubles);
        p4.setStrokeWidth(5);
        p4.setStroke(Paint.valueOf("#b03060"));
        p4.setFill(Color.CYAN);
        p4.setStrokeLineCap(StrokeLineCap.ROUND); // 闭合点处理
        p4.setStrokeLineJoin(StrokeLineJoin.ROUND); // 每一个链接的线角处理
        p4.setStrokeType(StrokeType.OUTSIDE); // 线段是画在内部，还是外部，还是居中

        Polyline p5 = new Polyline(doubles);
        p5.setStrokeWidth(2);
        p5.setStroke(Paint.valueOf("#b03060"));
        p5.setFill(Color.CYAN);
        p5.getStrokeDashArray().addAll(10.0, 5.0);


        p5.setOnMouseClicked(event -> {
            System.out.println("点击事件");
        });

        hBox.getChildren().addAll(p1, p2, p3, p4, p5);


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
