package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.stage.Stage;

public class K_MeshView自定义3D图形_棱锥 extends Application {

    public static void main(String[] args) {
        launch();
    }

    /**
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {


        HBox hBox = new HBox(60);


        float[] points = new float[]{
                100, 0, 50,
                0, 100, 0,
                200, 100, 0,

                0, 100, 100,
                200, 100, 100,
        };

        // 材质， 左上角0，0，   右上角就是1,0   左下角就是 0,1      右下角， 1,1
        float[] textCoords = new float[]{
                0.5f, 0,
                0, 1f,
                1, 1,

                0, -1,
                1, -1
        };

        // 组成的，坐标和材质对应上, 三角形一个顺时针，一个逆时针
        int[] faces = new int[]{

                // 正面的三角形
                0, 0, 1, 1, 2, 2,
                0, 0, 2, 2, 1, 1,

                // 正面的对立面的三角形
                0,0,4,4,3,3,
                0,0,3,3,4,4,

                // 底部两个三角形
                3,3,2,2,4,4,
                3,3,4,4,2,2,

                3,3,1,1,2,2,
                3,3,2,2,1,1,

                // 右侧面
                0,0,2,2,4,4,
                0,0,4,4,2,2,

                // 左侧面
                0,0,3,3,1,1,
                0,0,1,1,3,3,
        };

        TriangleMesh tm = new TriangleMesh();
        tm.getPoints().addAll(points);

        tm.getTexCoords().addAll(textCoords);
        tm.getFaces().addAll(faces);

        MeshView mv = new MeshView(tm);

        mv.setRotationAxis(new Point3D(0, 1, 0));
        mv.setRotate(60);

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
