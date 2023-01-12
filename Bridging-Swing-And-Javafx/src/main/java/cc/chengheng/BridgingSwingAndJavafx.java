package cc.chengheng;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class BridgingSwingAndJavafx extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL resource = BridgingSwingAndJavafx.class.getResource("/fxml/Scene.fxml");
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