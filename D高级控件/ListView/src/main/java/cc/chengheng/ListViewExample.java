package cc.chengheng;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;

public class ListViewExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        /*URL resource = ListViewExample.class.getResource("/fxml/Scene.fxml");
        assert resource != null;
        Parent root = FXMLLoader.load(resource);*/


        AnchorPane anchorPane = new AnchorPane();




        ListView<Object> listView = new ListView<>();
        listView.getItems().addAll("1","2","3","4");
        listView.setEditable(true);

        listView.setCellFactory(new Callback<ListView<Object>, ListCell<Object>>() {
            @Override
            public ListCell call(ListView<Object> param) {
                return new ColorRectCell();
            }
        });







        anchorPane.getChildren().add(listView);
        Scene scene = new Scene(anchorPane);

        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();


    }

    private static class ColorRectCell extends TextFieldListCell<String> {
        private final Rectangle rect = new Rectangle(100, 20);
        @Override public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty || item == null) {
                setGraphic(null);
            } else {
                rect.setFill(Color.RED);
                setGraphic(rect);
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}