package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.*;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class C_LinearGradient线性渐变 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gird = new GridPane();
        gird.setHgap(10);
        gird.setVgap(10);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                Rectangle rectangle = new Rectangle(200, 200);
                rectangle.setFill(Paint.valueOf("#ededed"));
                gird.add(rectangle, j, i);
            }
        }

        // #ee6aa7 00-FF     后两位透明度
        ArrayList<Paint> list = new ArrayList<>();

        Stop[] stops = new Stop[]{
                new Stop(0, Color.valueOf("#3238b0")),
                new Stop(0.5, Color.valueOf("#e7225e")),
                new Stop(1, Color.valueOf("#35da63")),
        };
        LinearGradient linearGradient1 = new LinearGradient(
                0, 0, 200, 200, false,
                CycleMethod.NO_CYCLE, stops
                );

        list.add(linearGradient1);

        for (int i = 0; i < list.size(); i++) {
            Rectangle rectangle = (Rectangle) gird.getChildren().get(i);
            rectangle.setFill(list.get(i));
        }


        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(gird);

        AnchorPane.setLeftAnchor(gird, 10.0);
        AnchorPane.setTopAnchor(gird, 10.0);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
