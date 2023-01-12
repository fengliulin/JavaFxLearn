package cc.chengheng;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.DepthTest;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class I_ParallelTransition并行动画 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(30);


        Button bu = new Button("Button");

        Rectangle rec = new Rectangle(100, 100, Color.RED);
        // 设置中心坐标
        rec.setX(-50);
        rec.setY(-50);

        // 平移
        TranslateTransition tt = new TranslateTransition();
        tt.setNode(rec);
        tt.setFromX(0);
        tt.setToX(600);
        tt.setDuration(Duration.seconds(6));
        // 自动来回平移
        tt.setAutoReverse(true);
        tt.setCycleCount(Animation.INDEFINITE);



        // 旋转
        RotateTransition rt = new RotateTransition();
        rt.setDuration(Duration.seconds(6));
        rt.setFromAngle(0);
        rt.setToAngle(360);


        // 并行动画
        ParallelTransition pt = new ParallelTransition();
        pt.setNode(rec);
        pt.getChildren().addAll(tt, rt);

        pt.play();








        //======================================================================

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox, bu, rec);

        root.setDepthTest(DepthTest.ENABLE);

        AnchorPane.setLeftAnchor(rec, 100.0);
        AnchorPane.setTopAnchor(rec, 100.0);
        root.setStyle("-fx-background-color: #eeeeee00"); // 需要设置透明度


        // true启用3d渲染       SceneAntialiasing.BALANCED启用抗锯齿优化以平衡质量和性能
        Scene scene = new Scene(root, 1000, 1000, true, SceneAntialiasing.BALANCED);

        // 启动透视相机
        scene.setCamera(new PerspectiveCamera());


        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
