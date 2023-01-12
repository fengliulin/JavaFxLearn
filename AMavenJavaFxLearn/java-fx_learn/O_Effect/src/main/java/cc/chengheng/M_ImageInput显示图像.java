package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.function.Consumer;

public class M_ImageInput显示图像 extends Application {
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
        ImageInput ii = new ImageInput();
        ii.setX(0);
        ii.setY(0);
        ii.setSource(new Image(getClass().getResource("/xiaolian.png").toExternalForm()));

        DropShadow ds = new DropShadow();
        ds.setRadius(30);
        ds.setInput(ii);
        return ds;
    }
}
