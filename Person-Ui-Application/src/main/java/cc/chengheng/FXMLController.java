package cc.chengheng;

import cc.chengheng.model.Person;
import cc.chengheng.model.SampleData;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.beans.Observable;
import javafx.beans.binding.When;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
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

    @FXML private Button createButton;

    @FXML private Button updateButton;

    @FXML private Button removeButton;
    @FXML private GridPane gridPane;

    @FXML private ListView<Person> listView;

    @FXML private TextField firstnameTextField;

    @FXML private TextField lastnameTextField;

    @FXML private TextArea notesTextArea;

    private ChangeListener<Person> personChangeListener;

    ObservableList<Person> personList = FXCollections.observableArrayList(Person.extractor);


    private Person selectedPerson;
    private final BooleanProperty modifiedProperty = new SimpleBooleanProperty(false);

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        SampleData.fillSampleData(personList);
        // 选择项属性是空的禁用按钮
        removeButton.disableProperty().bind(listView.getSelectionModel().selectedItemProperty().isNull());
//        updateButton.disableProperty().bind(listView.getSelectionModel().selectedItemProperty()
//                        .isNull().or(modifiedProperty.not()).or(firstnameTextField.textProperty().isEmpty())
//                .or(lastnameTextField.textProperty().isEmpty()));

        // 选择项属性是空的显示按钮
//        createButton.disableProperty().bind(listView.getSelectionModel().selectedItemProperty().isNotNull()
//                .or(firstnameTextField.textProperty().isEmpty()
//                        .or(lastnameTextField.textProperty().isEmpty())));

        // 设置listView 多项选择
//        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // 使用排序列表;按姓氏排序;然后按名字
        SortedList<Person> sortedList = new SortedList<>(personList);

        // 先按姓氏排序，然后按名字排序;忽略notes
        sortedList.setComparator((p1, p2) -> {
            int result = p1.getLastname().compareToIgnoreCase(p2.getLastname());
            if (result == 0) {
                result = p1.getFirstname().compareToIgnoreCase(p1.getFirstname());
            }
            return result;
        });
        listView.setItems(sortedList);


        listView.getSelectionModel().selectedItemProperty().addListener(
                personChangeListener = (observable, oldValue, newValue) -> {
            selectedPerson = newValue;
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

        // 默认选择第一项
        listView.getSelectionModel().selectFirst();

    }

    @FXML
    private void removeButton_OnAction(ActionEvent actionEvent) {
        personList.remove(selectedPerson);
    }

    public void updateButton_OnAction(ActionEvent actionEvent) {
        Person p = listView.getSelectionModel().getSelectedItem();
        listView.getSelectionModel().selectedItemProperty().removeListener(personChangeListener);
        p.setFirstname(firstnameTextField.getText());
        p.setLastname(lastnameTextField.getText());
        p.setNotes(notesTextArea.getText());
        listView.getSelectionModel().selectedItemProperty().addListener(personChangeListener);
        modifiedProperty.set(false);
    }

    public void createButton_OnAction(ActionEvent actionEvent) {
        Person person = new Person(firstnameTextField.getText(), lastnameTextField.getText(), notesTextArea.getText());
        personList.add(person);
        listView.getSelectionModel().select(person);
    }
}