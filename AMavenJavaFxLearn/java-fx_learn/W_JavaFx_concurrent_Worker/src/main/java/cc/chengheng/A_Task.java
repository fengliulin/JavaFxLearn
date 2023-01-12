package cc.chengheng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class A_Task extends Application {
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


        MyTask myTask = new MyTask();
        // Task
        Thread task = new Thread(myTask);

        start.setOnAction(event -> {
            task.start();
        });

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                myTask.cancel();
            }
        });

        myTask.progressProperty().addListener((observable, oldValue, newValue) -> {
            pb.setProgress(newValue.doubleValue());
        });

        myTask.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                l2.setText(newValue.toString());
            }
        });

        myTask.messageProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                l4.setText(newValue);
            }
        });

        myTask.stateProperty().addListener(new ChangeListener<Worker.State>() {
            @Override
            public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
                l1.setText(newValue.toString());
            }
        });

        myTask.exceptionProperty().addListener(new ChangeListener<Throwable>() {
            @Override
            public void changed(ObservableValue<? extends Throwable> observable, Throwable oldValue, Throwable newValue) {

            }
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


    private static class MyTask extends Task<Number> {

        @Override
        protected void updateTitle(String title) {
            super.updateTitle(title);
            System.out.println("updateTitle");
        }

        /**
         * 这个是ui线程
         * true JavaFX Application Thread
         *
         * @param value
         */
        @Override
        protected void updateValue(Number value) {
            super.updateValue(value);
            System.out.println(Platform.isFxApplicationThread() + " " + Thread.currentThread().getName()); // true
        }

        @Override
        protected void updateProgress(long workDone, long max) {
            super.updateProgress(workDone, max);
        }

        @Override
        protected void updateProgress(double workDone, double max) {
            super.updateProgress(workDone, max);
        }

        @Override
        protected void updateMessage(String message) {
            super.updateMessage(message);
            System.out.println("updateMessage");
        }

        // 先运行这个
        // false Thread-4
        @Override
        protected Number call() throws Exception {
            // 给任务起个名称
            this.updateTitle("复制");

            System.out.println(Platform.isFxApplicationThread() + " " + Thread.currentThread().getName());  // false， 并不是ui线程
            String s = getClass().getResource("/阿悠悠-责无旁贷.mp3").getPath();

            String decode = URLDecoder.decode(s, StandardCharsets.UTF_8);

            FileInputStream fis = new FileInputStream(decode);

            double max = fis.available(); // 获取多少个字节

            FileOutputStream fos = new FileOutputStream("/Users/fengliulin/Documents/阿悠悠-责无旁贷.mp3");

            byte[] readByte = new byte[1024];
            int i = 0;


            double sum = 0;
            double progress = 0;

            while ((i = fis.read(readByte, 0, readByte.length)) > -1) {
                fos.write(readByte, 0, i);

                sum += i;

                // 更新的进度任务
                this.updateProgress(sum, max);

                progress = sum / max; // 计算百分比

                System.out.println(progress);

                if (progress < 0.5) {
                    this.updateMessage("请耐心等待");
                } else if (progress < 0.8) {
                    updateMessage("马上就好");
                } else if (progress >= 1) {
                    updateMessage("完成");
                }

//                Thread.sleep(50);
            }

            fis.close();
            fos.close();
            return 0;
        }
    }
}
