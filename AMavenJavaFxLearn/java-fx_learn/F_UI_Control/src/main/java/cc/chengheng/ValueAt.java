package cc.chengheng;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class ValueAt {
    public static void main(String[] args) {
        ObservableMap<Object, Object> obsmap = FXCollections.observableHashMap();
        SimpleMapProperty<Object, Object> map = new SimpleMapProperty<>(obsmap);
        map.put("A", "1");
        map.put("B", "2");

        ObjectBinding<Object> a = map.valueAt("A");
        System.out.println(a.get());
        map.put("A", "R");
        System.out.println(a.get());
    }
}
