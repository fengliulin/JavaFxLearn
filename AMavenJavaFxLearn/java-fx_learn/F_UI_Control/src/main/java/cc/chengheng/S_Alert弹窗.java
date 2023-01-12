package cc.chengheng;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class S_Alert弹窗 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Button btn = new Button("按钮");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                // 添加一个关闭按钮， 默认只有确认和取消
                alert.getDialogPane().getButtonTypes().addAll(ButtonType.CLOSE);


                Button bu = (Button) alert.getDialogPane().lookupButton(ButtonType.OK);
                Button cancel = (Button) alert.getDialogPane().lookupButton(ButtonType.CANCEL);

//                alert.getDialogPane().getButtonTypes().remove();

//                alert.show();

                alert.showAndWait();

                bu.setOnAction(event1 -> {
                    System.out.println("ok");
                });

                cancel.setOnAction(event1 -> {
                    System.out.println("cancel");
                });

            }
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
