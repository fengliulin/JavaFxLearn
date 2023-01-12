package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 文本流式布局
 */
public class H_TextFlow extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Text text1 = new Text("文本1");
        Text text2 = new Text("文本2");
        Text text3 = new Text("文本3");

        TextFlow textFlow = new TextFlow();
        textFlow.setStyle("-fx-background-color: #ee6aa7");


        textFlow.getChildren().addAll(text1, text2, text3);


        Scene scene = new Scene(textFlow);
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