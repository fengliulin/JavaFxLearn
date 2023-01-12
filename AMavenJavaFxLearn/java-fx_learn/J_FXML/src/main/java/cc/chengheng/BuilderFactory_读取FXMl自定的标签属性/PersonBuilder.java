package cc.chengheng.BuilderFactory_读取FXMl自定的标签属性;

import javafx.util.Builder;

/**
 * 构造对象
 *
 * Start Date: 2021/10/26
 * Author: 冯镠霖(fengliulin)
 */
public class PersonBuilder implements Builder<Person> {

    // 要给getter setter， 反射通过赋值的， 然后在 build 构建对象
    private String name;
    private int age;

    @Override
    public Person build() {
        return new Person(name, age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
