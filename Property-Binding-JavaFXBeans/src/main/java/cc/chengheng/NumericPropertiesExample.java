/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/11
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.beans.property.*;

public class NumericPropertiesExample {
    public static void main(String[] args) {
        IntegerProperty i = new SimpleIntegerProperty(null, "i", 1024);
        LongProperty l = new SimpleLongProperty(null, "l", 0L);
        FloatProperty f = new SimpleFloatProperty(null, "f", 0.0f);
        DoubleProperty d = new SimpleDoubleProperty(null, "d", 0.0);

        System.out.println("i.get() = " + i.get());
        System.out.println("l.get() = " + l.get());
        System.out.println("f.get() = " + f.get());
        System.out.println("d.get() = " + d.get());

        l.bind(i);
        f.bind(l);
        d.bind(f);

        System.out.println("Bound l to i, f to l, d to f.");
        System.out.println("i.get() = " + i.get());
        System.out.println("l.get() = " + l.get());
        System.out.println("f.get() = " + f.get());
        System.out.println("d.get() = " + d.get());
        System.out.println("Calling i.set(2048).");

        i.set(2048);
        System.out.println("i.get() = " + i.get());
        System.out.println("l.get() = " + l.get());
        System.out.println("f.get() = " + f.get());
        System.out.println("d.get() = " + d.get());

        System.out.println("Unbound l to i, f to l, d to f.");
        d.unbind();
        f.unbind();
        l.unbind();



        f.bind(d);
        l.bind(f);
        i.bind(l);

        System.out.println("Bound f to d, l to f, i to l.");
        System.out.println("Calling d.set(10000000000L).");
        d.set(10000000000L);

        System.out.println("d.get() = " + d.get());
        System.out.println("f.get() = " + f.get());
        System.out.println("l.get() = " + l.get());
        System.out.println("i.get() = " + i.get());
    }
}

