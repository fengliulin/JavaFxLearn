/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/13
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng.Dukescript;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Dukescript框架 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TabPane tabPane = new TabPane();
        Parent parent = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));


        tabPane.getTabs().add(new Tab("FXML", parent));


        Scene scene = new Scene(tabPane);
        stage.setTitle("JavaFX and DukeScript");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

