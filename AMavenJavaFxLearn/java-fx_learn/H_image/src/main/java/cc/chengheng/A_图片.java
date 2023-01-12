package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.plaf.IconUIResource;
import java.net.URL;
import java.nio.ByteBuffer;

public class A_图片 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL resource = A_图片.class.getResource("/images/00003.BMP");
        Image image = new Image(resource.toExternalForm());




        WritableImage writableImage = new WritableImage(image.getPixelReader(), (int) image.getWidth(), (int) image.getHeight());
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        Color color1 = image.getPixelReader().getColor(0, 0);
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight() ; j++) {
                if (image.getPixelReader().getColor(i, j).toString().equals("0x000000ff")) {
                    pixelWriter.setColor(i,j, Color.valueOf("0xee6aa700"));
                }
            }
        }

        ImageView imageView = new ImageView(writableImage);






        // 这个就是得到获取图像的像素信息的
        PixelReader pixelReader = image.getPixelReader();

        Color color = pixelReader.getColor(0, 0);

//        pixelReader.
//        System.out.println();

        // 透明度
        int argb = pixelReader.getArgb(0, 45);

        // 拿到上面 x和 y 像素的红绿蓝和透明度
        int alpha = (argb >> 24) & 0xFF;
        int red = (argb >> 16) & 0xFF;
        int green = (argb >> 8) & 0xFF;
        int blue = argb & 0xFF;

        System.out.println(pixelReader.getPixelFormat().getType());

        WritablePixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteBgraPreInstance();

//        pixelFormat.setArgb();

        byte[] array = new byte[3 * 3 * 4];
        for (int i = 0; i < array.length; i=i+4) {
            int blue1  = (array[i+0] & 0xff);
            int green1 = (array[i+1] & 0xff);
            int red1   = (array[i+2] & 0xff);
            int alpha1 = (array[i+3] & 0xff);
        }

        pixelReader.getPixels(0, 0, 3, 3, pixelFormat, array, 0, 3 * 4);



        AnchorPane an = new AnchorPane();
        an.getChildren().add(imageView);


        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
