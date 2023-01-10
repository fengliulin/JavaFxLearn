package cc.chengheng;

import cc.chengheng.model.Person;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.beans.binding.When;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    public GridPane gridPane;
    public ListView<Person> listView;
    public TextField firstnameTextField;
    public TextField lastnameTextField;
    public TextArea notesTextArea;
    public Button modifiedProperty;
    public ButtonBar buttonBar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // 设置listView 多项选择
//        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

//        SortedList<Person> sortedList = new SortedList<>(personList);
//        sortedList.setComparator((p1, p2) -> {
//            int result = p1.getLastname().compareToIgnoreCase(p2.getLastname());
//            if (result == 0) {
//                result = p1.getFirstname().compareToIgnoreCase(p1.getFirstname());
//            }
//            return result;
//        });
//        listView.setItems(sortedList);



        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            ObservableList<Person> selectedItems = listView.getSelectionModel().getSelectedItems();
            System.out.println(selectedItems);

            Person selectedPerson = newValue;

            if (newValue != null) {
                firstnameTextField.setText(selectedPerson.getFirstname());
                lastnameTextField.setText(selectedPerson.getLastname());
                notesTextArea.setText(selectedPerson.getNotes());
            } else {
                firstnameTextField.setText("");
                lastnameTextField.setText("");
                notesTextArea.setText("");
            }
        });

    }
}