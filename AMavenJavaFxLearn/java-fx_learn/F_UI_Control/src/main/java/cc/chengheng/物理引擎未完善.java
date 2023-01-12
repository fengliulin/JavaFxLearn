package cc.chengheng;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class 物理引擎未完善 extends Application {
    private ScheduledService<Double> scheduledService;

    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane ap = new AnchorPane();

        HBox hBox = new HBox();

        for (int i = 0; i < 30; i++) {
            Button b = new Button("javaFx");
            b.setPrefHeight(57);
            hBox.getChildren().add(b);
        }

        AnchorPane.setBottomAnchor(hBox, 0.0);
        Button bu = new Button("JAVAFX");
        bu.setPrefWidth(100);
        bu.setPrefHeight(100);

        ap.getChildren().addAll(bu, hBox);

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
