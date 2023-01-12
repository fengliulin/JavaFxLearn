package cc.chengheng.A_ListView;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
默认超出，就会出现滚动条
 */
public class F_ListView搜索列表和排序列表 extends Application {

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
        listView.setPrefHeight(250);


        HBox hBox = new HBox();
        TextField textField = new TextField();

        Button bu = new Button("button");
        hBox.getChildren().addAll(textField, bu);



        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // 过滤
                FilteredList<String> fl = list.filtered(new Predicate<String>() {
                    @Override
                    public boolean test(String s) {
                        if (s.contains(newValue)) {
                            return true;
                        }
                        return false;
                    }
                });

                listView.setItems(fl);
            }
        });


        bu.setOnAction(event -> {
            // 排序
            list.sorted(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {

                    return 0;
                }
            });
        });

        //================================================================
        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(listView, hBox);

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
