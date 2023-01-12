package com.example.javafx_learn.B对话框;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Start Date: 2021/10/21
 * Author: 冯镠霖(fengliulin)
 */
public class A提示对话框 extends Application {
    TextField username = new TextField();
    PasswordField password = new PasswordField();
    Button login = new Button("登录");

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();

        VBox vbox = new VBox();
        vbox.getChildren().addAll(username, password, login);
        vbox.setSpacing(10); // 子控件的间距

        root.setCenter(vbox);
        root.setId("root"); // application.css 样式定义

        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        // 按钮事件
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String user = username.getText();
                String pass = password.getText();

                /*
                理解"模式对话框"
                    什么叫模式对话框(Modal）？
                    1、showAndWait0时，当前输入的焦点在对话框里，后面的界面无法输入。
                    2、程序卡在 showAndWait0 不往下走，直到对话框关闭
                 */

                if (!user.equals("feng") || !pass.equals("1")) {
                    Alert warning = new Alert(Alert.AlertType.WARNING);
                    warning.setHeaderText("出错");
                    warning.setContentText("用户名错误");
//                    warning.showAndWait();
                    System.out.println("showAndWait 会卡住，里面一个无限的循环");
                } else {
                    Alert warning = new Alert(Alert.AlertType.INFORMATION);
                    warning.setHeaderText("成功");
                    warning.setContentText("欢迎进入系统");
                    warning.showAndWait();
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
