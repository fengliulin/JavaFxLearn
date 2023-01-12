package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class B_PasswordField extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        // 密码框
        PasswordField passwordField = new PasswordField();






        Group group = new Group();
        group.getChildren().addAll(passwordField);


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