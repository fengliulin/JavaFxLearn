package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class A_TextField extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        TextField textField = new TextField();
//        textField.setText("设置文本");
        textField.setLayoutX(100);
        textField.setLayoutY(100);

        textField.setPrefWidth(200);
        textField.setPrefHeight(40);

        // 鼠标悬停提示
        Tooltip tip = new Tooltip("这是文本框的提示");
        tip.setFont(Font.font(20));
        textField.setTooltip(tip);


        // 设置文本框内部的提示
        textField.setPromptText("请输入7个字符");
        textField.setFocusTraversable(false);

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue.length() > 7) {
                    textField.setText(oldValue);
                }
            }
        });


        textField.selectedTextProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            }
        });


        // 密码框
        PasswordField passwordField = new PasswordField();

        //


        Group group = new Group();
        group.getChildren().addAll(textField, passwordField);


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