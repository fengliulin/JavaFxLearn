package cc.chengheng;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.ScheduledService;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class N_Spinner文本框微调上下箭头 extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane ap = new AnchorPane();

        ObservableList<Object> list = FXCollections.observableArrayList();
        list.addAll("A", "B", "C", "D");

        Spinner<Object> spinner = new Spinner<>(list);


        ap.getChildren().add(spinner);

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
