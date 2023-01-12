package cc.chengheng;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class B_Button extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Button button1 = new Button("b1");

        button1.setLayoutX(0);
        button1.setLayoutY(0);
        button1.setPrefWidth(300);
        button1.setPrefHeight(300);

        button1.setFont(Font.font("宋体", 40));

        // 给按钮设置背景颜色和四周的圆角
        BackgroundFill backgroundFill = new BackgroundFill(Color.RED, new CornerRadii(20), new Insets(10));
        Background background = new Background(backgroundFill);
        button1.setBackground(background);

        // 设置Stroke 边框线条
        BorderStroke borderStroke = new BorderStroke(Paint.valueOf("#8A2BE2"),
                BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(10));
        Border border = new Border(borderStroke);
        button1.setBorder(border);

        // Paint.valueOf("#8A2BE200") 后两位代表透明度，前面是颜色



        Button button2 = new Button("b1");

        button2.setLayoutX(0);
        button2.setLayoutY(350);
        button2.setPrefWidth(300);
        button2.setPrefHeight(300);


        // 用javaFx css 设置属性
        button2.setStyle("-fx-background-color: #7ccd7c; -fx-background-radius: 60");

        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Button source = (Button) event.getSource(); // 返回button 节点
                System.out.println(source.getText());
            }
        });



        Group group = new Group();
        group.getChildren().addAll(button1, button2);


        Scene scene = new Scene(group);


        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}