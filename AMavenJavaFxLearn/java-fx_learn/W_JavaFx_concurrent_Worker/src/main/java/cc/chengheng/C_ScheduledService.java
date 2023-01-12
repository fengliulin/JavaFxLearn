package cc.chengheng;

import javafx.application.Application;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class C_ScheduledService extends Application {
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

        MyScheduledService myScheduledService = new MyScheduledService();
        myScheduledService.setDelay(Duration.seconds(1));
        myScheduledService.setPeriod(Duration.seconds(1));
        myScheduledService.start();


        myScheduledService.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });


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


    private static class MyScheduledService extends ScheduledService<Number> {

        @Override
        protected Task<Number> createTask() {

            return new Task<Number>() {

                @Override
                protected void updateValue(Number value) {
                    super.updateValue(value);
                }

                @Override
                protected Number call() throws Exception {
                    System.out.println("你好");
                    return 20; // 这里返回的值给了 updateValue
                }
            };
        }
    }
}
