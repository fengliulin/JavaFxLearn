package cc.chengheng.controller;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Start Date: 2021/10/26
 * Author: 冯镠霖(fengliulin)
 */
public class MyController implements Initializable {

    // 两种写法，实现 Initializable 不需要字段和方法添加 @FXML

    // 不实现需要添加@FXML


    // 实现 Initializable， 会自动注入
    public Label fxmlLabel;
    public Button fxmlButton;
    public ListView<String> listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("df");
        System.out.println(fxmlLabel.getText());

       listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
           @Override
           public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
               System.out.println("f");
           }
       });

    }

    public void action(ActionEvent actionEvent) {
        System.out.println("单击事件MyController");
        listView.getItems().add("你好");
        listView.getItems().set(0, "我");
        listView.getItems().remove(0);
    }

    public Label getFxmlLabel() {

        return fxmlLabel;
    }

    public Button getFxmlButton() {
        return fxmlButton;
    }
}
