package cc.chengheng;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class D_addEventFilter事件捕获_addEventFilter事件冒泡 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox(20);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPrefWidth(400);
        hbox.setPrefHeight(400);
        hbox.setStyle("-fx-background-color: #ffff55");

        Button b1 = new Button("button1");

        Label label = new Label("标签");
        label.setFont(new Font(20));
        label.setStyle("-fx-background-color: #87Cefa");

        hbox.getChildren().addAll(b1, label);


        AnchorPane an = new AnchorPane();
        an.setStyle("-fx-background-color: #FF7256");

        an.getChildren().add(hbox);

        AnchorPane.setTopAnchor(hbox,100.0);
        AnchorPane.setLeftAnchor(hbox,100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();


        // 点击子节点会捕获事件， 必须是相同类型的事件
        // 事件过滤器, 可以让按钮处理事件
        /*b1.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("b1" + event.getEventType());
        });

        hbox.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("hbox" + event.getEventType());
        });

        an.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println("an" + event.getEventType());
        });*/

        // 事件冒泡
        label.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("label" + event.getEventType());
            }
        });

        hbox.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("hbox" + event.getEventType());
            }
        });

        an.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("an" + event.getEventType());
            }
        });
    }
}
