package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class K_MeshView自定义3D图形_立方体 extends Application {

    public static void main(String[] args) {
        launch();
    }

    /**
     * int[] faces = new int[]{ <br>
     * <img src="docimg/img.png"/>
     *
     * <br/>
     *
     * <img src="docimg/1FE706D568E223A5347890BFFA21C627.jpg">
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {


        HBox hBox = new HBox(60);

        /*
            绘制了一个面， 如果绘制立体， 展开图绘制.  主要绘制z轴
         */

        float[] points = new float[]{
                // 每一行就是 x y z
                0, 0, 0,
                100, 0, 0,
                100, 100, 0,
                0, 100, 0,

                // 第二个面,左侧面，绘制z轴
                100,0,100,
                100,100,100,

                // 立方体顶部封顶
                0,0,100,

                // 底部
                0, 100, 100,
        };

        // 材质， 左上角0，0，   右上角就是1,0   左下角就是 0,1      右下角， 1,1
        float[] textCoords = new float[]{
                /*0, 0,   // 左上角
                1, 0,   // 右上角
                1, 1,   // 右下角
                0, 1    // 左下角*/
                // 正面的点
                0,0,
                0.5f,0,
                0.5f,0.5f,
                0,0.5f,
                // 侧面的点
                1,0,
                1,0.5f,

                // 立方体顶部封顶
                0, -0.5f,

                // 底部
                0,1
        };

        // 组成的，坐标和材质对应上, 三角形一个顺时针，一个逆时针
        int[] faces = new int[]{
                0, 0, // 取 points 第0行（0, 0, 0,）   textCoords 第0行(0, 0,)
                3, 3, // 取 points 第3行（0, 100, 0）   textCoords 第3行(0, 1)
                1, 1, // 取 points 第1行（100, 0, 0）   textCoords 第3行(1, 0)
                0, 0, 1, 1, 3, 3,

                // 描绘三角形，一个顺时针，一个逆时针
                1, 1, 3, 3, 2, 2,  // 逆时针
                1, 1, 2, 2, 3, 3, //  顺时针

                // 左侧面三角形
                1,1,5,5,4,4,
                1,1,4,4,5,5,

                1,1,2,2,5,5,
                1,1,5,5,2,2,

                // 顶部 两个三角形
                6,6,1,1,4,4,
                6,6,4,4,1,1,

                6,6,0,0,1,1,
                6,6,1,1,0,0,

                // 底部 两个三角形
                5,5,2,2,3,3,
                5,5,3,3,2,2,

                7,7,5,5,3,3,
                7,7,3,3,5,5,

                // 正面的后面 两个三角形
                6,6,5,5,7,7,
                6,6,7,7,5,5,

                6,6,4,4,5,5,
                6,6,5,5,4,4,

                // 最后一个右侧面 两个三角形
                6,6,3,3,0,0,
                6,6,0,0,3,3,

                6,6,7,7,3,3,
                6,6,3,3,7,7

        };

        TriangleMesh tm = new TriangleMesh();
        tm.getPoints().addAll(points);

        tm.getTexCoords().addAll(textCoords);
        tm.getFaces().addAll(faces);

        MeshView mv = new MeshView(tm);

        mv.setRotationAxis(new Point3D(1, 1, 0));
        mv.setRotate(-60);

        hBox.getChildren().addAll(mv);


        //======================================================================


        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);


        AnchorPane.setLeftAnchor(hBox, 100.0);
        AnchorPane.setTopAnchor(hBox, 100.0);
        root.setStyle("-fx-background-color: #eeeeee00"); // 需要设置透明度


        // true启用3d渲染       SceneAntialiasing.BALANCED启用抗锯齿优化以平衡质量和性能
        Scene scene = new Scene(root, 1000, 1000, true, SceneAntialiasing.BALANCED);


        scene.setCamera(new PerspectiveCamera());


        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
