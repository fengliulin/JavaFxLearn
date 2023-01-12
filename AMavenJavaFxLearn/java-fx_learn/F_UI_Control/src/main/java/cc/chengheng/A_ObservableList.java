package cc.chengheng;

import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

import java.util.Collection;

public class A_ObservableList {
    public static void main(String[] args) {
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        FXCollections.rotate(list, 2);

        list.forEach(System.out::println);

        SimpleStringProperty s1 = new SimpleStringProperty("a");
        SimpleStringProperty s2 = new SimpleStringProperty("b");
        ObservableList<Object> list1 = FXCollections.observableArrayList(new Callback<Object, Observable[]>() {
            @Override
            public Observable[] call(Object param) {
                System.out.println(param);
                return new Observable[0];
            }
        });

        list1.add("D");
    }
}
