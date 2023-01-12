package com.example.javafx_learn.B对话框;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Start Date: 2021/10/21
 * Author: 冯镠霖(fengliulin)
 */
public class B自定义对话框 extends Application {
    TextArea textArea = new TextArea();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();
        root.setCenter(textArea);
        Button addition = new Button("添加");
        root.setTop(addition);

        Scene scene = new Scene(root, 400, 400);

        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        stage.setScene(scene);
        stage.show();


        // 按钮事件
        addition.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // 对话框内容
                VBox vBox = new VBox();
                TextField id = new TextField();
                TextField name = new TextField();
                TextField phone = new TextField();

                id.setPromptText("学号");
                name.setPromptText("姓名");
                phone.setPromptText("手机号");

                vBox.setSpacing(10);
                vBox.getChildren().addAll(id, name, phone);

                // 创建一个对话框的面板，把VBox放进去
                DialogPane dialogPane = new DialogPane();
                dialogPane.setContent(vBox);

                // 添加按钮
                ButtonType ok = new ButtonType("确定", ButtonBar.ButtonData.OK_DONE);
                dialogPane.getButtonTypes().add(ok);

                //==========================关键代码===============================
                // 创建对话框一个窗体， 需要放置一个对话框的面板容器， 对面框的面板容器就可以放你想要的组件
                Dialog<ButtonType> dlg = new Dialog<>();
                dlg.setDialogPane(dialogPane);
                dlg.setTitle("添加学生信息");

                dlg.initModality(Modality.APPLICATION_MODAL); // 模态设置，可以设置非模态和模态

                // 显示对话框
                Optional<ButtonType> result = dlg.showAndWait();

                //  接收返回结果
                if (result.isPresent() && result.get().getButtonData() == ButtonBar.ButtonData.OK_DONE) {
                    int id1 = Integer.valueOf(id.getText());
                    String name1 = name.getText();
                    String phone1 = phone.getText();
                    textArea.appendText("学号: " + id + "\t姓名:" + name + "\t手机号:" + phone + "\n");
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
