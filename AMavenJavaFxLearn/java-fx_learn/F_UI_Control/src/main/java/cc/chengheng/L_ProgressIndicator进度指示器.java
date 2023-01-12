package cc.chengheng;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class L_ProgressIndicator进度指示器 extends Application {

    private ScheduledService<Double> scheduledService;

    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane ap = new AnchorPane();

        ProgressIndicator pb = new ProgressIndicator(0);
        pb.setPrefWidth(100);
        pb.setPrefHeight(100);


        ap.getChildren().addAll(pb);

        //=======================================================
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        scheduledService = new ScheduledService<>() {

            private double i = 0;

            @Override
            protected Task<Double> createTask() {
                return new Task<Double>() {
                    @Override
                    protected Double call() throws Exception {
                        return i += 0.1;
                    }

                    @Override
                    protected void updateValue(Double value) {
                        pb.setProgress(i);
                        if (value >= 1) {
                            scheduledService.cancel();
                        }
                    }
                };
            }
        };


        scheduledService.setDelay(Duration.millis(0));
        scheduledService.setPeriod(Duration.millis(1000));
        scheduledService.start();

    }

    public static void main(String[] args) {
        launch();
    }
}
