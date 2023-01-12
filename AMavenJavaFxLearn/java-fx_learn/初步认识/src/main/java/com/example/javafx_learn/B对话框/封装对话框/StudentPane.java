package com.example.javafx_learn.B对话框.封装对话框;

import java.text.SimpleDateFormat;
import java.util.List;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.util.Callback;

public class StudentPane extends TreeTableView<Student> {
    // 根节点
    TreeItem rootItem = new TreeItem(new Student());

    // 列
    TreeTableColumn<Student, Student> columns[] = new TreeTableColumn[3];

    public StudentPane() {
        // 初始化列的设置
        initColumns();

        // 扁平化显示, 不显示根节点, 但必须要有根节点
        this.setRoot(rootItem);
        this.setShowRoot(false);
    }

    // 清空
    public void clear() {
        rootItem.getChildren().clear();
    }

    // 添加
    public void add(List<Student> datalist) {
        for (Student fi : datalist) {
            TreeItem item = new TreeItem(fi);
            rootItem.getChildren().add(item);
        }
    }

    public void add(Student data) {
        TreeItem item = new TreeItem(data);
        rootItem.getChildren().add(item);
    }

    @Override
    protected void layoutChildren() {
        super.layoutChildren();

        // 动态设置列宽
        double w = this.getWidth();
        double w0 = w * 0.3;
        double w1 = w * 0.4;
        double w2 = w - w0 - w1 - 20;
        columns[0].setPrefWidth(w0);
        columns[1].setPrefWidth(w1);
        columns[2].setPrefWidth(w2);
    }

    private void initColumns() {
        // 添加多个列
        columns[0] = new TreeTableColumn("学号");
        columns[1] = new TreeTableColumn("姓名");
        columns[2] = new TreeTableColumn("手机号");
        this.getColumns().addAll(columns);

        // 重写layoutChildren() 动态调整个列的列宽


        // 设置 CellValueFactory (此段写法固定)
        Callback cellValueFactory = new Callback() {
            @Override
            public Object call(Object param) {
                CellDataFeatures p = (CellDataFeatures) param;
                return p.getValue().valueProperty();
            }
        };
        for (int i = 0; i < columns.length; i++) {
            columns[i].setCellValueFactory(cellValueFactory);
        }

        // 设置CellFactory，定义每一列的单元格的显示
        // 这里使用了lambda表达式，否则写起来太长了！
        columns[0].setCellFactory((param) -> {
            return new MyTreeTableCell("c0");
        });
        columns[1].setCellFactory((param) -> {
            return new MyTreeTableCell("c1");
        });
        columns[2].setCellFactory((param) -> {
            return new MyTreeTableCell("c2");
        });

    }

    // 单元格的显示
    static class MyTreeTableCell extends TreeTableCell<Student, Student> {
        String columnID;

        public MyTreeTableCell(String columnID) {
            this.columnID = columnID;
        }

        @Override
        protected void updateItem(Student item, boolean empty) {
            super.updateItem(item, empty);

            if (empty || item == null) {
                setText(null);
                setGraphic(null);
            } else {
                setGraphic(null);
                if (columnID.equals("c0")) {
                    setText(String.valueOf(item.id));
                } else if (columnID.equals("c1")) {
                    setText(String.valueOf(item.name));
                } else if (columnID.equals("c2")) {
                    setText(String.valueOf(item.phone));
                }
            }
        }

    }
}
