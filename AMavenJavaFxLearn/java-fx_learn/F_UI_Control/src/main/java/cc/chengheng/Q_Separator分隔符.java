package cc.chengheng;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class Q_Separator分隔符 extends Application {

    private ScheduledService<Double> scheduledService;

    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane ap = new AnchorPane();

        HBox hBox = new HBox();

        Button b1 = new Button("b1");
        Button b2 = new Button("b1");

        Separator sep = new Separator();
        sep.setPrefWidth(200);
        sep.setPrefHeight(50);
        sep.setHalignment(HPos.RIGHT); // 设置对齐
        sep.setValignment(VPos.CENTER);

        hBox.getChildren().addAll(b1, sep, b2);


        ap.getChildren().add(hBox);

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
