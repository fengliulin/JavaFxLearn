package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ApplyingStyles extends Application {

    private Label label = new Label("Stylized label");
    private TextField widthField = new TextField("500") {
        @Override
        public void replaceText(int start, int end, String text) {
            if (text.matches("[0-9]*")) {
                super.replaceText(start, end, text);
            }
        }

        @Override
        public void replaceSelection(String replacement) {
            if (replacement.matches("[0-9]*")) {
                super.replaceSelection(replacement);
            }

        }
    };

    private void updateLabelStyle() {
        label.setStyle(
                "-fx-background-color: black;" +
                        "-fx-text-fill: white;" +
                        "-fx-padding: 10;" +
                        "-fx-pref-width: " + widthField.getText() + "px;"
        );
    }


    @Override
    public void start(Stage stage) throws IOException {
        updateLabelStyle();
        widthField.setOnAction(event -> {
            updateLabelStyle();
        });


        System.out.println(widthField.getWidth());



        VBox root = new VBox(10);
        root.getChildren().addAll(label, widthField);


        root.setStyle("-fx-background-color: lightblue;" +
                "-fx-padding: 20px;");



        Scene scene = new Scene(root, 200, 300);



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