package cc.chengheng.A菜单;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * MenuBar: 就是菜单一条
 * Menu:    菜单上的 File Edit View Navigate
 * MenuItem: 菜单项目就是  File下面的内容
 */
public class A_MenuBar_Menu_MenuItem extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane ap = new AnchorPane();
        ap.setStyle(" -fx-background-color:#ffffff");

        MenuBar menuBar = new MenuBar();
        Menu menu1 = new Menu("menu1");
        Menu menu2 = new Menu("menu2");
        Menu menu3 = new Menu("menu3");
        Menu menu4 = new Menu("menu4");
        menuBar.getMenus().addAll(menu1, menu2, menu3, menu4);

        MenuItem item1 = new MenuItem("item1");
        MenuItem item2 = new MenuItem("item2");
        MenuItem item3 = new MenuItem("item3");
        MenuItem item4 = new MenuItem("item4", new Button("按钮"));

        menu1.getItems().addAll(item1,item2);
        menu2.getItems().addAll(menu3,menu4);
        menu2.getItems().addAll(item3,item4);

        menuBar.setLayoutY(10);

//        menuBar.setUseSystemMenuBar(true); // mac系统把菜单条设置到上方

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