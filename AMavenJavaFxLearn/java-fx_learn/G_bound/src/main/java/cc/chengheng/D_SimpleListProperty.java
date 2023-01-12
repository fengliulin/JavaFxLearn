package cc.chengheng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class D_SimpleListProperty extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.addAll("A", "b", "c");
        SimpleListProperty<String> slp = new SimpleListProperty<>(list);
        slp.addListener(new ChangeListener<ObservableList<String>>() {
            @Override
            public void changed(ObservableValue<? extends ObservableList<String>> observable, ObservableList<String> oldValue, ObservableList<String> newValue) {
                oldValue.forEach(System.out::println);
                System.out.println();
                newValue.forEach(System.out::println);
            }
        });

        // 可以获得每个内容
        slp.addListener(new ListChangeListener<String>() {
            @Override
            public void onChanged(Change<? extends String> c) {
                c.getList().forEach(System.out::println);

                c.next();
                System.out.println(c.wasAdded());
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
