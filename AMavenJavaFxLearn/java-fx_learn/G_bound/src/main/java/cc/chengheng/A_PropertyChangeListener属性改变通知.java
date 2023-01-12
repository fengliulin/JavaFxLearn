package cc.chengheng;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class A_PropertyChangeListener属性改变通知 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Student s1 = new Student("张三1", 1);

        AnchorPane an = new AnchorPane();



        Scene scene = new Scene(an);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();



        // 注册监听
        s1.psc.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(evt.getNewValue());
            }
        });

        s1.setName("栈");
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
