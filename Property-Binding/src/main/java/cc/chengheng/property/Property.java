package cc.chengheng.property;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.When;
import javafx.beans.value.ObservableObjectValue;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Property extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(Color.LIGHTBLUE);

        Text text = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24d));

        Text text2 = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24d));

        text2.setOnMouseClicked(event -> {
            text2.setRotate(100d);
            System.out.println("text");
        });


        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ellipse, text);

        VBox vBox = new VBox(30);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(stackPane,text2);



        Scene scene = new Scene(vBox, 350, 230, Color.LIGHTYELLOW);

        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();






        javafx.animation.RotateTransition rotate = new javafx.animation.RotateTransition(Duration.millis(2500), stackPane);
        rotate.setToAngle(360);
        rotate.setFromAngle(0);
        rotate.setInterpolator(Interpolator.LINEAR); // 设置插值器


        // Binding
        text2.rotateProperty().bindBidirectional(stackPane.rotateProperty());

        text2.textProperty().bind(stackPane.rotateProperty().asString("%.1f"));

        text2.strokeProperty().bind(new When(rotate.statusProperty().isEqualTo(Animation.Status.RUNNING))
                .then(Color.GREEN).otherwise(Color.RED));




        // 属性监听
        rotate.statusProperty().addListener(new InvalidationListener() { // 无效属性监听
            @Override
            public void invalidated(Observable observable) {
                text.setText("Animation status: " +
                        ((ObservableObjectValue<Animation.Status>)observable).getValue());
            }
        });

        rotate.statusProperty().addListener((observable, oldValue, newValue) -> { // 属性改变监听
            text.setText("旧的值" + oldValue + ", 新值" + newValue);
        });


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