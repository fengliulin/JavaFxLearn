package cc.chengheng;

import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class BridgingSwingAndJavafxFXMLController implements Initializable {


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
