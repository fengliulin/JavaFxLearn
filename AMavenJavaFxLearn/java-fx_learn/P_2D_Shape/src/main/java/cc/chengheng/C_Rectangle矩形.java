package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class C_Rectangle矩形 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(30);

        Rectangle rectangle1 = new Rectangle();
        // 坐标设置是否有效，要看父节点是否支持点位布局
        rectangle1.setX(0);
        rectangle1.setY(0);
        rectangle1.setHeight(100);
        rectangle1.setWidth(100);
        rectangle1.setFill(Color.BLUE);

        Rectangle rectangle2 = new Rectangle();
        rectangle2.setX(0);
        rectangle2.setY(0);
        rectangle2.setHeight(100);
        rectangle2.setWidth(100);
        rectangle2.setFill(Color.BLUE);
        rectangle2.setArcWidth(30);
        rectangle2.setArcHeight(30);

        Rectangle rectangle3 = new Rectangle();
        rectangle3.setX(0);
        rectangle3.setY(0);
        rectangle3.setHeight(100);
        rectangle3.setWidth(100);
        rectangle3.setFill(Color.BLUE);
        rectangle3.setArcWidth(30);
        rectangle3.setArcHeight(30);
        rectangle3.setStrokeWidth(5);
        rectangle3.setStroke(Color.RED);

        Rectangle rectangle4 = new Rectangle();
        rectangle4.setX(0);
        rectangle4.setY(0);
        rectangle4.setHeight(100);
        rectangle4.setWidth(100);
        rectangle4.setFill(Color.valueOf("#ffff5505"));
        rectangle4.setArcWidth(30);
        rectangle4.setArcHeight(30);
        rectangle4.setStrokeWidth(5);
        rectangle4.setStroke(Color.RED);
        rectangle4.getStrokeDashArray().addAll(10.0, 20.0); // 边框变虚线


        hBox.getChildren().addAll(rectangle1, rectangle2, rectangle3, rectangle4);


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
