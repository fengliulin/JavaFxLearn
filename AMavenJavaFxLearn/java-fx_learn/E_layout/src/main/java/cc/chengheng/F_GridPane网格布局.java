package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 流式布局，会自动换行
 */
public class F_GridPane网格布局 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {


        Button btn1 = new Button("button1");
        Button btn2 = new Button("button2");
        Button btn3 = new Button("button3");
        Button btn4 = new Button("button4");
        Button btn5 = new Button("button5");
        Button btn6 = new Button("button6");
        Button btn7 = new Button("button7");
        Button btn8 = new Button("button8");

        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-background-color: #ee6aa7");

        gridPane.add(btn1, 0,0);
        gridPane.add(btn2, 1,0);
        gridPane.add(btn3, 2,0);
        gridPane.add(btn4, 3,0);
        gridPane.add(btn5, 0,1);
        gridPane.add(btn6, 1,1);
        gridPane.add(btn7, 2,1);
        gridPane.add(btn8, 3,1);



        Scene scene = new Scene(gridPane);
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