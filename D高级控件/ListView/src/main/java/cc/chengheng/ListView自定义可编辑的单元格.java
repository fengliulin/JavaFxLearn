package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class ListView自定义可编辑的单元格 extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        AnchorPane anchorPane = new AnchorPane();


        ListView<String> listView = new ListView<>();
        listView.getItems().addAll("1", "2", "3", "4");
        listView.setEditable(true);

        listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new EditableListCell();
            }
        });



        anchorPane.getChildren().add(listView);
        Scene scene = new Scene(anchorPane);

        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();


    }

    private  class EditableListCell extends ListCell<String> {
        private final TextField textField;

        public EditableListCell() {
           textField = new TextField();
           textField.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
               if (event.getCode() == KeyCode.ENTER) {
                   commitEdit(textField.getText());
               } else if (event.getCode() == KeyCode.ESCAPE) {
                   cancelEdit();
               }
           });

            setGraphic(textField);
            setContentDisplay(ContentDisplay.TEXT_ONLY);

        }

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            setText(item);
            setContentDisplay(isEditing() ? ContentDisplay.GRAPHIC_ONLY : ContentDisplay.TEXT_ONLY);
        }

        @Override
        public void startEdit() {
            super.startEdit();
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            textField.requestFocus();
        }

        @Override
        public void commitEdit(String newValue) {
            super.commitEdit(newValue);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}