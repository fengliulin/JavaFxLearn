package cc.chengheng.A_ListView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
默认超出，就会出现滚动条
 */
public class B_ListView焦点 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("data-a");
        list.add("data-b");
        list.add("data-c");
        list.add("data-d");
        list.add("data-e");
        list.add("data-f");
        list.add("data-g");
        list.add("data-h");
        list.add("data-i");

        ListView<String> listView = new ListView<>(list);
        listView.setPlaceholder(new Label("没有数据")); // 设置占位符
        listView.setPrefWidth(300);
        listView.setPrefHeight(150);


        listView.setFixedCellSize(50); // 设置单元格大小


        listView.getFocusModel().focusedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });



        listView.getItems().add("df");


        Button bu = new Button("button");



        // 设置双击可以修改, 要一起使用
        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());

        bu.setOnAction(event -> {
                listView.getFocusModel().focus(2);
                listView.requestFocus();
        });

        //================================================================
        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(listView, bu);

        AnchorPane.setLeftAnchor(listView, 200.0);
        AnchorPane.setTopAnchor(listView, 100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);


        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();



    }
}
