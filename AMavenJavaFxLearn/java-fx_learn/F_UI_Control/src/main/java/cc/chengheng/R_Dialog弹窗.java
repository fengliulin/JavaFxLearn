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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.io.IOException;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class R_Dialog弹窗 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Button btn = new Button("按钮");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("df");
                Dialog<ButtonType> dialog = new Dialog<>();
                dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
                dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);

                Button ok = (Button)dialog.getDialogPane().lookupButton(ButtonType.OK);
                Button close = (Button)dialog.getDialogPane().lookupButton(ButtonType.CLOSE);

                dialog.setGraphic(new Button("其实可以设置一个图标"));
                dialog.setHeaderText("标题");
                dialog.setContentText("我是对话框内容");
                dialog.getDialogPane().setPrefSize(300, 300);

//                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.setResultConverter(new Callback<ButtonType, ButtonType>() {
                    @Override
                    public ButtonType call(ButtonType param) {
                        System.out.println(param);
                        return param;
                    }
                });

                Optional<ButtonType> opt = dialog.showAndWait();
                opt.ifPresent(new Consumer<ButtonType>() {
                    @Override
                    public void accept(ButtonType buttonType) {

                    }
                });



                dialog.setOnCloseRequest(event1 -> {
                    System.out.println(event1.getEventType());
                });







                dialog.show();


                ok.setOnAction(event1 -> {
                    System.out.println("ok");
                });

                close.setOnAction(event1 -> {
                    System.out.println("close");
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
