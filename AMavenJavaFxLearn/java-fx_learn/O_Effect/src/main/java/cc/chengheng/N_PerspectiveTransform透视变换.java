package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.ImageInput;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class N_PerspectiveTransform透视变换 extends Application {
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
        // 根据四个角，来透视变换
        PerspectiveTransform pt = new PerspectiveTransform();
        pt.setUlx(0);
        pt.setUly(0);

        pt.setUrx(100);
        pt.setUry(0);

        pt.setLlx(0);
        pt.setLly(100);

        pt.setLrx(100);
        pt.setLry(100);


        return pt;
    }
}
