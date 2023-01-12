package cc.chengheng;

import cc.chengheng.controller.MyController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class A_FXML extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        URL resource = A_FXML.class.getResource("/MyFxml.fxml");
        String decode = URLDecoder.decode(resource.toExternalForm(), StandardCharsets.UTF_8);

        // 设置样式
        Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);

        FXMLLoader fxmlLoader = new FXMLLoader(URI.create(decode).toURL());

        AnchorPane root = fxmlLoader.load();

        root.setStyle("-fx-background-color: #Ab82FF");

        // 拿到控制器的对象
        MyController mc = fxmlLoader.getController();


        // 拿标签对象
        Button btn = (Button) root.lookup("#fxmlButton");
        System.out.println(btn.getText());

        // 添加拿到标签Button组件，设置单击事件
        /*btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("df");
            }
        });*/

        // 添加css
//        URL resource = this.getClass().getResource("/myCss.css");

        Scene scene = new Scene(root, 320, 240);
        primaryStage.setScene(scene);
//        scene.getStylesheets().add(resource.toExternalForm());
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
