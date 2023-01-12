package cc.chengheng;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ContextMenuExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL resource = ContextMenuExample.class.getResource("/fxml/Scene.fxml");
        assert resource != null;
        AnchorPane root = FXMLLoader.load(resource);


        Menu file = new Menu("file");

        file.getItems().addAll(new MenuItem("最近"));

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.setPrefWidth(200);
        contextMenu.setMaxWidth(200);
        contextMenu.getItems().addAll(
                file,
                new MenuItem("Pizzz")
        );

        Rectangle rectangle = new Rectangle(150, 50, Color.RED);
        rectangle.setX(200);
//        rectangle.setOnContextMenuRequested(event -> {
//            contextMenu.show(rectangle, Side.LEFT, 0,0);
//        });

        root.getChildren().addAll(rectangle);




        Scene scene = new Scene(root);

        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();

        // 鼠标右键点击弹出菜单
        scene.setOnMouseClicked(event -> {
            MouseButton button = event.getButton();
            if (button == MouseButton.SECONDARY) {
                System.out.println("df");
                contextMenu.show(rectangle, Side.LEFT, 0,0);
            }
        });

    }

    public static void main(String[] args) {
        launch();
    }
}