package cc.chengheng;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.beans.PropertyChangeSupport;

public class C_ReadOnlyDoubleWrapper_上一个的使用 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        ReadOnlyDoubleWrapper ro = new ReadOnlyDoubleWrapper(3);

        ReadOnlyDoubleProperty readOnlyProperty = ro.getReadOnlyProperty();

        readOnlyProperty.get();




        AnchorPane an = new AnchorPane();


//        an.setPrefWidth();

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

        Data data = new Data("A", 18);


        data.nameProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println("数据改变");
            }
        });

        data.setName("你好");

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
