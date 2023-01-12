package cc.chengheng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * 对话框面板
 */
public class I_DialogPane_ScheduledService extends Application {

    private DialogPane dialogPane;
    @Override
    public void start(Stage primaryStage) throws IOException {

        Button btn1 = new Button("点击显示DialogPane");

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // 对话框面板，也可以不用它，别的也可以
               dialogPane = new DialogPane();
                dialogPane.setHeaderText("headerText");
                dialogPane.setContentText("contentText");
                dialogPane.getButtonTypes().add(ButtonType.APPLY);

                // 显示详情信息
                dialogPane.setExpandableContent(new Text("这是扩展内容"));

                Stage stage = new Stage();
                Scene scene = new Scene(dialogPane);
                stage.setScene(scene);
                stage.show();

            }
        });


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(btn1);

        //
       /* Platform.runLater(new Runnable() {
            @Override
            public void run() {

            }
        });*/

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        // 定时执行
        MyScheduledService myScheduledService = new MyScheduledService(dialogPane, primaryStage);
        myScheduledService.setDelay(Duration.millis(0));
        myScheduledService.setPeriod(Duration.millis(1000));
        myScheduledService.start();

    }

    private static class MyScheduledService extends ScheduledService<Integer> {
        private DialogPane di = null;
        private Stage stage = null;

        public MyScheduledService(DialogPane di, Stage stage) {
            this.di = di;
            this.stage = stage;
        }

        @Override
        protected Task<Integer> createTask() {

            return new Task<Integer>() {

                // 返回的值给了 updateValue 的参数
                @Override
                protected Integer call() throws Exception {
                    return 10;
                }

                @Override
                protected void updateValue(Integer value) {
                    // 通过这里可以更改
                    System.out.println(value);
                }
            };
        }
    }

    public static void main(String[] args) {
        launch();
    }
}