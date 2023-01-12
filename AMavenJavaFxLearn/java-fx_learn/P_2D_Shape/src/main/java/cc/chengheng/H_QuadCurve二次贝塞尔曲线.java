package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class H_QuadCurve二次贝塞尔曲线 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(30);
        hBox.setAlignment(Pos.CENTER);

        AnchorPane pane1 = new AnchorPane();
        pane1.setPrefWidth(200);
        pane1.setPrefHeight(200);
        pane1.setStyle("-fx-background-color: #a9a9a9");

        // 带一个控制点的曲线
        QuadCurve q1 = new QuadCurve();
        q1.setStartX(0);
        q1.setStartY(100);

        q1.setEndX(200);
        q1.setEndY(100);

        q1.setControlX(100);
        q1.setControlY(0);

        q1.setFill(Color.TRANSPARENT);
        q1.setStroke(Color.BLUE);

        q1.getStrokeDashArray().addAll(5.0, 5.0);

        pane1.getChildren().add(q1);


        hBox.getChildren().addAll(pane1);


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
