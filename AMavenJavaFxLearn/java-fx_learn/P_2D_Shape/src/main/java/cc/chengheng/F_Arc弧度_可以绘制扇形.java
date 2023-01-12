package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class F_Arc弧度_可以绘制扇形 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(30);

        Arc a1 = new Arc();
        a1.setCenterX(0);
        a1.setCenterY(0);
        a1.setFill(Color.RED);
        a1.setRadiusX(100);
        a1.setRadiusY(100);
        a1.setLength(90); // 指的是圆心角度对应的弧长， 90是圆心的角度
//        a1.setStartAngle(30);
        a1.setType(ArcType.ROUND);
        a1.setStrokeWidth(3);
        a1.setStroke(Color.BLACK);



        hBox.getChildren().addAll(a1);


        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);

        AnchorPane.setLeftAnchor(hBox, 100.0);
        AnchorPane.setTopAnchor(hBox, 100.0);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(500);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
