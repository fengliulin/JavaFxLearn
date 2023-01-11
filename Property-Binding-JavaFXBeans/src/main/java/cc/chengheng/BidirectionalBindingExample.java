/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/11
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class BidirectionalBindingExample {
    public static void main(String[] args) {
        System.out.println("构建2个 StringProperty");
        StringProperty prop1 = new SimpleStringProperty("");
        StringProperty prop2 = new SimpleStringProperty("");

        System.out.println("双向绑定");
        prop2.bindBidirectional(prop1);

        System.out.println("prop1.isBound = " + prop1.isBound());
        System.out.println("prop2.isBound = " + prop2.isBound());

        System.out.println("prop1.set(\"prop1 says: Hi!\")");
        prop1.set("prop1 says: Hi!");

        System.out.println("prop2.get() returned:");
        System.out.println(prop2.get());

        System.out.println("pro2.set(prop2.set() + \"\nprop2 says: Bye!\")");
        prop2.set(prop2.get() + "prop2 says: Bye!");

        System.out.println("prop1.get() returned");
        System.out.println(prop1.get());
    }
}

