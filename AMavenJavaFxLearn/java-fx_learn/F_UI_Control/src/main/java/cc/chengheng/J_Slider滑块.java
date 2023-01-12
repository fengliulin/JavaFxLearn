package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Pagination;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class J_Slider滑块 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane ap = new AnchorPane();

        Slider slider = new Slider(0,10,50);
        slider.setPrefWidth(300);
        slider.setShowTickLabels(true);
        slider.setMajorTickUnit(1);

        ap.getChildren().addAll(slider);

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
