package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class K_SVGPath路径 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox();

        /*
        下面的命令可用于路径数据：
            M = moveto
            L = lineto
            H = horizontal lineto                   水平线
            V = vertical lineto                     垂直线
            C = curveto                             曲线
            S = smooth curveto                      平滑曲线
            Q = quadratic Belzier curve             二次贝塞尔曲线
            T = smooth quadratic Belzier curveto    光滑的二次贝塞尔曲线
            A = elliptical Arc                      椭圆弧
            Z = closepath                           关闭路径
            注释：以上所有命令均允许小写字母。大写表示绝对定位，小写表示相对定位。
         */

        SVGPath path = new SVGPath();
        path.setContent("m0,0 l100,100");

        path.setStroke(Color.RED); // 需要添加边框颜色，才显示

        hBox.getChildren().addAll(path);


        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(hBox);

        AnchorPane.setLeftAnchor(hBox, 100.0);
        AnchorPane.setTopAnchor(hBox, 100.0);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
