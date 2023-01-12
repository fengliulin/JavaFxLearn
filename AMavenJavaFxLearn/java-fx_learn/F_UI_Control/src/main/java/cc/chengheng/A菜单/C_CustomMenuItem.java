package cc.chengheng.A菜单;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 */
public class C_CustomMenuItem extends Application {
    public C_CustomMenuItem() {
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


        // 自定义菜单项,只要是node都可以
        CustomMenuItem customMenuItem = new CustomMenuItem();
        Button button = new Button("button");
        customMenuItem.setContent(button);

        menuBar.getMenus().addAll(menu1, menu2, menu3);
        menu1.getItems().addAll(item1,item2,item3, customMenuItem);

        ap.getChildren().add(menuBar);

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