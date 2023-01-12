package cc.chengheng.A_ListView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/*
默认超出，就会出现滚动条
 */
public class C_ListView双击单元格编辑 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



//        ObservableList<String> list = FXCollections.observableArrayList();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");
//        list.add("f");
//        list.add("g");
//        list.add("h");
//        list.add("i");
//
//        ListView<String> listView = new ListView<>(list);
//        listView.setPlaceholder(new Label("没有数据")); // 设置占位符
//        listView.setPrefWidth(300);
//        listView.setPrefHeight(150);
//        listView.setFixedCellSize(50); // 设置单元格大小
//        listView.getItems().add("df");
//
//        listView.setEditable(true);
//        Callback<ListView<String>, ListCell<String>> call =
//                TextFieldListCell.forListView(new StringConverter<String>() {
//
//                    /**
//                     * 初始化的时候调用, 编辑的时候也调用
//                     */
//                    @Override
//                    public String toString(String object) {
//                        return object + "world";
//                    }
//
//                    // 带输入框的时候调用
//                    @Override
//                    public String fromString(String string) {
//                        return string + "-hello";
//                    }
//                });
//
//        listView.setCellFactory(call);



        Data d1 = new Data("A");
        Data d2 = new Data("B");
        Data d3 = new Data("B");

        ObservableList<Data> list = FXCollections.observableArrayList();
        list.add(d1);
        list.add(d2);
        list.add(d3);

        ListView<Data> listView = new ListView<>(list);


        // 加载对象的数据
        Callback<ListView<Data>, ListCell<Data>> call = TextFieldListCell.forListView(new StringConverter<Data>() {
            @Override
            public String toString(Data object) {
                return object.getName();
            }

            @Override
            public Data fromString(String string) {
                return new Data(string + " -new");
            }
        });


        listView.setEditable(true);
        listView.setCellFactory(call);

        listView.setPrefWidth(300);
        listView.setPrefHeight(150);


        listView.setOnEditStart(event -> {
            System.out.println("开始" + event.getSource());
        });

        listView.setOnEditCommit(event -> {
            System.out.println("开始提交");
            list.set(event.getIndex(), event.getNewValue());
        });

        listView.setOnEditCancel(event -> {
            System.out.println("取消");
        });


        Button bu = new Button("button");



        bu.setOnAction(event -> {
                listView.edit(2);
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Data(String name) {
            this.name = name;
        }
    }
}
