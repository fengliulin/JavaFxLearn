package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 流式布局，会自动换行
 */
public class G_StackPane extends Application {
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

        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: #ee6aa7");


        stackPane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8);


        Scene scene = new Scene(stackPane);
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