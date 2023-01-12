package cc.chengheng;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Platform extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        // 在同UI线程中稍后处理某些事情
        javafx.application.Platform.runLater(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        // false 窗口关闭，程序并未停止
        javafx.application.Platform.setImplicitExit(false);

        // 检查你的电脑是否支持3d图形啊
        boolean supported = javafx.application.Platform.isSupported(ConditionalFeature.SCENE3D);
        System.out.println(supported);




        stage.show();
    }
}
