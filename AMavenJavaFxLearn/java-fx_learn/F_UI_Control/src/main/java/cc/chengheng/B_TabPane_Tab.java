package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class B_TabPane_Tab extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane ap = new AnchorPane();

        TabPane tabPane = new TabPane();
        tabPane.setPrefWidth(300);
        tabPane.setPrefHeight(300);
        tabPane.setStyle("-fx-background-color: #ffa07a");
        Tab tab1 = new Tab("tab1");
        Tab tab2 = new Tab("tab1");
        Tab tab3 = new Tab("tab1");

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Button("button"), new Button("button1"));
        tab1.setContent(hBox);

        tabPane.getTabs().addAll(tab1, tab2, tab3);


        ap.getChildren().addAll(tabPane);

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
