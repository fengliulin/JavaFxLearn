package cc.chengheng.Dukescript;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Dukescript框架FXMLController implements Initializable {


    public Label label;
    public Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleButtonAction(ActionEvent actionEvent) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
}