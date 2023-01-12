package cc.chengheng;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class C_fireEvent extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox(20);
        hbox.setStyle("-fx-background-color: #ffff55");
        Button b1 = new Button("button1");
        Button b2 = new Button( "button2");

        Circle circle = new Circle(100, Color.RED);
        circle.setPickOnBounds(false); // 是否点击圆外的矩形
        circle.setMouseTransparent(false); // 设置鼠标透明度

        hbox.getChildren().addAll(b1, b2, circle);


        KeyEvent keyEvent = new KeyEvent(b2, b2,
                KeyEvent.KEY_PRESSED,
                "a123", "123", // 随意
                KeyCode.A,
                false, false, false, false
        );

        b1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                // 调用b2，的键盘按下事件
                MouseEvent.fireEvent(b2, keyEvent);
            }
        });

        b2.setOnMouseClicked(event -> {
            System.out.println("b2");
        });

        b2.setOnKeyPressed(event -> {
            System.out.println("b2键盘" + event.getCode().getName());
        });



        AnchorPane an = new AnchorPane();
        AnchorPane.setTopAnchor(hbox, 100.0);
        AnchorPane.setLeftAnchor(hbox,100.0);

        an.getChildren().add(hbox);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
