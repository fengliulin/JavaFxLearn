package cc.chengheng;

import javafx.fxml.Initializable;
import javafx.scene.control.Slider;

import java.net.URL;
import java.util.ResourceBundle;

public class RadioButtonFXMLController implements Initializable {


    public Slider slider;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
        });
    }
}