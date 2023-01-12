package cc.chengheng;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class A_Group extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Button button1 = new Button("b1");
        Button button2 = new Button("b2");
        Button button3 = new Button("b3");

        button1.setLayoutX(0);
        button1.setLayoutY(0);
        button1.setPrefWidth(50);
        button1.setPrefHeight(50);

        button2.setLayoutX(100);
        button2.setLayoutY(0);

        button3.setLayoutX(200);
        button3.setLayoutY(0);

        // 组
        Group group = new Group();
        group.getChildren().addAll(button1, button2, button3);
//        group.setOpacity(0.5); // 这种透明度，会影响 Group的子组件

        // 判断坐标位，是否包含子节点,  只能检测子组件左上角0,0的位置，
        boolean contains = group.contains(0, 0);
        System.out.println(contains);

        Object[] objects = group.getChildren().toArray();

        // 给子节点添加监听器，子节点改变，监听器执行
        group.getChildren().addListener(new ListChangeListener<Node>() {
            @Override
            public void onChanged(Change<? extends Node> c) {
                System.out.println("监听改变的时候" + c.getList().size());
            }
        });

        button1.setOnAction(new EventHandler<ActionEvent>() {
            private String name;
            @Override
            public void handle(ActionEvent event) {
                System.out.println(A_Group.this);
                System.out.println(this);
                Button b4 = new Button("b4");
                b4.setLayoutX(0);
                b4.setLayoutY(100);
                group.getChildren().add(b4);
            }
        });

//        group.getChildren().remove(0);

//        group.setAutoSizeChildren(false); // 一般不用。 其实是宽和高变成0了

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