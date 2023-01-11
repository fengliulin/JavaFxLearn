package cc.chengheng.JavaFxBean;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.adapter.JavaBeanStringProperty;
import javafx.beans.property.adapter.JavaBeanStringPropertyBuilder;

import java.beans.PropertyVetoException;

public class JavaBeanPropertiesExample {
    public static void main(String[] args) throws NoSuchMethodException {
        adaptJavaBeansProperty();
        adaptBoundProperty();
        adaptConstrainedProperty();
    }

    private static void adaptJavaBeansProperty() throws NoSuchMethodException {
        Person person = new Person();
        JavaBeanStringProperty nameProperty =
                JavaBeanStringPropertyBuilder.create()
                        .bean(person)
                        .name("name")
                        .build();

        nameProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("JavaFX property " +
                    observable + " changed:");
            System.out.println("\toldValue = " +
                    oldValue + ", newValue = " + newValue);
        });


        person.setName("Weiqi Gao");

        nameProperty.fireValueChangedEvent();
        System.out.println("nameProperty.get() = " + nameProperty.get());

        nameProperty.set("Johan Vos");

        System.out.println("person.getName() = " + person.getName());
    }

    private static void adaptBoundProperty() throws NoSuchMethodException {
        System.out.println();
        Person person = new Person();
        JavaBeanStringProperty addressProperty =
                JavaBeanStringPropertyBuilder.create()
                        .bean(person)
                        .name("address")
                        .build();

        addressProperty.addListener((observable, oldValue, newValue) -> {
            System.out.println("JavaFX property " +
                    observable + " changed:");
            System.out.println("\toldValue = " +
                    oldValue + ", newValue = " + newValue);
        });


        person.setAddress("12345 main Street");
    }

    private static void adaptConstrainedProperty() throws NoSuchMethodException {
        System.out.println();
        Person person = new Person();

        JavaBeanStringProperty phoneNumberProperty =
                JavaBeanStringPropertyBuilder.create()
                        .bean(person)
                        .name("phoneNumber")
                        .build();

        phoneNumberProperty.addListener((observable,
                                         oldValue, newValue) -> {
            System.out.println("JavaFX property " +
                    observable + " changed:");
            System.out.println("\toldValue = " +
                    oldValue + ", newValue = " + newValue);
        });



//        try {
//            person.setPhoneNumber("800-555-1212");
//        } catch (PropertyVetoException e) {
//            System.out.println("A JavaBeans property" +
//                    " change is vetoed.");
//        }

//        SimpleStringProperty stringProperty = new SimpleStringProperty("866-555-1212");
//        phoneNumberProperty.bind(stringProperty);

        try {
            person.setPhoneNumber("888-555-1212");
        } catch (PropertyVetoException e) {
            System.out.println("A JavaBeans property" +
                    " change is vetoed.");
        }
    }
}