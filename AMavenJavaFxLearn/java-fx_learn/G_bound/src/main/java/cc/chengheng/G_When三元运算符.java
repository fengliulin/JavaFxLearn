package cc.chengheng;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.When;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class G_When三元运算符 {
    public static void main(String[] args) {

        SimpleIntegerProperty s = new SimpleIntegerProperty(1);
        BooleanBinding booleanBinding = s.greaterThan(10);
        SimpleBooleanProperty sbp = new SimpleBooleanProperty(true);

        When when = new When(sbp);
        // 如果sbp是真就 给 10,  如果为假就给20
        NumberBinding otherwise = when.then(10).otherwise(20);
        System.out.println(otherwise.doubleValue());
    }
}
