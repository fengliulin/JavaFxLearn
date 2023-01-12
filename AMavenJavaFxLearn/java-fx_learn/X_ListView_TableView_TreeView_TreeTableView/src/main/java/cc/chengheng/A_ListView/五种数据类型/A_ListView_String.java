package cc.chengheng.A_ListView.五种数据类型;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.function.Consumer;

public class A_ListView_String extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");


        /*ObservableList<SimpleStringProperty> list = FXCollections.observableArrayList();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);*/

        ListView<String> listView = new ListView<>(list);
        listView.setPlaceholder(new Label("没有数据")); // 设置占位符
        listView.setPrefWidth(300);
        listView.setPrefHeight(150);

        listView.setCellFactory(TextFieldListCell.forListView(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object;
            }

            @Override
            public String fromString(String string) {
                return null;
            }
        }));


        // 插入还是删除，只有有操作就会有监听 InvalidationListener
        list.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                ObservableList<SimpleStringProperty> data = (ObservableList) observable;
                data.forEach(new Consumer<SimpleStringProperty>() {
                    @Override
                    public void accept(SimpleStringProperty simpleStringProperty) {
                        System.out.println(simpleStringProperty.get());
                    }
                });
            }
        });




        list.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        System.out.println("添加动作");
                    }
                    if (c.wasRemoved()) {
                        System.out.println("删除动作");
                    }
                    if (c.wasReplaced()) {
                        System.out.println("替换动作");
                    }
                    if (c.wasPermutated()) {
                        System.out.println("排序动作");
                    }
                    if (c.wasUpdated()) {
                        System.out.println("更新动作");
                    }
                }
            }
        });

        Button bu = new Button("button");

        bu.setOnAction(event -> {


//            listView.refresh(); // 如果不通过可观察修改， 就调用刷新

//            list.add(new SimpleStringProperty("dff"));

          /*  // 排序
            list.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1);
                }
            });*/
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
