package cc.chengheng.property;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class RotateTransition extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(Color.LIGHTBLUE);

        Text text = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24d));


        text.setOnMouseClicked(event -> {
            System.out.println("text");
        });


        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ellipse, text);


        ellipse.setCenterX(175);
        ellipse.setCenterY(115);


        Scene scene = new Scene(stackPane, 350, 230, Color.LIGHTYELLOW);

        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();

        // 旋转
        javafx.animation.RotateTransition rotate = new javafx.animation.RotateTransition(Duration.millis(2500), stackPane);
        rotate.setToAngle(360);
        rotate.setFromAngle(0);
        rotate.setInterpolator(Interpolator.LINEAR); // 设置插值器


        stackPane.setOnMouseClicked(event -> {
            System.out.println("鼠标点击");
            if (rotate.getStatus().equals(Animation.Status.RUNNING)) {
                rotate.pause();
            } else {
                System.out.println();
                rotate.play();
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}