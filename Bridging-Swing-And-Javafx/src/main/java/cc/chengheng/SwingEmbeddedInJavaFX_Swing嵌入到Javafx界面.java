/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/12
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

public class SwingEmbeddedInJavaFX_Swing嵌入到Javafx界面 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        var borderPane = new BorderPane();

        var swingNode = new SwingNode();
        var scene = new Scene(borderPane, 200, 200);
        borderPane.setCenter(swingNode);
        borderPane.setBottom(new Label("JavaFX Bottom"));


        SwingUtilities.invokeLater(() -> {
            var panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.add(new JLabel("Swing North"), BorderLayout.CENTER);

            swingNode.setContent(panel);
            borderPane.layout();
        });



        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

