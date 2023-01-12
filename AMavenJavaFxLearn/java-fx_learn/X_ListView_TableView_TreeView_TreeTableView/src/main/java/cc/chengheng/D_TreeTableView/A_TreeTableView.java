package cc.chengheng.D_TreeTableView;

import cc.chengheng.A_ListView.E_ListView自定义单元格;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/*
默认超出，就会出现滚动条
 */
public class A_TreeTableView extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Data d1 = new Data("A1", 18);
        Data d2 = new Data("A2", 19);
        Data d3 = new Data("A3", 20);
        Data d4 = new Data("A4", 21);


        TreeTableView<Data> treeView = new TreeTableView<>();

        TreeItem<Data> root = new TreeItem<>(d1);

        TreeItem<Data> t1 = new TreeItem<>(d2);
        TreeItem<Data> t2 = new TreeItem<>(d3);
        TreeItem<Data> t3 = new TreeItem<>(d4);

        root.getChildren().addAll(t1, t2, t3);


        treeView.setRoot(root);

        TreeTableColumn<Data, String> columnName = new TreeTableColumn<>("姓名");
        TreeTableColumn<Data, String> columnAge = new TreeTableColumn<>("年龄");


        columnName.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));


        treeView.getColumns().addAll(columnName, columnAge);



        Button bu = new Button("按钮");

        bu.setOnAction(event -> {
        });

        //================================================================
        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(treeView, bu);

        AnchorPane.setLeftAnchor(treeView, 200.0);
        AnchorPane.setTopAnchor(treeView, 100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);


        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();


    }

    public static class Data {
        private String name;
        private int age;

        public Data(String name, int age) {
            this.name = name;
            this.age=age;
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
    }
}
