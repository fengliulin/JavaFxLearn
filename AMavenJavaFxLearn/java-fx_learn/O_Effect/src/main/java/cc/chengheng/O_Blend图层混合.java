package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.Effect;
import javafx.scene.effect.PerspectiveTransform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Stack;
import java.util.function.Consumer;

public class O_Blend图层混合 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox1 = new HBox();
        Button b1 = new Button("b1");
        ImageView iv = new ImageView(new Image(getClass().getResource("/DSC_4711.jpg").toExternalForm()));
        iv.setFitHeight(200);
        iv.setFitWidth(200);
        iv.setPreserveRatio(true);
        hBox1.getChildren().addAll(iv, b1);



        HBox hBox2 = new HBox();
        Button b2 = new Button("b1");
        ImageView iv1 = new ImageView(new Image(getClass().getResource("/DSC_4711.jpg").toExternalForm()));
        iv1.setFitHeight(200);
        iv1.setFitWidth(200);
        iv1.setPreserveRatio(true);
        hBox2.getChildren().addAll(iv1, b2);
//        hBox2.setTranslateX(20);

        // 图层混合
        hBox2.setEffect(getEffect());

        StackPane g = new StackPane();
        g.getChildren().add(hBox1);
        g.getChildren().add(hBox2);





        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(g);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }

    public Effect getEffect() {
        Blend blend = new Blend();
        blend.setMode(BlendMode.SRC_OVER);
        blend.setOpacity(0.5);
        return blend;
    }
}
