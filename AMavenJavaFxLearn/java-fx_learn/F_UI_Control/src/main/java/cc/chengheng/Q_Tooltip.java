package cc.chengheng;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Start Date: 2021/11/4
 * Author: 冯镠霖(fengliulin)
 */
public class Q_Tooltip extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Button btn = new Button("按钮");

        Tooltip tooltip = new Tooltip("这是小提示");

        tooltip.setFont(new Font(20));
        tooltip.setPrefWidth(200);
        tooltip.setPrefHeight(200);
        tooltip.setWrapText(true); // 设置文本换行
//        tooltip.setTextOverrun();
//        tooltip.setTextAlignment();

        btn.setTooltip(tooltip);

        btn.setOnAction(event -> {

        });

        AnchorPane anchorPane = new AnchorPane();
        //=======================================================
        anchorPane.getChildren().addAll(btn);
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

    }


}
