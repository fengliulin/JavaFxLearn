package cc.chengheng;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.io.IOException;
import java.net.URL;

public class ComboBoxExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Button button = new Button("getValue");


        ComboBox<String> comboBox = new ComboBox();
        comboBox.setTranslateX(100);

        button.setOnAction(event -> {
            System.out.println(comboBox.getValue());
        });

        comboBox.getItems().addAll("string1", "string2", "string3");


        comboBox.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String object) {
                return object + "-fengliulin";
            }

            @Override
            public String fromString(String string) {
                System.out.println(string);
                return string;
            }
        });

        group.getChildren().addAll(comboBox, button);

        comboBox.setEditable(true);

        comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                MyListCell<String> stringListCell = new MyListCell<>();
                return stringListCell;
            }
        });

        comboBox.setOnAction(event -> {
            System.out.println(comboBox.getValue());
        });



        Scene scene = new Scene(group);

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