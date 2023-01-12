package cc.chengheng;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class B_SimpleIntegerProperty extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        SimpleIntegerProperty sip = new SimpleIntegerProperty(5);
        // 主要有监听
        sip.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("修改");
            }
        });

        System.out.println(sip.get());
        sip.set(10);
        System.out.println(sip.get());



        AnchorPane an = new AnchorPane();



        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();



    }

    private class Student {
        private String name;
        private int age;
        // 监听bean属性改变
        public PropertyChangeSupport psc = new PropertyChangeSupport(this);

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            String oldValue = this.name;
            this.name = name;
            // 会发生通知
            psc.firePropertyChange("setName_pro", oldValue, this.name);
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            int oldValue = this.age;
            this.age = age;
            psc.firePropertyChange("setName_pro", oldValue, this.age);
        }
    }
}
