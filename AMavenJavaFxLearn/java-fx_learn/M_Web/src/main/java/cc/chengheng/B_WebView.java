package cc.chengheng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.print.PageLayout;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Start Date: 2021/10/27
 * Author: 冯镠霖(fengliulin)
 */
public class B_WebView extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine(); // 获取网络引擎
        engine.load("http://www.baidu.com");

//        engine.loadContent(); // 加载html

//        webView.setFontScale(0.9); // 设置字体比例





        AnchorPane root = new AnchorPane();
        root.setPrefWidth(600);
        root.setPrefHeight(600);
        root.setStyle("-fx-background-color: #ffb5c5");

        root.getChildren().addAll(webView);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(600);
        primaryStage.setWidth(600);
        primaryStage.show();

        webView.prefWidthProperty().bind(root.widthProperty());
        webView.prefHeightProperty().bind(root.heightProperty());

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Platform.exit();
            }
        });
    }
}
