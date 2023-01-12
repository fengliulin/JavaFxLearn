package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class 舞台认识_Stage就是window extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("JavaFx");
//        primaryStage.getIcons().add(new Image(""));
        /*primaryStage.setIconified(true);
        primaryStage.setMaximized(true);
        primaryStage.setResizable(false);*/

        // 添加高度和宽度属性改变监听
        primaryStage.heightProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("当前高度:" + newValue.doubleValue());
        });
        primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("当前宽度:" + newValue.doubleValue());
        });

//        primaryStage.setOpacity(0.6); // 设置透明度

        primaryStage.setAlwaysOnTop(true); // 置顶

        primaryStage.setX(50);
        primaryStage.setY(50);

        primaryStage.xProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });

        primaryStage.setScene(new Scene(new BorderPane(), 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

