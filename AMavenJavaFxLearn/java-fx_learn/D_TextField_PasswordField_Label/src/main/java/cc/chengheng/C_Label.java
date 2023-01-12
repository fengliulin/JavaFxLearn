package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class C_Label extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Label label = new Label("我是标签");

        label.setTextFill(Color.RED);





        Group group = new Group();
        group.getChildren().addAll(label);


        Scene scene = new Scene(group);
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