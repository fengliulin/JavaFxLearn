package cc.chengheng.C_TreeView;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
默认超出，就会出现滚动条
 */
public class A_TreeView extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {



        TreeView<String> treeView = new TreeView<>();




        TreeItem<String> root = new TreeItem<>("中国");

        TreeItem<String> hlj = new TreeItem<>("黑龙江省");
        TreeItem<String> city1 = new TreeItem<>("哈尔冰");

        TreeItem<String> gd = new TreeItem<>("河南省");
        TreeItem<String> city2 = new TreeItem<>("郑州");

        treeView.setRoot(root);

        hlj.getChildren().add(city1);
        gd.getChildren().add(city2);

        root.getChildren().addAll(hlj, gd);


        treeView.setPrefWidth(500);
        treeView.setPrefHeight(800);

//        root.setExpanded(true); // 设置默认展开

        treeView.setOnScrollTo(new EventHandler<ScrollToEvent<Integer>>() {
            @Override
            public void handle(ScrollToEvent<Integer> event) {
                System.out.println(event.getScrollTarget());
            }
        });

//        System.out.println(city1.previousSibling().getValue());

        treeView.setFixedCellSize(40);


        treeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<String>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<String>> observable, TreeItem<String> oldValue, TreeItem<String> newValue) {
                System.out.println("单击选择了");
            }
        });


        // 编辑单元格
        treeView.setEditable(true);
        treeView.setCellFactory(TextFieldTreeCell.forTreeView());




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
}
