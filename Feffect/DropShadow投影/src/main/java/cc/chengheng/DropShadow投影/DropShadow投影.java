package cc.chengheng.DropShadow投影;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class DropShadow投影 extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(Color.LIGHTBLUE);

        Text text = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24d));

        // 倒影
        Reflection reflection = new Reflection();
        reflection.setFraction(0.8);
        reflection.setTopOffset(1.0);
        text.setEffect(reflection);


        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ellipse, text);


        ellipse.setCenterX(175);
        ellipse.setCenterY(115);

        text.setX(175-(text.getLayoutBounds().getWidth() / 2));
        text.setY(115+(text.getLayoutBounds().getHeight() / 2));
        Group group = new Group(ellipse, text);
        Scene scene = new Scene(group, 350, 230, Color.LIGHTYELLOW);

        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}