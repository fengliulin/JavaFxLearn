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
 *
 */
public class E_SplitMenuButton extends Application {
    public E_SplitMenuButton() {
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


        // 分割菜单和按钮
        SplitMenuButton splitMenuButton = new SplitMenuButton();
        splitMenuButton.setText("SplitMenuButton");
        splitMenuButton.setLayoutY(100);
        splitMenuButton.getItems().addAll(item1, item2, item3);

        menuBar.getMenus().addAll(menu1, menu2, menu3);
        menu1.getItems().addAll(item1, item2, item3);

        ap.getChildren().addAll(menuBar, splitMenuButton);

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