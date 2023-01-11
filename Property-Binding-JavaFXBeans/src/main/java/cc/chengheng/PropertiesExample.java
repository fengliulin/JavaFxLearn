/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/11
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;

public class PropertiesExample {

    private static IntegerProperty i1;

    public static void main(String[] args) {
        createProperty();
        addAndRemoveInvalidationListener();
        addAndRemoveChangeListener();
        bindAndUnbindOnePropertyToAnother();
    }

    private static void createProperty() {
        System.out.println();
        i1 = new SimpleIntegerProperty(1024);
        System.out.println("i1 = " + i1);
        System.out.println("i1.get() = " + i1.get());
        System.out.println("i1.getValue() = " + i1.getValue());
    }

    public static void addAndRemoveInvalidationListener() {
        System.out.println();
        final InvalidationListener invalidationListener = observable -> {
            System.out.println("observable 的 invalidated: " + observable);
        };
        i1.addListener(invalidationListener);
        System.out.println("添加失效的监听");

        System.out.println("Calling i1.set(2048).");
        i1.set(2048);

        System.out.println("i1.setValue(3072).");
        i1.setValue(3072);

        i1.removeListener(invalidationListener);
        System.out.println("移除失效的监听");

        System.out.println("i1.set(4096).");
        i1.set(4096);

    }

    public static void addAndRemoveChangeListener() {
        System.out.println();
        final ChangeListener<Number> changeListener = (observable, oldValue, newValue) -> {
            System.out.println("observableValue 的 改变 oldValue" + oldValue + ",新值" + newValue);
        };
        i1.addListener(changeListener);
        System.out.println("添加改变的监听");

        System.out.println("Calling i1.set(5120).");
        i1.set(5120);


        i1.removeListener(changeListener);
        System.out.println("移除改变的监听");

        System.out.println("i1.setValue(6144).");
        i1.setValue(6144);
    }

    public static void bindAndUnbindOnePropertyToAnother() {
        System.out.println();
        SimpleIntegerProperty i2 = new SimpleIntegerProperty(0);
        System.out.println("i2.get() = " + i2.get());

        System.out.println("Binding i2 to i1.");
        i2.bind(i1);
        System.out.println("i2.get() = " + i2.get());

        System.out.println("Calling i1.set(7168).");
        i1.set(7168);
        System.out.println("i2.get() = " + i2.get());

        System.out.println("Unbinding i2 from i1.");
        i2.unbind();
        System.out.println("i2.get() = " + i2.get());

        System.out.println("Calling i1.set(8192).");
        i1.set(8192);
        System.out.println("i2.get() = " + i2.get());

    }
}

