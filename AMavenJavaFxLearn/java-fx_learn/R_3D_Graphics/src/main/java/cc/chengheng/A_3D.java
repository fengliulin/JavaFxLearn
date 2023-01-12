package cc.chengheng;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.scene.DepthTest;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class A_3D extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println(Platform.isSupported(ConditionalFeature.SCENE3D));

        Button b1 = new Button("button1");
        b1.setTranslateZ(0);
        b1.setDepthTest(DepthTest.ENABLE);

        Button b2 = new Button("button2");
        b2.setTranslateZ(300);
        b2.setDepthTest(DepthTest.ENABLE);

        Button b3 = new Button("button3");
        b3.setTranslateZ(600);
        b3.setDepthTest(DepthTest.ENABLE);

        Button b4 = new Button("button3");
        b4.setTranslateZ(50);
        b4.setDepthTest(DepthTest.DISABLE); // 禁用3d， 就不比深度了，按添加顺序放置





        //======================================================================

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(b1,b2,b3,b4);

        root.setDepthTest(DepthTest.ENABLE);

//        AnchorPane.setLeftAnchor(canvas, 100.0);
//        AnchorPane.setTopAnchor(canvas, 100.0);
        root.setStyle("-fx-background-color: #eeeeee00"); // 需要设置透明度


        // 启用3d渲染
        Scene scene = new Scene(root, 1000, 1000, true);

        // 启动透视相机
        scene.setCamera(new PerspectiveCamera());


        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();

        System.out.println(b1.getBoundsInParent());
        System.out.println(b2.getBoundsInParent());
        System.out.println(b3.getBoundsInParent());
    }
}
