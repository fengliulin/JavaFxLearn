package cc.chengheng;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ChoiceBoxFXMLController implements Initializable {


    public Button button;
    public ChoiceBox choiceBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.setValue("Dff");
        choiceBox.getItems().addAll("1", "4", "你好", 4);

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });
    }
}
