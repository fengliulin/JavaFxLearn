package cc.chengheng.A_ListView.五种数据类型;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.util.function.Consumer;

public class C_ListView_javaBean extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Data d1 = new Data("A1", 18);
        Data d2 = new Data("A2", 19);
        Data d3 = new Data("A3", 20);
        Data d4 = new Data("A4", 21);


        ObservableList<Data> list = FXCollections.observableArrayList();
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);

        ListView<Data> listView = new ListView<>(list);
        listView.setPlaceholder(new Label("没有数据")); // 设置占位符
        listView.setPrefWidth(300);
        listView.setPrefHeight(150);

        listView.setCellFactory(TextFieldListCell.forListView(new StringConverter<Data>() {
            @Override
            public String toString(Data object) {
                return object.name + "-" + object.age;
            }

            @Override
            public Data fromString(String string) {
                return null;
            }
        }));


        // 插入还是删除，只有有操作就会有监听 InvalidationListener
        list.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                ObservableList<Data> data = (ObservableList) observable;
                data.forEach(new Consumer<Data>() {
                    @Override
                    public void accept(Data d) {
                        System.out.println(d.name + "-" + d.age);
                    }
                });
            }
        });




        list.addListener(new ListChangeListener<Data>() {
            @Override
            public void onChanged(Change<? extends Data> c) {
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

//        list.set(0, new Data("dsfsd",5));
            d1.age = 100;
            listView.refresh();
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

    static class Data {
        private String name;
        private int age;

        public Data(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
