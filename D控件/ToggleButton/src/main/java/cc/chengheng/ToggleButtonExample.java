package cc.chengheng;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ToggleButtonExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL resource = ToggleButtonExample.class.getResource("/fxml/Scene.fxml");
        assert resource != null;
        Parent root = FXMLLoader.load(resource);

        ToggleButton tb1 = new ToggleButton("ToggleButton1");
        ToggleButton tb2 = new ToggleButton("ToggleButton2");
        ToggleButton tb3 = new ToggleButton("ToggleButton3");

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(tb1, tb2, tb3);

        ObservableList<Toggle> toggles = toggleGroup.getToggles();

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(toggleGroup.getSelectedToggle());
        });

        Scene scene = new Scene(root);

        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}