package cc.chengheng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.function.Consumer;

/**
 * Start Date: 2021/10/27
 * Author: 冯镠霖(fengliulin)
 */
public class C_WebHistory extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine(); // 获取网络引擎
        engine.load("http://www.baidu.com");

        WebHistory history = engine.getHistory();
        ObservableList<WebHistory.Entry> entries = history.getEntries();

        HBox hBox = new HBox(20);
        Button b1 = new Button("后退");
        Button b2 = new Button("前进");
        Button b3 = new Button("信息");
        hBox.getChildren().addAll(b1, b2, b3);

        AnchorPane root = new AnchorPane();
        root.setPrefWidth(600);
        root.setPrefHeight(600);
        root.setStyle("-fx-background-color: #ffb5c5");

        root.getChildren().addAll(webView, hBox);

        AnchorPane.setTopAnchor(webView, 30.0);


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

        b3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("当前页面的索引=" + history.getCurrentIndex());
                System.out.println("当前最大存储=" + history.getMaxSize());

                entries.forEach(new Consumer<WebHistory.Entry>() {
                    @Override
                    public void accept(WebHistory.Entry entry) {
                        System.out.println();
                    }
                });
            }
        });

        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                history.go(-1);
            }
        });

        b2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                history.go(1);
            }
        });
    }
}
