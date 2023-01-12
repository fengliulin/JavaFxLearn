package cc.chengheng;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Start Date: 2021/11/4
 * Author: 冯镠霖(fengliulin)
 */
public class H单项绑定和双向绑定 {
    public static void main(String[] args) {
        ObservableList<Object> obsList1 = FXCollections.observableArrayList();
        SimpleListProperty<Object> list1 = new SimpleListProperty<>(obsList1);
        list1.add("A");
        list1.add("B");

        ObservableList<Object> obsList2 = FXCollections.observableArrayList();
        SimpleListProperty<Object> list2 = new SimpleListProperty<>(obsList2);
        list2.add("C");
        list2.add("D");

        System.out.println(list1.getValue());

       /* // list1 指向的是obsList2的数据
        list1.bind(list2);

        list1.add("E");

        System.out.println(list1.getValue());*/

        /*list2.add("冯镠霖");
        list1.bindContent(list2);  // 把list2的数据绑定到list1里, list2数据添加，  list1自动更新,  list1不会影响list2


        list2.add("dfdfd");

        list1.add("我是list1");

        System.out.println(list1);*/


//        list1.bindBidirectional(); // 双向绑定

//        list1.bindContentBidirectional(); // 内容双向绑定


        // 双向绑定
        SimpleIntegerProperty a = new SimpleIntegerProperty(3);
        SimpleIntegerProperty b = new SimpleIntegerProperty(3);

        a.bindBidirectional(b);

        a.set(2);
        b.set(3);

        System.out.println(a);
        System.out.println(b);

        a.unbindBidirectional(b);

    }
}
