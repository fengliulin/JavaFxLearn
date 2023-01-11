/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/11
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class DirectExtensionExample {
    public static void main(String[] args) {
        DoubleProperty x = new SimpleDoubleProperty(null, "x", 2.0);
        DoubleProperty y = new SimpleDoubleProperty(null, "y", 3.0);

        DoubleBinding area = new DoubleBinding() {
            {
                super.bind(x, y);
            }
            @Override
            protected double computeValue() {
                return x.get() * y.get();
            }
        };

        System.out.println("area.get() = " + area.get());

        x.set(5);
        y.set(7);
        System.out.println("area.get() = " + area.get());
    }
}

