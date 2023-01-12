package cc.chengheng;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class C_dblclick extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Button button1 = new Button("b1");

        button1.setLayoutX(0);
        button1.setLayoutY(0);

      /*  button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("鼠标左键单击");
            }
        });*/


        button1.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton().name().equals(MouseButton.PRIMARY.name()) && event.getClickCount() == 2) { // 鼠标双击
                    System.out.println("鼠标双击");
                }
            }
        });


        Group group = new Group();
        group.getChildren().addAll(button1);


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