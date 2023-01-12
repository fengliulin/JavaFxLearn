package cc.chengheng.BuilderFactory_读取FXMl自定的标签属性;

import javafx.fxml.JavaFXBuilderFactory;
import javafx.util.Builder;
import javafx.util.BuilderFactory;

/**
 * Start Date: 2021/10/26
 * Author: 冯镠霖(fengliulin)
 */
public class PersonBuilderFactory implements BuilderFactory {

    private final JavaFXBuilderFactory jff= new JavaFXBuilderFactory();

    @Override
    public Builder<?> getBuilder(Class<?> type) {
        if (type == Person.class) {
            return new PersonBuilder();
        } else {
            return jff.getBuilder(type);
        }
    }
}
