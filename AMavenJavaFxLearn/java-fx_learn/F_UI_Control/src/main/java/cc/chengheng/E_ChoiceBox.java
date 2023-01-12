package cc.chengheng;

import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class E_ChoiceBox extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        ObservableList<String> list1 = FXCollections.observableArrayList();
        list1.addAll("数学1", "数学2");

        Student s1 = new Student("张三1", 1);
        Student s2 = new Student("张三2", 2);
        Student s3 = new Student("张三3", 3);
        Student s4 = new Student("张三4", 4);
        Student s5 = new Student("张三5", 5);

        AnchorPane ap = new AnchorPane();

        ChoiceBox<Student> choiceBox = new ChoiceBox<>();

        ChoiceBox<String> choiceBox1 = new ChoiceBox<>();
        choiceBox1.setLayoutY(100);
        choiceBox.setStyle("-fx-background-color: #ffa07a");

        choiceBox.getItems().addAll(s1, s2, s3, s4, s5);

        choiceBox.setConverter(new StringConverter<Student>() {
            // 数据转换，对象变成数据显示到列表
            @Override
            public String toString(Student object) {
                return object.getName();
            }

            @Override
            public Student fromString(String string) {
                return null;
            }
        });

        choiceBox.getSelectionModel().selectFirst();

        // 选择的项添加事件监听
        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Student>() {
            @Override
            public void changed(ObservableValue<? extends Student> observable, Student oldValue, Student newValue) {
                if (newValue.getName().equals("张三1")) {
                    choiceBox1.setItems(list1);
                } else {
                    choiceBox1.setItems(FXCollections.observableArrayList());
                }
            }
        });

//        ButtonBar.setButtonUniformSize(b1,true);

        ap.getChildren().addAll(choiceBox, choiceBox1);

        //=======================================================
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

    }

    private static class Student {
        private String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
