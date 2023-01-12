package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class B_ImagePattern extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Image image = new Image(getClass().getResource("/xiaolian.png").toExternalForm());


        GridPane gird = new GridPane();
        gird.setHgap(10);
        gird.setVgap(10);

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Circle(150)); // 圆形
        hBox.getChildren().addAll(new Polygon(150, 0, 0, 300, 300, 300)); // 多边形

        // 创建一个 5行5列的格子，每个格子填充一个矩形
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Rectangle rectangle = new Rectangle(150, 150);
                rectangle.setFill(Paint.valueOf("#ededed"));
                gird.add(rectangle, j, i);
            }
        }

        // #ee6aa7 00-FF     后两位透明度
        ArrayList<Color> list = new ArrayList<>();
        list.add(Color.valueOf("#ee6aa7"));
        list.add(Color.valueOf("#ee6aa755"));
        list.add(Color.valueOf("0xee6aa755"));
        list.add(Color.CADETBLUE);


        Rectangle rectangle1 = (Rectangle) gird.getChildren().get(0);
        rectangle1.setFill(new ImagePattern(image));

        Rectangle rectangle2 = (Rectangle) gird.getChildren().get(1);
        rectangle2.setFill(new ImagePattern(image,0,0,0.5,0.5,true));

        Rectangle rectangle3 = (Rectangle) gird.getChildren().get(2);
        rectangle3.setFill(new ImagePattern(image,0,0,30,30,false));

        Rectangle rectangle4 = (Rectangle) gird.getChildren().get(3);
        rectangle4.setFill(new ImagePattern(image,0,0,30,30,false));

        // 形状填充图片
        Circle Circle = (Circle) hBox.getChildren().get(0);
        Circle.setFill(new ImagePattern(image,0,0,150,150,false));

        Polygon polygon = (Polygon) hBox.getChildren().get(1);
        polygon.setFill(new ImagePattern(image,0,0,150,150,false));

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(gird, hBox);

        AnchorPane.setTopAnchor(hBox, 400.0);

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
