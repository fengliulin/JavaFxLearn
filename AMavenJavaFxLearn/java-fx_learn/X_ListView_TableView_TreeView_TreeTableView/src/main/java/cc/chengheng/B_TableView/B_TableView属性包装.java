package cc.chengheng.B_TableView;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/*
默认超出，就会出现滚动条
 */
public class B_TableView属性包装 extends Application {

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

        list.addListener(new ListChangeListener<Data>() {
            @Override
            public void onChanged(Change<? extends Data> c) {

            }
        });


        TableView<Data> tableView = new TableView<>(list);
        tableView.setPlaceholder(new Label("没有数据")); // 设置占位符
        tableView.setPrefWidth(300);
        tableView.setPrefHeight(150);

        // 设置列 姓名
        TableColumn<Data, String> columnName = new TableColumn<>("姓名");

        //  public   有get方法， 反射弄的， 类需要是public的
//        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        columnName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Data, String> param) {
                SimpleStringProperty name = new SimpleStringProperty(param.getValue().name.get());
                return name;
            }
        });

        // 设置列 年龄
        TableColumn<Data, Number> columnAge = new TableColumn<>("年龄");
        columnAge.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data, Number>, ObservableValue<Number>>() {
            @Override
            public ObservableValue<Number> call(TableColumn.CellDataFeatures<Data, Number> param) {
                SimpleIntegerProperty age = new SimpleIntegerProperty(param.getValue().age.get());
                return age;
            }
        });

        // 设置列 布尔
        TableColumn<Data, Boolean> columnBOl = new TableColumn<>("布尔");
        columnBOl.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Data, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Data, Boolean> param) {
                SimpleBooleanProperty bol = new SimpleBooleanProperty(param.getValue().bol.get());
                return bol;
            }
        });




        tableView.getColumns().add(columnName);
        tableView.getColumns().add(columnAge);
        tableView.getColumns().add(columnBOl);


        Button bu = new Button("button");



        bu.setOnAction(event -> {

//            d1.name.set("df");

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
        private SimpleStringProperty name = new SimpleStringProperty();
        private SimpleIntegerProperty age = new SimpleIntegerProperty();
        private SimpleBooleanProperty bol = new SimpleBooleanProperty();

        public Data(String name, int age, boolean bol) {
            this.name.set(name);
            this.age.set(age);
            this.bol.set(bol);
        }
    }
}
