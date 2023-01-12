package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritablePixelFormat;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.ByteBuffer;

public class 将小姐姐的照片转成字符 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL resource = 将小姐姐的照片转成字符.class.getResource("/images/alert.png");
        Image image = new Image(resource.toExternalForm());

        PixelReader pixelReader = image.getPixelReader();

        StringBuffer sb = new StringBuffer();


        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                Color color = pixelReader.getColor(j, i);// 按行拿数据
                int value = (int) (color.getRed() * 255);
                String data = getString(value);
                sb.append(data);
            }
            sb.append("\n");
        }

        write(sb);
    }

    public void write(StringBuffer sbb) {
        File file = new File("/Users/fengliulin/Documents/测试人转字符.txt");
        try (
                FileOutputStream fos = new FileOutputStream(file);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
        ) {
            osw.write(sbb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getString(int value) {
        if (value >= 0 && value < 10) {
            return "#";
        }
        if (value >= 10 && value < 20) {
            return "#";
        }
        if (value >= 20 && value < 30) {
            return "#";
        }
        if (value >= 30 && value < 40) {
            return "m";
        }
        if (value >= 40 && value < 50) {
            return "w";
        }
        if (value >= 50 && value < 60) {
            return "n";
        }
        if (value >= 60 && value < 70) {
            return "s";
        }
        if (value >= 80 && value < 90) {
            return "k";
        }
        if (value >= 100 && value < 110) {
            return "$";
        }

        if (value >= 120 && value < 130) {
            return "g";
        }
        if (value >= 130 && value < 140) {
            return "a";
        }
        if (value >= 140 && value < 150) {
            return "c";
        }
        if (value >= 160 && value < 170) {
            return "!";
        }
        if (value >= 180 && value < 190) {
            return "+";
        }
        if (value >= 200 && value < 210) {
            return ".";
        }
        if (value >= 220 && value < 230) {
            return ",";
        }
        if (value >= 240 && value < 250) {
            return " ";
        }
        if (value >= 250 && value < 255) {
            return " ";
        }


        return "";
    }
}
