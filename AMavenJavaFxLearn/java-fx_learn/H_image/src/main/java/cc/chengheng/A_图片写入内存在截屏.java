package cc.chengheng;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.charset.StandardCharsets;

public class A_图片写入内存在截屏 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        WritableImage wi = new WritableImage(100, 100);
        PixelWriter pw = wi.getPixelWriter();

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                pw.setColor(i, j, Color.valueOf("#FFD700"));
            }
        }

        for (int i = 0; i < 100; i++) {
            pw.setColor(i, i, Color.valueOf("#FF0000"));
        }

        ImageView iw = new ImageView(wi);

        URL resource1 = A_图片写入内存在截屏.class.getResource("/images/alert.png");
        URL resource2 = A_图片写入内存在截屏.class.getResource("/images/back.png");
        Image image1 = new Image(URLDecoder.decode(resource1.toExternalForm(), StandardCharsets.UTF_8));
        Image image2 = new Image(URLDecoder.decode(resource2.toExternalForm(), StandardCharsets.UTF_8));
        WritableImage wi2 = new WritableImage(image2.getPixelReader(), 200, 200);
        PixelWriter pw2 = wi2.getPixelWriter();
        PixelReader pr = image1.getPixelReader();

        WritablePixelFormat<IntBuffer> pixelFormat = PixelFormat.getIntArgbInstance();
        int[] in = new int[200 * 200];
        pr.getPixels(0, 0, 100, 100, pixelFormat, in, 0, 100);

        pw2.setPixels(0,0, 100, 100, pixelFormat, in, 0, 100);




//        for (int i = 0; i < 100; i++) {
//            for (int j = 0; j < 100; j++) {
//                pw2.setColor(i, j, Color.valueOf("#FFD700"));
//            }
//        }

        System.out.println("========================================");


        VBox vBox = new VBox();
        WritableImage wbi = vBox.snapshot(null, null);

        ImageView iw2 = new ImageView(wi2);
        AnchorPane an = new AnchorPane();
        an.getChildren().add(iw2);


        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();


        // 让javafx的转到swing来
        BufferedImage bi = SwingFXUtils.fromFXImage(wi2, null);
        ImageIO.write(bi, "png", new File("/Users/fengliulin/Documents/测试是.png"));
    }
}
