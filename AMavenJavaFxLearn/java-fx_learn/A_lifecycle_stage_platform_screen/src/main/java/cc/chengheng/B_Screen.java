package cc.chengheng;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * 场景可以想像象一个电脑游戏。
 * 一个游戏可能有多个"屏幕"显示给用户。
 * 例如，初始菜单屏幕、主游戏屏幕（玩游戏的地方）、游戏结束屏幕和高分屏幕。
 * 这些屏幕中的每一个都可以由不同的场景表示。
 * 当游戏需要从一个屏幕切换到下一个屏幕时，它只需将相应的场景附加到JavaFX 应用程序的舞台（Stage）对象上
 */
public class B_Screen extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // 获取屏幕，当前的分辨率
        ObservableList<Screen> screens = Screen.getScreens();


        /*
         * [javafx.stage.Screen@3a9b832a bounds:Rectangle2D
         * [minX = 0.0, minY=0.0, maxX=1680.0, maxY=945.0, width=1680.0, height=945.0]
         * visualBounds:Rectangle2D [minX = 0.0, minY=25.0, maxX=1680.0, maxY=859.0, width=1680.0, height=834.0]
         * dpi:89.0 outputScale:(2.0,2.0)]
         */
        System.out.println(screens);


        // 获取主屏幕
        Screen sc = Screen.getPrimary();
        // 获取看到的
        Rectangle2D bounds = sc.getBounds();

        // 获取全部的包括看到的
        Rectangle2D visualBounds = sc.getVisualBounds();
        System.out.println(bounds);

        System.out.println(sc.getDpi());

    }

    public static void main(String[] args) {
        launch();
    }
}