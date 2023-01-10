package cc.chengheng;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.When;
import javafx.beans.value.ObservableObjectValue;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class MyShapesFXML extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        URL resource = MyShapesFXML.class.getResource("/fxml/Scene.fxml");
        assert resource != null;
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        // 加载样式表
        scene.getStylesheets().add(getClass().getResource("/styles/Styles.css").toExternalForm());

        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}