package cc.chengheng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import javafx.collections.SetChangeListener;
import javafx.stage.Stage;

public class F_SimpleMapProperty extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ObservableMap<String, String> map = FXCollections.observableHashMap();
        map.put("a", "a");

        SimpleMapProperty<String, String> ssp = new SimpleMapProperty<>(map);

        ssp.addListener(new MapChangeListener<String, String>() {
            @Override
            public void onChanged(Change<? extends String, ? extends String> change) {
                System.out.println("df");
            }
        });


        ssp.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("失效监听");
            }
        });


        map.put("1", "11f");

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
