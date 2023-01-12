package cc.chengheng;

import javafx.application.Application;
import javafx.collections.ObservableMap;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.skin.SliderSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

public class A_Clipboard extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // 剪切板内容
        ClipboardContent content = new ClipboardContent();
        content.put(DataFormat.PLAIN_TEXT, "向剪切板添加内容");



        Clipboard clipboard = Clipboard.getSystemClipboard();

        clipboard.setContent(content);

        Label label = new Label("等待粘贴内容");

        ImageView iv = new ImageView();
        iv.setPreserveRatio(true);
        iv.setFitWidth(300);


        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(label, iv);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        // 快捷键
        KeyCodeCombination kc = new KeyCodeCombination(KeyCode.V, KeyCombination.SHORTCUT_DOWN);
        scene.getAccelerators().put(kc, new Runnable() {
            @Override
            public void run() {
                // 判断剪切版有没有内容，有就取出放入标签里
                if (clipboard.hasString()) {
                    label.setText(clipboard.getString());
                }

                if (clipboard.hasFiles()) {
                    try {
                        // 图片复制过来
                        List<File> files = clipboard.getFiles();
                        Image image = new Image(new FileInputStream(files.get(0)));
                        iv.setImage(image);

                        // 这种也可以获得图片
//                        iv.setImage(clipboard.getImage());

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }
}
