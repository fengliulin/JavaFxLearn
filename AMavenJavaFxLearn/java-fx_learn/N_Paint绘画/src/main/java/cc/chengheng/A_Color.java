package cc.chengheng;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class A_Color extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        GridPane gird = new GridPane();
        gird.setHgap(10);
        gird.setVgap(10);

        // 创建一个 5行5列的格子，每个格子填充一个矩形
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Rectangle rectangle = new Rectangle(150, 150);
                rectangle.setFill(Paint.valueOf("#ededed"));
                gird.add(rectangle, j, i);
            }
        }

        // #ee6aa7 00-FF     后两位透明度
        ArrayList<Color> list = new ArrayList<>();
        list.add(Color.valueOf("#ee6aa7"));
        list.add(Color.valueOf("#ee6aa755"));
        list.add(Color.valueOf("0xee6aa755"));
        list.add(Color.CADETBLUE);

        // 0 到1之间计算
        list.add(new Color(140.0 / 255, 39. / 255, 218.0 / 255, 1));
        list.add(new Color(140.0 / 255, 39. / 255, 218.0 / 255, 0.5));
        list.add(new Color(140.0 / 255, 39. / 255, 218.0 / 255, 0));

        list.add(Color.rgb(30, 175, 217, 1));

        list.add(Color.hsb(180, 1, 1, 1));

        Color rgb = Color.rgb(32, 212, 143, 1);
        list.add(rgb.deriveColor(-100, 1, 1, 1));

        list.add(Color.web("rgb(255,102,136)", 0.6));

        list.add(Color.gray(0.5, 1));
        list.add(Color.grayRgb(128, 1));

        list.add(Color.rgb(54,105,198,1).brighter());
        list.add(Color.rgb(54,105,198,1).darker());
        list.add(Color.rgb(54,105,198,1).grayscale());
        list.add(Color.rgb(54,105,198,1).invert());


        Color color = Color.rgb(54, 105, 198, 1);
        System.out.println(color.getRed() * 255);
        System.out.println(color.getGreen() * 255);
        System.out.println(color.getBlue() * 255);
        System.out.println(color.getOpacity());

        System.out.println(color.getHue());
        System.out.println(color.getSaturation()); // 色相
        System.out.println(color.getBrightness()); // 明度

        // 获取格子的每个节点填充颜色
        for (int i = 0; i < list.size(); i++) {
            Rectangle rectangle = (Rectangle) gird.getChildren().get(i);
            rectangle.setFill(list.get(i));
        }


        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(gird);

        AnchorPane.setLeftAnchor(gird, 10.0);
        AnchorPane.setTopAnchor(gird, 10.0);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();
    }
}
