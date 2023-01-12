package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.QuadCurve;
import javafx.stage.Stage;

public class I_QuadCurve三次贝塞尔曲线 extends Application {
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

        // 带两个控制点的曲线
        CubicCurve cc = new CubicCurve();
        cc.setStartX(0);
        cc.setStartY(100);

        cc.setEndX(200);
        cc.setEndY(100);

        cc.setControlX1(100);
        cc.setControlY1(0);

        cc.setControlX2(150);
        cc.setControlY2(200);

        cc.setFill(Color.TRANSPARENT);
        cc.setStroke(Color.BLUE);

        cc.getStrokeDashArray().addAll(5.0, 5.0);

        pane1.getChildren().add(cc);


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
