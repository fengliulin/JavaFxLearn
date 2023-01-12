package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 平铺布局, 设置一个，其它全部变
 */
public class I_TileFlow平铺布局 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Button btn1 = new Button("button1");
        btn1.setPrefHeight(100);
        Button btn2 = new Button("button2");
        Button btn3 = new Button("button3");
        Button btn4 = new Button("button4");
        Button btn5 = new Button("button5");
        Button btn6 = new Button("button6");
        Button btn7 = new Button("button7");
        Button btn8 = new Button("button8");

        TilePane tilePane = new TilePane();
        tilePane.setStyle("-fx-background-color: #ee6aa7");

        TilePane.setMargin(btn1, new Insets(50));

        tilePane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8);


        Scene scene = new Scene(tilePane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}