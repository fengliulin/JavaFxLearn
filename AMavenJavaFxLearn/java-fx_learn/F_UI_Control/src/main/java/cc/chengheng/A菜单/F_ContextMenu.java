package cc.chengheng.A菜单;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 上下文菜单， 就是右键出现的菜单
 */
public class F_ContextMenu extends Application {
    public F_ContextMenu() {
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane ap = new AnchorPane();

        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("menu1");
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");


        MenuItem item1 = new MenuItem("item1");
        MenuItem item2 = new MenuItem("item3");
        MenuItem item3 = new MenuItem("item3");


        // 上下文菜单
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().addAll(item1, item2, item3);


        menuBar.getMenus().addAll(menu1, menu2, menu3);
        menu1.getItems().addAll(item1, item2, item3);


        menuBar.setContextMenu(contextMenu);

        // 上下文菜单事件, 菜单弹出来事件就触发了
        menuBar.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
            @Override
            public void handle(ContextMenuEvent event) {
                System.out.println("d");
            }
        });

        ap.getChildren().addAll(menuBar);

        //=======================================================
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        menuBar.setPrefWidth(primaryStage.getWidth());
        menuBar.setPrefHeight(30);

        ap.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                menuBar.setPrefWidth(newValue.doubleValue());
            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
}