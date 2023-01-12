package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class 样式用法Example extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        Label label = new Label("Stylized label");
        Label label1 = new Label("Stylized label");
        VBox root = new VBox();
        root.getChildren().addAll(label, label1);

        // 给某个节点添加样式
        label1.getStyleClass().add("big-bold-text");


        // 使用id选择器
        label.setId("big-bold-text1");

        // 添加css
/*
FXML添加css样式
<!-- 指定样式类 -->
<Label styleClass="fancy-label" />
<!-- 直接指定样式 -->
<Label style="-fx-pref-width: 500px" />
<!-- 指定样式表 -->
<Label stylesheets="@styles.css" />

 */





        Scene scene = new Scene( root, 200, 300 );

        scene.getStylesheets().add(getClass().getResource("/Style.css").toExternalForm());
//        scene.getStylesheets().add( "http://website/folder/styles.css" ); 加载远程样式


        // 全局样式表设置
        Application.setUserAgentStylesheet("");

        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();



    }

    private static class MyListCell<T> extends ListCell<T> {

        @Override
        protected void updateItem(T item, boolean empty) {
            super.updateItem(item, empty);

            HBox hBox = new HBox();
            Button button = new Button((String) item);
            hBox.getChildren().add(button);
            this.setGraphic(hBox);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}