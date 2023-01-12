package cc.chengheng.A_ListView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.Serializable;

/*
默认超出，就会出现滚动条
 */
public class A_ListView extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("data-a");
        list.add("data-b");
        list.add("data-c");
        list.add("data-d");
        list.add("data-e");
        list.add("data-f");
        list.add("data-g");
        list.add("data-h");
        list.add("data-i");

        ListView<String> listView = new ListView<>(list);
        listView.setPlaceholder(new Label("没有数据")); // 设置占位符
        listView.setPrefWidth(300);
        listView.setPrefHeight(150);


        listView.setFixedCellSize(50); // 设置单元格大小
//        listView.setFocusTraversable(false);

        listView.getFocusModel().focus(2);
        System.out.println(listView.getFocusModel().getFocusedItem());

        listView.getFocusModel().focusedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });

        // 设置按ctrl多选
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


//        listView.setOrientation(Orientation.HORIZONTAL); // 水平显示

        // listView.getItems()返回的就是可观察的列表
        listView.getItems().add("df");


        Button bu = new Button("button");


        // 鼠标选择列表的就会执行   拿到数据
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });

        // 拿到索引
        listView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println(newValue);
            }
        });

        // 要配合 listView.scrollTo(8); 用， 监听的就是scrollTo
        listView.setOnScrollTo(new EventHandler<ScrollToEvent<Integer>>() {
            @Override
            public void handle(ScrollToEvent<Integer> event) {
                System.out.println(event.getScrollTarget());
            }
        });

        // 设置双击可以修改, 要一起使用
        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());

        bu.setOnAction(event -> {
           /* list.add("Df");
            list.set(0, "df");

            list.remove(1);*/
//            listView.getSelectionModel().select("data-i");

//            listView.getSelectionModel().selectIndices(2, 4);
            listView.scrollTo(8);

//            listView.requestFocus();

//            System.out.println(listView.getSelectionModel().getSelectedIndex());
//            System.out.println(listView.getSelectionModel().getSelectedItems());
//            System.out.println(listView.getSelectionModel().getSelectedIndices());

            list.forEach(System.out::println);
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
}
