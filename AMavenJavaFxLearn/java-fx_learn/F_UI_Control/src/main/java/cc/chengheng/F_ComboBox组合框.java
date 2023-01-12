package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class F_ComboBox组合框 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {


        AnchorPane ap = new AnchorPane();

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("1","2");

        comboBox.setEditable(true); // 可编辑的组合框

        comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                       /* if (item != null) {
                            setText(item);
                            if (item.contains("1")) {
                                System.out.println(this);
                                setTextFill(Color.RED);
                            }
                            else if (item.contains("2")){
                                setTextFill(Color.GREEN);
                            }
                        }
                        else {
                            setText(null);
                        }*/

                        setGraphic(new Button("1"));
                    }
                };
            }
        });

        ap.getChildren().addAll(comboBox);

        //=======================================================
        Scene scene = new Scene(ap);
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
