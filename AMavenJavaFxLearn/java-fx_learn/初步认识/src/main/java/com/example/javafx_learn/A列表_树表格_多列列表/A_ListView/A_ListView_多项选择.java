package com.example.javafx_learn.A列表_树表格_多列列表.A_ListView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.util.Iterator;

/**
 * 理解ObservableList：    Observable(被观察者)
 * ListView是它的观察者，当list内容发生变化的时
 * 候，ListView会被通知并自动刷新
 */
public class A_ListView_多项选择 extends Application {

    // 创建ListView，指定数据项类型
    StudentListView listView = new StudentListView();

    HBox hBox = new HBox();
    Button btnTest = new Button("测试");

    private ObservableList<Student> listData = listView.data();
    ;

    @Override
    public void start(Stage stage) throws IOException {

        hBox.getChildren().addAll(btnTest);
        hBox.setPadding(new Insets(10, 20, 30, 40));


        //准备数据
        listData.add(new Student(0, "张三", true));
        listData.add(new Student(2, "张三2", false));
        listData.add(new Student(3, "张三3", true));


        BorderPane root = new BorderPane();
        root.setCenter(listView);

        root.setTop(hBox);


        // 给按钮添加事件
        btnTest.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Iterator<Student> iterator = listData.iterator();
                while (iterator.hasNext()) {
                    Student student = iterator.next();
                    System.out.println(student.getName());
                    if (student.isSex()) {
                        iterator.remove();
                    }
                }


                listView.refresh();
            }
        });


        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}

class StudentListView extends ListView<Student> {

    // 被观察者列表
    ObservableList<Student> listData = FXCollections.observableArrayList();

    public StudentListView() {
        setItems(listData);

        // 设置单元格生成器 (工厂)
        setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {
            @Override
            public ListCell<Student> call(ListView<Student> param) {
                return new MyListCell();
            }
        });
    }

    public ObservableList<Student> data() {
        return listData;
    }

    /**
     * ListCell 负责列表项里每一行的 cell 的显示
     */
    static class MyListCell extends ListCell<Student> {
        @Override
        protected void updateItem(Student item, boolean empty) {
            // fx框架要求必须先调用 super.updateItem
            super.updateItem(item, empty);

            if (item == null) {
                setGraphic(null);
            } else {
                // 所有的node都可以添加到这个 list单元格 里面
                // 显示一个CheckBox
                CheckBox checkBox = new CheckBox();
                checkBox.setText(item.getName());
                checkBox.setSelected(item.isSex());
                setGraphic(checkBox); // 该Cell拥有这个CheckBox

                // 当CheckBox被点中/取消时的处理
                checkBox.selectedProperty().addListener(new MyCheckBoxListener(item));
            }
        }

        // 时间监听
        private static class MyCheckBoxListener implements ChangeListener<Boolean> {

            Student item;

            public MyCheckBoxListener(Student item) {
                this.item = item;
            }

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                item.setSex(newValue);
            }
        }
    }
}
