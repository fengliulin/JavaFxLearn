package com.example.javafx_learn.B对话框.封装对话框;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

// Dialog<Boolean> : showAndWait() 将返回Boolean值
public class AddStudentDialog extends Dialog<Boolean> {
    TextField id = new TextField();
    TextField name = new TextField();
    TextField phone = new TextField();

    public AddStudentDialog() {
        // 对话框内容
        VBox vBox = new VBox();

        id.setPromptText("学号");
        name.setPromptText("姓名");
        phone.setPromptText("手机号");
        vBox.setSpacing(10);
        vBox.getChildren().addAll(id, name, phone);

        // Dialog -> DialogPane -> Root Node
        DialogPane dialogPane = new DialogPane();
        dialogPane.setContent(vBox);

        // 不使用标准操作按钮, 添加一个普通按钮
        Button ok = new Button("确定");
        vBox.getChildren().add(ok);


        ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                setResult(true); // 设置结果并关闭对话框
            }
        });

        // 创建对话框
        this.setDialogPane(dialogPane);
        this.setTitle("添加学生信息");
    }

    private boolean checkValid() {
        return true;
    }

    // 获取用户输入的值
    public Student getValue() {
        try {
            Student v = new Student();
            v.id = Integer.valueOf(id.getText());
            v.name = name.getText();
            v.phone = phone.getText();
            return v;

        } catch (Exception e) {
            return new Student();
        }
    }
}
