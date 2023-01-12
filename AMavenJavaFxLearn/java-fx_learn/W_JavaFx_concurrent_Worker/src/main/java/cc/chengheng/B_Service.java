package cc.chengheng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class B_Service extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);


        Button start = new Button("开始");
        Button cancel = new Button("取消");

        ProgressBar pb = new ProgressBar(0);
        pb.setPrefWidth(200);


        Label l1 = new Label("state");
        Label l2 = new Label("value");
        Label l3 = new Label("title");
        Label l4 = new Label("message");

        hBox.getChildren().addAll(start, cancel, pb, l1, l2, l3, l4);



        //================================================================
        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(hBox);

        AnchorPane.setTopAnchor(hBox, 200.0);
        AnchorPane.setLeftAnchor(hBox, 200.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }


    private static class MyService extends Service<Number> {

        @Override
        protected void executeTask(Task<Number> task) {
            super.executeTask(task);
        }

        @Override
        protected Task<Number> createTask() {
            return null;
        }
    }
}
