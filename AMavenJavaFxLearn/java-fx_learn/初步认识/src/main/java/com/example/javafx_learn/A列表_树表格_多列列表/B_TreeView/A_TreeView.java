package com.example.javafx_learn.A列表_树表格_多列列表.B_TreeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

/**
 * 理解ObservableList：    Observable(被观察者)
 * ListView是它的观察者，当list内容发生变化的时
 * 候，ListView会被通知并自动刷新
 */
public class A_TreeView extends Application {

    TreeView<ItemData> treeView = new TreeView<>();
    ItemData dataRoot = new ItemData("TreeView树控件learn", true);
    TreeItem<ItemData> itemRoot = new TreeItem<>(dataRoot);

    @Override
    public void start(Stage stage) throws IOException {

        BorderPane root = new BorderPane();

        ItemData itemDataC = new ItemData("c/c++学习指南", true);
        TreeItem<ItemData> itemC = new TreeItem<>(itemDataC);

        ItemData itemDataJava = new ItemData("java学习指南", true);
        TreeItem<ItemData> itemJava = new TreeItem<>(itemDataJava);

        ItemData itemDataCommon = new ItemData("公共基础课", true);
        TreeItem<ItemData> itemCommon = new TreeItem<>(itemDataCommon);

        itemRoot.getChildren().addAll(itemCommon, itemJava, itemCommon);

        // 在"Java学习指南系列" 下添加子节点
        ItemData data1 = new ItemData("快速入门", false);
        ItemData data2 = new ItemData("高级语法", false);
        itemJava.getChildren().add(new TreeItem<ItemData>(data1));
        itemJava.getChildren().add(new TreeItem<ItemData>(data2));

        // 在"公共基础课程" 下添加子节点
        ItemData data3 = new ItemData("CentOS使用教程", false);
        ItemData data4 = new ItemData("MySQL使用教程", false);
        itemCommon.getChildren().add(new TreeItem<ItemData>(data3));
        itemCommon.getChildren().add(new TreeItem<ItemData>(data4));

        // 设置根节点
        treeView.setRoot(itemRoot);

        // 设置 CellFactory
        treeView.setCellFactory(new Callback<TreeView<ItemData>, TreeCell<ItemData>>() {
            @Override
            public TreeCell<ItemData> call(TreeView<ItemData> param) {
                return new MyTreeCell();
            }
        });

        root.setCenter(treeView);


        Scene scene = new Scene(root, 400, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * TreeCell 负责列表项里每一行的 cell 的显示
     */
    static class MyTreeCell extends TreeCell<ItemData> {
        @Override
        protected void updateItem(ItemData item, boolean empty) {
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
        Application.launch(A_TreeView.class);
    }
}
