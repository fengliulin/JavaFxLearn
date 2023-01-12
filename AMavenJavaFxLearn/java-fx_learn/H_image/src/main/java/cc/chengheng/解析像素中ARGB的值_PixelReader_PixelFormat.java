package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.nio.ByteBuffer;

public class 解析像素中ARGB的值_PixelReader_PixelFormat extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL resource = 解析像素中ARGB的值_PixelReader_PixelFormat.class.getResource("/images/alert.png");
        Image image = new Image(resource.toExternalForm());

        // 这个就是得到获取图像的像素信息的
        PixelReader pixelReader = image.getPixelReader();

        // 透明度
        int argb = pixelReader.getArgb(0, 45);

        // 拿到上面 x和 y 像素的红绿蓝和透明度
        int alpha = (argb >> 24) & 0xFF;
        int red = (argb >> 16) & 0xFF;
        int green = (argb >> 8) & 0xFF;
        int blue = argb & 0xFF;

        System.out.println(pixelReader.getPixelFormat().getType());

        WritablePixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteBgraPreInstance();
        byte[] array = new byte[3 * 3 * 4];

        pixelReader.getPixels(0, 0, 3, 3, pixelFormat, array, 0, 3 * 4);

        for (int i = 0; i < array.length; i=i+4) {
            int blue1  = (array[i+0] & 0xff);
            int green1 = (array[i+1] & 0xff);
            int red1   = (array[i+2] & 0xff);
            int alpha1 = (array[i+3] & 0xff);
        }

        AnchorPane an = new AnchorPane();
//        an.getChildren().add(image);


        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
