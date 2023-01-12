package com.example.javafx_learn;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 布局容器是可以嵌套的，最终构成一个树型结构。
 * 每一个节点可能是 容器、控件、形状、文本.....
 *
 * 布局的嵌套
 * Node树的结构：
 * root ( BorderPane)
 *  |____top(HBox)
 *  |     |____TextField
 *  |     |____Button
 *  |____center(TextArea)
 */
public class F_布局嵌套 extends Application {

    private TextField textField;
    private Button addition;
    private TextArea textArea;

    @Override
    public void start(Stage stage) throws IOException {
        HBox hbox = new HBox();

        textField = new TextField();
        addition = new Button("添加");
        textArea = new TextArea(); // 多行文本


        hbox.getChildren().addAll(textField, addition);
        HBox.setHgrow(textField, Priority.ALWAYS);

        // BorderPane里嵌套HBox
        BorderPane root = new BorderPane();
        root.setTop(hbox);
        root.setCenter(textArea);


        // 事件
        addition.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textField.getText();
                textArea.appendText(text + "\n");
            }
        });



        Scene scene = new Scene(root, 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}