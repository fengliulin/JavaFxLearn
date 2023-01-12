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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class P_ScrollPane滚动面板 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Button button = new Button("button");
        AnchorPane ap = new AnchorPane();

        VBox box = new VBox();

        HBox hBox = new HBox(10);
        for (int i = 0; i < 10; i++) {
            hBox.getChildren().add(new Button("button" + i));
        }

        VBox vBox = new VBox(10);
        for (int i = 0; i < 10; i++) {
            vBox.getChildren().add(new Button("button" + i));
        }


        ScrollPane scp = new ScrollPane();
        scp.setPrefWidth(300);
        scp.setPrefHeight(200);

        box.getChildren().addAll(hBox, vBox);
        scp.setContent(box);


        ap.getChildren().addAll(scp);

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
