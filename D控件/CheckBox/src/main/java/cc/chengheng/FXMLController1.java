package cc.chengheng;

import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController1 implements Initializable {

    public CheckBox checkBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(oldValue);
        });
    }
}