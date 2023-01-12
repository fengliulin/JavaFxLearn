package cc.chengheng;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.stage.Stage;

import java.io.IOException;

public class D_KeyboardKeys_添加快捷键 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {

        Button button1 = new Button("b1");

        button1.setLayoutX(0);
        button1.setLayoutY(0);

        // 设置键盘事件
        button1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().getName().equals(KeyCode.A.getName())) {
                    System.out.println("按下");
                    System.out.println(event.getCode().name());
                }
            }
        });

        button1.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("释放");
            }
        });

        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("按钮绑定了快捷键，按下快捷键");
            }
        });


        Group group = new Group();
        group.getChildren().addAll(button1);
        Scene scene = new Scene(group);

        // 在场景，才可以设置快捷键
        // 第一种
        // mac 下的Command META_DOWN
        KeyCodeCombination codeCombination = new KeyCodeCombination(KeyCode.C, KeyCombination.META_DOWN, KeyCombination.ALT_DOWN);
        Mnemonic mnemonic = new Mnemonic(button1, codeCombination);
        scene.addMnemonic(mnemonic);

        // 第二种
        KeyCodeCombination codeCombination1 = new KeyCodeCombination(KeyCode.V, KeyCombination.META_DOWN, KeyCombination.ALT_DOWN);
        scene.getAccelerators().put(codeCombination1, new Runnable() {
            @Override
            public void run() {
                // 还是当前的线程，可以设置一些组件的属性啊，通过快界面执行这里
                System.out.println(Thread.currentThread().getName());
            }
        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}