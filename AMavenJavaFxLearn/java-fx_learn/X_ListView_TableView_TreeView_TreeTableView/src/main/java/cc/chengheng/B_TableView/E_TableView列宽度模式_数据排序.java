package cc.chengheng.B_TableView;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/*
默认超出，就会出现滚动条
 */
public class E_TableView列宽度模式_数据排序 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Data d1 = new Data("张三1", 18, true);
        Data d2 = new Data("张三2", 19, false);
        Data d3 = new Data("张三3", 20, true);
        Data d4 = new Data("张三4", 21, false);

        ObservableList<Data> list = FXCollections.observableArrayList();
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);


        TableView<Data> tableView = new TableView<>(list);
        tableView.setPlaceholder(new Label("没有数据")); // 设置占位符
        tableView.setPrefWidth(300);
        tableView.setPrefHeight(150);

        // 设置列 姓名
        TableColumn<Data, String> columnName = new TableColumn<>("姓名");
        columnName.setPrefWidth(100);
        columnName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Data, String> param) {
                SimpleStringProperty name = new SimpleStringProperty(param.getValue().name);
                return name;
            }
        });

        // 设置列 年龄
        TableColumn<Data, Number> columnAge = new TableColumn<>("年龄");
        columnAge.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data, Number>, ObservableValue<Number>>() {
            @Override
            public ObservableValue<Number> call(TableColumn.CellDataFeatures<Data, Number> param) {
                SimpleIntegerProperty age = new SimpleIntegerProperty(param.getValue().age);
                return age;
            }
        });

        // 设置列 布尔
        TableColumn<Data, Boolean> columnBOl = new TableColumn<>("布尔");
        columnBOl.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Data, Boolean> param) {
                SimpleBooleanProperty bol = new SimpleBooleanProperty(param.getValue().bol);
                return bol;
            }
        });


        tableView.getColumns().add(columnName);
        tableView.getColumns().add(columnAge);
        tableView.getColumns().add(columnBOl);


        // 平分每个列的宽度
        double width = tableView.getPrefWidth() / tableView.getColumns().size();
        columnName.setPrefWidth(width);
        columnAge.setPrefWidth(width);
        columnBOl.setPrefWidth(width);

        // 设置右边的菜单
        tableView.setTableMenuButtonVisible(true);

        // 滚动到某列
//        tableView.scrollToColumn(columnBOl);

        // 设置单元格的大小
//        tableView.setFixedCellSize(60);

        // 编辑单元格
        tableView.setEditable(true);
        columnName.setCellFactory(TextFieldTableCell.forTableColumn());

        columnAge.setCellFactory(TextFieldTableCell.forTableColumn(new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                return Integer.getInteger(string);
            }
        }));

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Data>() {
           // 它监听的还是某一行
            @Override
            public void changed(ObservableValue<? extends Data> observable, Data oldValue, Data newValue) {
                tableView.getSelectionModel().getSelectedIndices().forEach(System.out::println);
            }
        });

        // 选中单元格
        tableView.getSelectionModel().setCellSelectionEnabled(true);


        // 这种可以获取单元格里面的监听数据
        tableView.getSelectionModel().getSelectedCells().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                ObservableList<TablePosition> obs = (ObservableList<TablePosition>) observable;

                for (int i = 0; i < obs.size(); i++) {
                    TablePosition tp = obs.get(i);
                    Object obj = tp.getTableColumn().getCellData(tp.getRow());
                    System.out.println("行 = " + tp.getRow() + "列=" + tp.getColumn() + "数据 = " + obj.toString());
                }
            }
        });

        // 调整列宽模式
        tableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);

        tableView.setColumnResizePolicy(new Callback<TableView.ResizeFeatures, Boolean>() {
            @Override
            public Boolean call(TableView.ResizeFeatures param) {
                /*if (param.getColumn() != null) {
                    double w = param.getColumn().getPrefWidth();
                    param.getColumn().setPrefWidth(w + param.getDelta());
                }*/
                return null;
            }
        });

        // 排序
        columnName.setSortable(false);
        tableView.setSortPolicy(new Callback<TableView<Data>, Boolean>() {
            @Override
            public Boolean call(TableView<Data> param) {
                return null;
            }
        });

        Button bu = new Button("button");

        bu.setOnAction(event -> {
            tableView.getSelectionModel().select(2, columnAge);
            tableView.requestFocus();
//            tableView.refresh();

        });

        //================================================================
        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(tableView, bu);

        AnchorPane.setLeftAnchor(tableView, 200.0);
        AnchorPane.setTopAnchor(tableView, 100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);


        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }

    static public class Data {
        private String name;
        private int age;
        private boolean bol;

        public Data(String name, int age, boolean bol) {
            this.name = name;
            this.age = age;
            this.bol = bol;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public boolean isBol() {
            return bol;
        }

        public void setBol(boolean bol) {
            this.bol = bol;
        }
    }
}
