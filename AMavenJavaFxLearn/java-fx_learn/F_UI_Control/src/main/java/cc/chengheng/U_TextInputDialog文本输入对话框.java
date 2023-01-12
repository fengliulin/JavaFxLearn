package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class U_TextInputDialog文本输入对话框 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Button btn = new Button("按钮");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextInputDialog tid = new TextInputDialog("请选择");
                Button ok = (Button) tid.getDialogPane().lookupButton(ButtonType.OK);

                tid.show();
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
