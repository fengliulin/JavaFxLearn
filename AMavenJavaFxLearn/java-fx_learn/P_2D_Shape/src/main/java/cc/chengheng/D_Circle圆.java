package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class D_Circle圆 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(30);

        Circle c1 = new Circle();
        // 以圆心
        c1.setCenterX(0);
        c1.setCenterY(0);
        c1.setFill(Color.RED);
        c1.setRadius(100);

        Circle c2 = new Circle();
        c2.setCenterX(0);
        c2.setCenterY(0);
        c2.setFill(Color.RED);
        c2.setRadius(100);
        c2.setStrokeWidth(3);

        // 一些设置方法和线段还有矩形一样


        hBox.getChildren().addAll(c1);


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
