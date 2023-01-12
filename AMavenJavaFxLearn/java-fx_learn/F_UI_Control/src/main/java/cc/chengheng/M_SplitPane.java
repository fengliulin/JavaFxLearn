package cc.chengheng;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class M_SplitPane extends Application {

    private ScheduledService<Double> scheduledService;

    @Override
    public void start(Stage primaryStage) throws IOException {

        AnchorPane ap = new AnchorPane();

        Button b1 = new Button("button1");
        Button b2 = new Button("button2");
        Button b3 = new Button("button3");
        Button b4 = new Button("button4");


        SplitPane sp = new SplitPane();
        sp.setPrefWidth(300);

        SplitPane sp1 = new SplitPane();
        sp1.setPrefWidth(300);
        sp1.getItems().add(b1);

        SplitPane sp2 = new SplitPane();
        sp2.getItems().add(b2);

        SplitPane sp3 = new SplitPane();
        sp3.getItems().add(b3);

        SplitPane sp4 = new SplitPane();
        sp4.getItems().add(b4);

        sp.setOrientation(Orientation.VERTICAL);
        sp.getItems().addAll(sp1, sp2, sp3);

        ap.getChildren().add(sp);

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
