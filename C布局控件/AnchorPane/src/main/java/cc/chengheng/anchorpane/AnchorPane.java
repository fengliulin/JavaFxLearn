package cc.chengheng.anchorpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class AnchorPane extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AnchorPane.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);


        javafx.scene.layout.AnchorPane anchorPane = new javafx.scene.layout.AnchorPane();
        Label label = new Label("My Label");

        anchorPane.getChildren().add(label);
        javafx.scene.layout.AnchorPane.setLeftAnchor(label, 10.0);
        javafx.scene.layout.AnchorPane.setBottomAnchor(label, 10.0);

        stage.setTitle("Hello!");
        stage.setScene(new Scene(anchorPane, 300, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}