package cc.chengheng;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.DepthTest;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class B_RotateTransition旋转动画 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(30);




        Button bu = new Button("Button");

        Rectangle rec = new Rectangle(100, 100, Color.RED);

        bu.translateXProperty().bind(rec.translateXProperty());


        RotateTransition tt = new RotateTransition();
        tt.setDuration(Duration.seconds(3));
        tt.setNode(rec);
        tt.setFromAngle(0);
        tt.setToAngle(600);
        tt.setInterpolator(Interpolator.EASE_IN);

        tt.setAutoReverse(true);

        tt.setCycleCount(Animation.INDEFINITE);

        tt.play();

        //======================================================================

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox, bu, rec);

        root.setDepthTest(DepthTest.ENABLE);

        AnchorPane.setLeftAnchor(bu, 100.0);
        AnchorPane.setTopAnchor(bu, 100.0);
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
