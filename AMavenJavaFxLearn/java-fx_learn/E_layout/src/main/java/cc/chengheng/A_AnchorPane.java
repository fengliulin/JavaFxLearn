package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 锚点： 绝对布局
 */
public class A_AnchorPane extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Button btn1 = new Button("Button1");

//        btn1.setManaged(false); // 脱离父节点管理，并且在当前位置消失
        btn1.setVisible(false); // 设置
        btn1.setOpacity(0.1);

        btn1.setLayoutX(100); // 相对于父节点左上角坐标
        Button btn2 = new Button("Button2");
        btn2.setLayoutX(150);

        Button btn3 = new Button("Button3");
        Button btn4 = new Button("Button4");

        AnchorPane root = new AnchorPane();
        AnchorPane root2 = new AnchorPane();
        root2.setStyle("-fx-background-color: #9BCD9B");

        // 给AnchorPane设置4个位置
        /*AnchorPane.setTopAnchor(root2, 10.0);
        AnchorPane.setLeftAnchor(root2, 10.0);
        AnchorPane.setRightAnchor(root2, 10.0);
        AnchorPane.setBottomAnchor(root2, 10.0);*/

        // 这样也可以设置
        root2.setPrefWidth(200);
        root2.setPrefHeight(200);

        root.getChildren().add(root2);

        // 用AnchorPane设置按钮的位置，那么setLayoutX 就无效了
       /* AnchorPane.setTopAnchor(btn1, 10.0);
        AnchorPane.setLeftAnchor(btn1, 10.0);*/

        root.setPadding(new Insets(10));

        root.setStyle("-fx-background-color: #FF3E96");
//        root.getChildren().addAll(btn1, btn2);

        root.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("sdfdsf");
            }
        });





        //Group 是一个容器，但不是一个布局, 将内容捆绑在一起
        Group g1 = new Group();
        Group g2 = new Group();

        AnchorPane.setTopAnchor(g1, 100d);
        AnchorPane.setLeftAnchor(g1, 100d);

        g1.getChildren().addAll(btn1, btn2);
        g2.getChildren().addAll(btn3, btn4);


        root.getChildren().addAll(g1, g2);


        // AnchorPane 容器的宽度和高度是场景的宽度高度
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        // 有些宽高需要写在show之后

        root2.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            }
        });

        root2.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

            }
        });
    }

    public static void main(String[] args) {
        launch();
    }
}