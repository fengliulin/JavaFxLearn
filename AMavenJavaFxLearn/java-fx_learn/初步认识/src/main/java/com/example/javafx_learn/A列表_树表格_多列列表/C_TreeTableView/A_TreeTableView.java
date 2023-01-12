package com.example.javafx_learn.A列表_树表格_多列列表.C_TreeTableView;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
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
public class A_TreeTableView extends Application {

    TreeTableView<UploadItem> treeTable = new TreeTableView<>();


    @Override
    public void start(Stage stage) throws IOException {

        // 添加多个列
        TreeTableColumn<UploadItem, UploadItem> columns[] = new TreeTableColumn[]{
                new TreeTableColumn<>("文件名"),
                new TreeTableColumn<>("大小"),
                new TreeTableColumn<>("任务创建时间")
        };

        // 定义每个列的列宽
        columns[0].setPrefWidth(150);
        columns[1].setPrefWidth(80);
        columns[2].setPrefWidth(120);

        treeTable.getColumns().addAll(columns); // 让列头添加到树表格


        //==========================================每一列都要设置一个单元格值的属性和单元格自己===============================
        // setCellValueFactory 提供数据的，  固定写法
        for (int i = 0; i < columns.length; i++) {
            columns[i].setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<UploadItem, UploadItem>, ObservableValue<UploadItem>>() {
                @Override
                public ObservableValue<UploadItem> call(TreeTableColumn.CellDataFeatures<UploadItem, UploadItem> param) {
                    return param.getValue().valueProperty();
                }
            });
        }

        // setCellFactory 定义显示的
        columns[0].setCellFactory(new Callback<TreeTableColumn<UploadItem, UploadItem>, TreeTableCell<UploadItem, UploadItem>>() {
            @Override
            public TreeTableCell<UploadItem, UploadItem> call(TreeTableColumn<UploadItem, UploadItem> param) {
                System.out.println("Df");
                return new MyTableTreeCell("title");
            }
        });

        columns[1].setCellFactory(new Callback<TreeTableColumn<UploadItem, UploadItem>, TreeTableCell<UploadItem, UploadItem>>() {
            @Override
            public TreeTableCell<UploadItem, UploadItem> call(TreeTableColumn<UploadItem, UploadItem> param) {
                return new MyTableTreeCell("size");
            }
        });

        columns[2].setCellFactory(new Callback<TreeTableColumn<UploadItem, UploadItem>, TreeTableCell<UploadItem, UploadItem>>() {
            @Override
            public TreeTableCell<UploadItem, UploadItem> call(TreeTableColumn<UploadItem, UploadItem> param) {
                return new MyTableTreeCell("filePath");
            }
        });

        //==================================================初始化数据====================================================
        // 根节点只是占一个位置
        TreeItem<UploadItem> itemRoot = new TreeItem<UploadItem>(new UploadItem());
        treeTable.setRoot(itemRoot);
        treeTable.setShowRoot(false); // 如果为true，会显示树结构，又有表格的结构

        UploadItem data1 = new UploadItem("测试视频", 192000, System.currentTimeMillis());
        UploadItem data2 = new UploadItem("测试图片", 239000, System.currentTimeMillis());
        TreeItem<UploadItem> itemData1 = new TreeItem<>(data1);
        TreeItem<UploadItem> itemData2 = new TreeItem<>(data2);

        itemRoot.getChildren().addAll(itemData1, itemData2);

        //==============================================================================================================
        BorderPane root = new BorderPane();
        root.setCenter(treeTable);

        Scene scene = new Scene(root, 1080, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    // 单元格的显示
    class MyTableTreeCell extends TreeTableCell<UploadItem, UploadItem> {

        private final String columnID;

        public MyTableTreeCell(String columnID) {
            this.columnID = columnID;
        }

        @Override
        protected void updateItem(UploadItem item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
                setGraphic(null);
            } else {
                setGraphic(null);
                // 主要修改这些和数据， 其他都是固定写法
                switch (columnID) {
                    case "title":
                        this.setText(item.getTitle());
                        break;
                    case "size":
                        this.setText(String.valueOf(item.getSize()));
                        break;
                    case "filePath":
                        this.setText(String.valueOf(item.getTimeCreated()));
                        break;
                }
            }
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}
