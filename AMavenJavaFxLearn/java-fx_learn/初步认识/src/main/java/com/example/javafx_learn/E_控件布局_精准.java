package com.example.javafx_learn;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 每个控件都有3个尺寸：min, pref, max
 * 但是，具体显示的尺寸是由外层容器决定的。
 */
public class E_控件布局_精准 extends Application {

    private TextField textField;
    private Button selectBtn;
    private Button uploadBtn;

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        HBox hBox = new MyHBox(); // 使用自定义的

        textField = new TextField();
        selectBtn = new Button("选择文件");
        uploadBtn = new Button("开始上传");
        hBox.getChildren().addAll(textField, selectBtn, uploadBtn);


        Scene scene = new Scene(hBox, 600, 60);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    class MyHBox extends HBox {
        /**
         * 需要精确布局时，应重写 layoutChildren() 自己摆放每一个子节点
         */
        @Override
        protected void layoutChildren() {
            // 如果完全自己计算布局，就不需要调用super
            super.layoutChildren();

            // 获取 600 60 的宽度和高度
            double width = getWidth();
            double height = getHeight();

            // 计算每个控件的宽度
            double textFieldWidth = 300;
            double selectBtnWidth = (width - textFieldWidth) * 0.5;
            double uploadBtnWidth = width - textFieldWidth - selectBtnWidth;

            // 依次定位：左上角坐标 x,y
            double x = 0;
            textField.resizeRelocate(x, 0, textFieldWidth, height);

            x += textFieldWidth;
            selectBtn.resizeRelocate(x, 0, selectBtnWidth, height);

            x += selectBtnWidth;
            uploadBtn.resizeRelocate(x, 0, uploadBtnWidth, height);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

