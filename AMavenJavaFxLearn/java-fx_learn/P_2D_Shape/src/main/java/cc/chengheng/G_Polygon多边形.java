package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class G_Polygon多边形 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(30);

        double[] d1 = {
                0, 0,
                100, 0,
                100, 100
        };
        Polygon p1 = new Polygon(d1);

        Polygon p2 = new Polygon();
        p2.getPoints().addAll(0.0, 0.0, 100.0, 0.0, 100.0, 100.0, 0.0, 100.0);

        double[] d3 = {
                0, 0,
                100, 0,
                100, 100,
                200, 150,
                100, 200
        };
        Polygon p3 = new Polygon(d3);

        double[] d4 = {
                0, 0,
                100, 0,
                0, 100,
                100, 100,
        };
        Polygon p4 = new Polygon(d4);
        p4.setFill(Color.RED);
        p4.setStroke(Color.BLUE);
        p4.getStrokeDashArray().addAll(10.0, 10.0);

        hBox.getChildren().addAll(p1, p2, p3, p4);


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
