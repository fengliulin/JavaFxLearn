/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/11
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class 工厂方法的Bindings {
    public static void main(String[] args) {
        IntegerProperty x1 = new SimpleIntegerProperty(0);
        IntegerProperty y1 = new SimpleIntegerProperty(0);
        IntegerProperty x2 = new SimpleIntegerProperty(0);
        IntegerProperty y2 = new SimpleIntegerProperty(0);

        IntegerProperty x3 = new SimpleIntegerProperty(0);
        IntegerProperty y3 = new SimpleIntegerProperty(0);

        NumberBinding multiply = Bindings.multiply(x1, y1);

        x1.set(5);
        y1.set(6);

        System.out.println(multiply.getValue());

        Bindings.createDoubleBinding(() -> {
            return 1*2d;
        });


        NumberBinding numberBinding = x1.multiply(y1)
                .add(x1.multiply(y1))
                .divide(2);
//
//        StringExpression output = Bindings.format(
//                "For A(%d,%d), B(%d,%d), C(%d,%d)," +
//                        " the area of triangle ABC is %3.1f",
//                x1, y1, x2, y2, x3, y3, numberBinding);

        x1.set(4);
        y1.set(4);
        System.out.println(numberBinding.getValue());

    }
}

