package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DisplacementMap;
import javafx.scene.effect.Effect;
import javafx.scene.effect.FloatMap;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class J_DisplacementMap置换贴图效果 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(200);
        hBox.setAlignment(Pos.CENTER);
        Button button = new Button("Button");
        Text text = new Text("这是一个文班");
        Rectangle rectangle = new Rectangle(100, 100, Paint.valueOf("#8470FF"));
        Circle c = new Circle(50, Paint.valueOf("#ff69b4"));
        hBox.getChildren().addAll(button, text, rectangle, c);

//        button.setEffect(getEffect());

        hBox.getChildren().forEach(new Consumer<Node>() {
            @Override
            public void accept(Node node) {
                node.setEffect(getEffect());
            }
        });


        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }

    public Effect getEffect() {
        DisplacementMap map = new DisplacementMap();
        map.setOffsetX(0.5);
        map.setOffsetY(0.5);
//        map.setWrap(true);


    // ps里面有一个置换
        int w = 100;
        int h = 100;
        FloatMap floatMap = new FloatMap(w, h);
        float value = (float) 0.1;
        for (int i = 0; i < floatMap.getWidth(); i++) {
            for (int j = 0; j < floatMap.getHeight(); j++) {
                float temp = 0;
                if (j < h / 2) {
                    temp = value;
                } else {
                    temp = value * -1;
                }
                floatMap.setSamples(i, j, temp, 0);
            }
        }

        map.setMapData(floatMap);
        return map;
    }
}
