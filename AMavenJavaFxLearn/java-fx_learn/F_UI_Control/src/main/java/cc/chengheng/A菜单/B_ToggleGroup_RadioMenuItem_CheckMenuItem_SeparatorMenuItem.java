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
public class B_ToggleGroup_RadioMenuItem_CheckMenuItem_SeparatorMenuItem extends Application {
    public B_ToggleGroup_RadioMenuItem_CheckMenuItem_SeparatorMenuItem() {
    }

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
        // 添加分隔符
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        MenuItem item3 = new MenuItem("item3");
        MenuItem item4 = new MenuItem("item4", new Button("按钮"));


        // 切换组，菜单有单选选择
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioMenuItem r1 = new RadioMenuItem("r1");
        RadioMenuItem r2 = new RadioMenuItem("r2");
        RadioMenuItem r3 = new RadioMenuItem("r3");
        r1.setToggleGroup(toggleGroup);
        r2.setToggleGroup(toggleGroup);
        r3.setToggleGroup(toggleGroup);

        r1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("r1被选择");
            }
        });

        // 切换组添加到菜单里
//        menu3.getItems().addAll(r1, r2, r3);


        // 多选菜单项目，就是在菜单4可以多打对号
        CheckMenuItem checkMenuItem1 = new CheckMenuItem("checkMenuItem1");
        CheckMenuItem checkMenuItem2 = new CheckMenuItem("checkMenuItem2");
        CheckMenuItem checkMenuItem3 = new CheckMenuItem("checkMenuItem3");
        menu4.getItems().addAll(checkMenuItem1,checkMenuItem2,checkMenuItem3);


        menu1.getItems().addAll(item1,separatorMenuItem,item2);

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