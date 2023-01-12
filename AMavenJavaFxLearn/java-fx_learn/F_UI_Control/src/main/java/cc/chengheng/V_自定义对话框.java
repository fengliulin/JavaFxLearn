package cc.chengheng;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Start Date: 2021/11/4
 * Author: 冯镠霖(fengliulin)
 */
public class V_自定义对话框 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Button btn = new Button("按钮");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AnchorPane an = new AnchorPane();
                Stage stage = new Stage();
                stage.initOwner(primaryStage);  // 设置所属哪个舞台
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initStyle(StageStyle.UTILITY);

                Scene scene = new Scene(an);
                stage.setScene(scene);

                stage.setTitle("自定义弹窗");
                stage.setWidth(300);
                stage.setHeight(300);

                stage.show();

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
