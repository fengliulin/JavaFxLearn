package cc.chengheng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.stage.Stage;

public class E_SimpleSetProperty extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("A", "b", "c");

        SimpleSetProperty<Object> ssp = new SimpleSetProperty<>();

        ssp.addListener(new SetChangeListener<Object>() {
            @Override
            public void onChanged(Change<?> change) {

            }
        });


        list.add("D");

        Platform.exit();
    }

    private static class Data {

        private String name1;
        private final SimpleIntegerProperty age = new SimpleIntegerProperty();
        private final SimpleStringProperty name = new SimpleStringProperty();

        public Data(String name, int age) {
            this.age.set(age);
            this.name.set(name);
        }

        public int getAge() {
            return age.get();
        }

        public SimpleIntegerProperty ageProperty() {
            return age;
        }

        public void setAge(int age) {
            this.age.set(age);
        }

        public String getName() {
            return name.get();
        }

        public SimpleStringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            if (this.name1 == null) {
                name1 = name;
            } else {
                this.name.set(name);
            }
        }
    }
}
