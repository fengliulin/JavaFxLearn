package cc.chengheng.BuilderFactory_读取FXMl自定的标签属性;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * Start Date: 2021/10/26
 * Author: 冯镠霖(fengliulin)
 */
public class BuilderFactory extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL resource = BuilderFactory.class.getResource("/Builder_BuilderFactory/Data.fxml");
        FXMLLoader fl = new FXMLLoader();

        String decode = URLDecoder.decode(resource.toExternalForm(), StandardCharsets.UTF_8);

        fl.setLocation(URI.create(decode).toURL());

        fl.setBuilderFactory(new PersonBuilderFactory());


        Person person = fl.load();

        person.setName("你好");
        System.out.println(person);
    }
}
