/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/13
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class RegisteringJavaCallbacks extends Application {
    ValuePrinter value = new ValuePrinter();
    @Override
    public void start(Stage primaryStage) throws Exception {
        final WebView webView = new WebView();
        final WebEngine engine = webView.getEngine();
        engine.load(RegisteringJavaCallbacks.class.getResource("/RegisteringJavaCallbacks.html").toExternalForm());



        engine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.equals(Worker.State.SUCCEEDED)) {
                JSObject win
                        = (JSObject) engine.executeScript("window");

//                    script.setMember("formValues", new ValuePrinter());

                // 调用java类， 有重载方法会失败
                win.setMember("formValues", new ValuePrinter());

//                engine.executeScript("changeText()");// 直接执行html中的js脚本
            }

        });


        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(webView);

        Scene scene = new Scene(stackPane, 600, 250);
        primaryStage.setTitle("JavaFX WebView Callback Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class ValuePrinter {
        public void print(String name) {
            System.out.println("value " + name);
        }


        @Override
        public String toString() {
            return "super.toString()";
        }
    }
}

