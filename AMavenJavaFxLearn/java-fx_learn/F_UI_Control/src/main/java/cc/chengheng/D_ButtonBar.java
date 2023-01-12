package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class D_ButtonBar extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane ap = new AnchorPane();

        ButtonBar buttonBar = new ButtonBar();
        buttonBar.setPrefWidth(300);
        buttonBar.setPrefHeight(300);
        buttonBar.setStyle("-fx-background-color: #ffa07a");

        buttonBar.getButtons().addAll(new Button("1"), new Button("2"), new Button("2"));

//        ButtonBar.setButtonUniformSize(b1,true);

        ap.getChildren().addAll(buttonBar);

        //=======================================================
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
