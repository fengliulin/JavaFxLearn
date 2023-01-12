package com.example.javafx_learn.C菜单;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.HTMLEditor;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Start Date: 2021/10/21
 * Author: 冯镠霖(fengliulin)
 */
public class C菜单 extends Application {

    HTMLEditor editor = new HTMLEditor(); // javafx 自带的编辑器

    MenuBar menuBar = new MenuBar();

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();

        // mac系统设置显示上方菜单，不设置和windows一样显示到窗口里
        menuBar.setUseSystemMenuBar(true);

        Menu menuFile = new Menu("文件");
        Menu menuEdit = new Menu("编辑");
        menuBar.getMenus().addAll(menuFile, menuEdit);

        MenuItem menuItemOpen = new MenuItem("打开", new ImageView(new Image(getClass().getResource("ic_open.png").toExternalForm())));
        MenuItem menuItemSave = new MenuItem("保存");
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem menuItemExit = new MenuItem("退出");
        menuFile.getItems().addAll(menuItemOpen, menuItemSave, menuItemExit);
        menuBar.setId("dddd");
        root.setTop(menuBar);
        root.setCenter(editor);

        Scene scene = new Scene(root, 640, 400);
        stage.setScene(scene);
        stage.setTitle("我的javaFX学习");
        stage.show();

        // 打开文件事件
        menuItemOpen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("打开文件");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

                // 可以从任意控件 Node 获取到 Window 对象，传给showOpenDialog()
                // Node.getScene().getWindow()
                File selectedFile = fileChooser.showOpenDialog(root.getScene().getWindow());
                if (selectedFile == null) return; // 用户没有选中文件, 已经取消操作

                try {
                    String text = TextFileUtils.read(selectedFile, "UTF-8");
                    editor.setHtmlText(text);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // 保存文件事件
        menuItemSave.setOnAction((ActionEvent e) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("保存文件");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));

            File selectedFile = fileChooser.showSaveDialog(root.getScene().getWindow());
            if (selectedFile == null) return; // 用户没有选中文件, 已经取消操作

            try {
                String text = editor.getHtmlText();
                TextFileUtils.write(selectedFile, text, "UTF-8");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        menuItemExit.setOnAction((ActionEvent e)->{
            Platform.exit();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}


class TextFileUtils {
    public static String read(File f, String charset) throws Exception {
        FileInputStream fstream = new FileInputStream(f);
        try {
            int fileSize = (int) f.length();
            if (fileSize > 1024 * 512)
                throw new Exception("File too large to read! size=" + fileSize);

            byte[] buffer = new byte[fileSize];
            fstream.read(buffer);
            return new String(buffer, charset);
        } finally {
            try {
                fstream.close();
            } catch (Exception e) {
            }
        }
    }

    public static void write(File f, String text, String charset) throws Exception {
        FileOutputStream fstream = new FileOutputStream(f);
        try {
            fstream.write(text.getBytes(charset));
        } finally {
            fstream.close();
        }
    }
}

