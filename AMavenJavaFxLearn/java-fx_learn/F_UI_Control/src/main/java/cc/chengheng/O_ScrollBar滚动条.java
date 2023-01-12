package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class O_ScrollBar滚动条 extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {

        Button button = new Button("button");
        AnchorPane ap = new AnchorPane();

        VBox vBox = new VBox(10);
        for (int i = 0; i < 10; i++) {
            vBox.getChildren().add(new Button("button" + i));
        }


        ScrollBar sc = new ScrollBar();
        sc.setOrientation(Orientation.VERTICAL);
        sc.setLayoutX(150);
        sc.setVisibleAmount(50);
        sc.setValue(20);

        sc.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
                vBox.setLayoutY(-newValue.doubleValue());
            }
        });

        button.setLayoutX(200);

        ap.getChildren().addAll(sc, vBox, button);

        //=======================================================
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        sc.setPrefHeight(vBox.getHeight());
        sc.setMax(vBox.getHeight());

        // 设置滚动条空白处点击可以改
        sc.setBlockIncrement(20);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // 设置每次滚动多少像素,在调用自增
                sc.setUnitIncrement(10);
                sc.increment();
            }
        });



    }

    public static void main(String[] args) {
        launch();
    }
}
