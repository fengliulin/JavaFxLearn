package com.example.javafx_learn.C菜单;

import com.example.javafx_learn.A列表_树表格_多列列表.A_ListView.Student;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

/**
 * 理解ObservableList：    Observable(被观察者)
 * ListView是它的观察者，当list内容发生变化的时
 * 候，ListView会被通知并自动刷新
 */
public class A_上下文菜单 extends Application {

    // 创建ListView，指定数据项类型
    ListView<Student> listView = new ListView<>();

    // 数据源
    // 注：ObservableList 是一个比较难懂的设计，初学时只要把它当成普通的 ArrayList 来用即可。
    ObservableList<Student> listData = FXCollections.observableArrayList(); // 当list view 改变，更新这里面的数据

    // ListView的上下文菜单
    ContextMenu listContextMenu = new ContextMenu();


    HBox hBox =new HBox();
    TextField textField = new TextField();
    Button btnInsert = new Button("增加");
    Button btnRemove = new Button("删除");
    Button btnChange = new Button("修改");

    @Override
    public void start(Stage stage) throws IOException {

        // 给上下文菜单添加菜单项
        MenuItem menuItemRemove = new MenuItem("删除");
        listContextMenu.getItems().add(menuItemRemove);

        listView.setContextMenu(listContextMenu);
        menuItemRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int index = listView.getSelectionModel().getSelectedIndex();
                if(index >= 0)
                {
                    listData.remove(index);
                }
            }
        });


        hBox.getChildren().addAll(textField, btnInsert, btnChange, btnRemove);

        for (int i = 0; i < 100000; i++) {
            //准备数据
            listData.add (new Student(i, "张三" + i, true));
            /*listData.add (new Student(2 +i, "张三2", false));
            listData.add (new Student(3, "张三3", true));*/
        }
        /*//准备数据
        listData.add (new Student(1, "fg", true));
        listData.add (new Student(2, "jjk", true));
        listData.add (new Student(3, "kkk", true));*/

        // 设置数据源
        listView.setItems(listData);

        // 设置单元格生成器 (工厂)
        listView.setCellFactory(new Callback<ListView<Student>, ListCell<Student>>() {
            @Override
            public ListCell<Student> call(ListView<Student> param) {
                MyListCell myListCell = new MyListCell();
                // 给每个单元格设置拖拽事件
                myListCell.setOnDragDetected(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Dragboard dragboard = myListCell.startDragAndDrop(TransferMode.MOVE);
                        ClipboardContent clipboardContent = new ClipboardContent();
                        clipboardContent.putString("data");

                        dragboard.setContent(clipboardContent);
                        System.out.println("dfdf");
                    }
                });
                return myListCell;
            }
        });

        BorderPane root = new BorderPane();
        root.setCenter(listView);

        root.setTop(hBox);

        // 鼠标事件
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) {
                    System.out.println("双击了鼠标");
                }

                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                    System.out.println("单击了鼠标");
                }
            }
        });

        listView.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

            }
        });


        btnChange.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textField.getText();
                int selectedIndex = listView.getSelectionModel().getSelectedIndex();
                if (selectedIndex >= 0) {
                    Student s = listData.get(selectedIndex);
                    s.setName(text);
                    listData.set(selectedIndex, s);
                }
            }
        });

        btnInsert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text = textField.getText();
                System.out.println(text);
                listData.add(new Student(0, text, true));
            }
        });

        btnRemove.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int selectedIndex = listView.getSelectionModel().getSelectedIndex();
                Student selectedItem = listView.getSelectionModel().getSelectedItem();
                System.out.println("选择的索引是" + selectedIndex);
                if (selectedIndex >= 0) {
                    listView.getItems().remove(selectedIndex);
                }

            }
        });


        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
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
                this.setText("");
            } else {
                this.setText(item.getName());
            }
        }
    }

    public static void main(String[] args) {
        Application.launch(A_上下文菜单.class);
    }
}
