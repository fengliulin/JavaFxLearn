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
public class A_TitledPane_Accordion extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane ap = new AnchorPane();


        TitledPane titledPane1 = new TitledPane("TitledPane1", new Button("button"));

        TitledPane titledPane2 = new TitledPane();
        titledPane2.setText("TitledPane2");
        titledPane2.setContent(new Button("button"));

        TitledPane titledPane3 = new TitledPane();
        titledPane3.setText("设置文本");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Button("button3"), new Button("button4"));
        titledPane3.setContent(hBox);
        AnchorPane.setTopAnchor(titledPane2, 100.0);
        titledPane3.setGraphic(new Button("setGraphic"));

        // 设置按钮方向
        titledPane3.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);

        // 设置是否展开
        titledPane3.setExpanded(false);
        titledPane2.setExpanded(false);

        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(titledPane1, titledPane2,titledPane3);
        accordion.setLayoutX(100);
        accordion.setPrefHeight(300);

        ap.getChildren().addAll(titledPane1, titledPane2, titledPane3, accordion);

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
