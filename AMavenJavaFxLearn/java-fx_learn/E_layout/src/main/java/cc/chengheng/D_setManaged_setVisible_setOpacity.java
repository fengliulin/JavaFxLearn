package cc.chengheng;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class D_setManaged_setVisible_setOpacity extends Application {

    static boolean isManaged = false;
    static boolean isVisible = false;
    static double opacityValue = 0;

    @Override
    public void start(Stage primaryStage) throws IOException {

        Button btn1 = new Button("Button1");
        Button btn2 = new Button("Button2");
        Button btn3 = new Button("Button3");
        Button btn4 = new Button("Button4");

        Button btn5 = new Button("b3.setManaged(fasle)");
        Button btn6 = new Button("b3.setVisible");
        Button btn7 = new Button("b3.setOpacity(0)");

        AnchorPane ap = new AnchorPane();
        ap.setStyle("-fx-background-color: #9BCD9B");


        HBox hBox = new HBox();
        hBox.setPadding(new Insets(20));
        hBox.setSpacing(10);
        hBox.setSpacing(10);

        hBox.getChildren().addAll(btn1, btn2, btn3, btn4);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(btn5, btn6, btn7);

        AnchorPane.setTopAnchor(vBox, 100.0);
        AnchorPane.setLeftAnchor(vBox, 20.0);

        ap.getChildren().addAll(hBox, vBox);
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();


        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn3.setManaged(isManaged);
                if (isManaged) {
                    isManaged = false;
                    btn5.setText("btn3.setManaged(" + isManaged + ");");
                } else {
                    isManaged = true;
                    btn5.setText("btn3.setManaged(" + isManaged + ");");
                }
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });

        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn3.setManaged(isManaged);
                new Print(hBox);
                if (isManaged) {
                    isManaged = false;
                    btn5.setText("btn3.setManaged(" + isManaged + ");");
                } else {
                    isManaged = true;
                    btn5.setText("btn3.setManaged(" + isManaged + ");");
                }
            }
        });

        btn6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn3.setVisible(isVisible);
                new Print(hBox);
                if (isVisible) {
                    isVisible = false;
                    btn6.setText("btn3.setVisible(" + isVisible + ");");
                } else {
                    isVisible = true;
                    btn6.setText("btn3.setVisible(" + isVisible + ");");
                }
            }
        });

        btn7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                btn3.setOpacity(opacityValue);
                new Print(hBox);
                if (opacityValue == 0) {
                    opacityValue = 1;
                    btn7.setText("btn3.setOpacity(" + opacityValue + ");");
                } else {
                    opacityValue = 0;
                    btn7.setText("btn3.setOpacity(" + opacityValue + ");");
                }
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}

class Print {
    public Print(HBox hBox) {
        System.out.println("当前HBox子组件=" + hBox.getChildren().size());
    }
}
