package cc.chengheng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 要在 JavaFX 应用程序的舞台上显示任何内容，您需要一个scene。
 * 一个舞台一次只能显示一个场景，但可以在运行时交换场景。
 * 就像剧院中的舞台可以在戏剧中重新排列以显示多个场景一样，
 * JavaFX 中的舞台对象可以在 JavaFX 应用程序的生命周期中显示多个场景（一次一个）。
 */
public class A_Stage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Stage s1 = new Stage();
//        s1.initStyle(StageStyle.TRANSPARENT);
        s1.setTitle("s1");


        Stage s2 = new Stage();
        s2.setTitle("s2");



        s2.initOwner(s1); // 关联窗口， 设置模态
        s2.initModality(Modality.WINDOW_MODAL);

        Stage s3 = new Stage();

        s3.setTitle("s3");


        s1.show();
        s2.show();
        s3.show();

//        Platform.exit();
    }
}
