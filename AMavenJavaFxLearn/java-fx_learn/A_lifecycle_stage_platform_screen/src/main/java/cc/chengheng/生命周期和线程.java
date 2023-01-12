package cc.chengheng;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class 生命周期和线程 extends Application {

    @Override
    public void init() throws Exception {
        System.out.println("init " + Thread.currentThread().getName());
    }

    @Override
    public void start(Stage stage) throws IOException {
        System.out.println("start " + Thread.currentThread().getName());
        stage.setTitle("Hello!");
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop " + Thread.currentThread().getName());
        super.stop();
    }

    public static void main(String[] args) {
        System.out.println("main " + Thread.currentThread().getName());
        launch();
    }
}