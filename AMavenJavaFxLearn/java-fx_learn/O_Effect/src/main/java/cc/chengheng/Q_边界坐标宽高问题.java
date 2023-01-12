package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Q_边界坐标宽高问题 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Rectangle rectangle = new Rectangle(100, 100);
        rectangle.setFill(Color.BLUE);

        DropShadow ds = new DropShadow();
        ds.setRadius(20);

        GaussianBlur gb = new GaussianBlur();
        gb.setRadius(3);

        ds.setInput(gb); // 阴影放一个高斯模糊

        rectangle.setEffect(ds);


        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(rectangle);

        AnchorPane.setTopAnchor(rectangle, 100.0);
        AnchorPane.setLeftAnchor(rectangle, 100.0);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();


        /*
        BoundingBox [
        minX:100.0, minY:100.0,minZ:0.0,  左上角的点
        width:100.0,height:100.0,         组件自己的宽度和高度
        depth:0.0,
        maxX:200.0, maxY:200.0,maxZ:0.0   右下角的点
        ]
         */

        // 宽高不会因为添加效果而改变
        System.out.println(rectangle.getWidth() + "-" +rectangle.getHeight());

        System.out.println(rectangle.getLayoutBounds());  // 相对于自己

        /*
        BoundingBox [
        minX:-23.0, minY:-23.0, minZ:0.0,  阴影左上角延伸出去
        width:146.0, height:146.0,
        depth:0.0,
        maxX:123.0,maxY:123.0, maxZ:0.0    包含阴影的右下角
        ]
         */
        System.out.println(rectangle.getBoundsInLocal());



        /*
        包含阴影
        BoundingBox [
        minX:77.0, minY:77.0, minZ:0.0,
        width:146.0, height:146.0,
        depth:0.0,
        maxX:223.0, maxY:223.0, maxZ:0.0]
         */
        System.out.println(rectangle.getBoundsInParent()); //相对于父节点

    }
}
