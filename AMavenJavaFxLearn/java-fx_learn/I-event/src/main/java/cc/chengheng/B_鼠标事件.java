package cc.chengheng;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class B_鼠标事件 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox(20);
        Button b1 = new Button("button1");
        Button b2 = new Button( "button2");



        Circle cir = new Circle(100, Color.RED);
        cir.setPickOnBounds(true); // 边界，正方形角也可以点击
        cir.setMouseTransparent(true);

        hbox.getChildren().addAll(b1, b2, cir);

        cir.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("f");
            }
        });

        hbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("hbox");
            }
        });


        AnchorPane an = new AnchorPane();

        an.getChildren().add(hbox);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
