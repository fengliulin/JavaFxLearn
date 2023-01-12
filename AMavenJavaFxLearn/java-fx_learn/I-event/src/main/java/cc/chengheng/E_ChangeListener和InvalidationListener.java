package cc.chengheng;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Start Date: 2021/11/4
 * Author: 冯镠霖(fengliulin)
 */
public class E_ChangeListener和InvalidationListener {
    public static void main(String[] args) {
        SimpleIntegerProperty sip = new SimpleIntegerProperty();

        // 更改监听
        sip.addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                System.out.println("更改监听");
            }
        });

        // 失效监听
        sip.addListener(new InvalidationListener() {
            /**
             *
             * @param observable SimpleIntegerProperty的对象
             */
            @Override
            public void invalidated(Observable observable) {
                System.out.println("失效监听");
            }
        });

        sip.set(2);
        sip.set(3);
        sip.set(4);

        sip.get();
    }
}
