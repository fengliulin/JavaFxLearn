package cc.chengheng.B_TableView;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/*
默认超出，就会出现滚动条
 */
public class A_TableView extends Application {

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

        //  public   有get方法， 反射弄的， 类需要是public的
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        /*columnName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Data, String> param) {
                SimpleStringProperty name = new SimpleStringProperty(param.getValue().name);
                return name;
            }
        });*/

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


        Button bu = new Button("button");



        bu.setOnAction(event -> {

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
