package cc.chengheng;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
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

public class ChoiceBoxExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL resource = ChoiceBoxExample.class.getResource("/fxml/Scene.fxml");
        assert resource != null;
        AnchorPane root = FXMLLoader.load(resource);


        Scene scene = new Scene(root);

        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}