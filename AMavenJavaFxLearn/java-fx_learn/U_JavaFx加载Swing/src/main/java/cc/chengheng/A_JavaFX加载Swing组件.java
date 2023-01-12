package cc.chengheng;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.DepthTest;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class A_JavaFX加载Swing组件 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        HBox hBox = new HBox(30);



        SwingNode sn = new SwingNode();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JPanel jPanel = new JPanel();
                JButton btn1 = new JButton("swing btn1");
                JButton btn2 = new JButton("swing btn2");
                FlowLayout f1 = new FlowLayout(FlowLayout.CENTER, 100, 100);
                jPanel.setLayout(f1);
                jPanel.add(btn1);
                jPanel.add(btn2);

                sn.setContent(jPanel);
            }
        });


        //======================================================================

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(sn);


        AnchorPane.setLeftAnchor(hBox, 100.0);
        AnchorPane.setTopAnchor(hBox, 100.0);
        root.setStyle("-fx-background-color: #eeeeee00"); // 需要设置透明度

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(1000);
        primaryStage.setWidth(1000);
        primaryStage.show();


    }
}
