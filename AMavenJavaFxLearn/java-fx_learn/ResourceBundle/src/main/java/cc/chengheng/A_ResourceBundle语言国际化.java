package cc.chengheng;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

public class A_ResourceBundle语言国际化 extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Locale locale = Locale.getDefault();
        System.out.println(locale.getLanguage());
        System.out.println(locale.getCountry());

        Locale.setDefault(new Locale("en", "us"));

        FXMLLoader fxmlLoader = new FXMLLoader(A_ResourceBundle语言国际化.class.getResource("/AFXML.fxml"));


        // 自动找
        ResourceBundle bundle = ResourceBundle.getBundle("language");

        fxmlLoader.setResources(bundle);

        AnchorPane root = fxmlLoader.load();





        Scene scene = new Scene(root, 320, 240);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }
}
