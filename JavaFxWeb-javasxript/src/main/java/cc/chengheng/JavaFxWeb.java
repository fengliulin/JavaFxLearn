package cc.chengheng;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.concurrent.Worker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class JavaFxWeb extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.load("https://www.baidu.com");

        webView.setContextMenuEnabled(false);

        BorderPane borderPane = new BorderPane(webView);
        MenuBar menuBar = new MenuBar();
        Menu navigate = new Menu("Navigate");
        MenuItem home = new MenuItem("Home");
        navigate.getItems().add(home);

        home.setOnAction(event -> {
            engine.load("https://www.163.com");
        });

        // 浏览器导航条
        menuBar.getMenus().add(navigate);
        borderPane.setTop(menuBar);

        Menu history = new Menu("History");
        engine.getHistory().getEntries().addListener((ListChangeListener<? super WebHistory.Entry>) c -> {
            c.next();
            for (WebHistory.Entry entry : c.getAddedSubList()) {
                for (MenuItem item : history.getItems()) {
                    if (item.getId().equals(entry.getUrl())) {
                        history.getItems().remove(item);
                    }
                }
            }

            for (WebHistory.Entry e : c.getAddedSubList()) {
                final MenuItem menuItem = new MenuItem(e.getUrl());
                menuItem.setId(e.getUrl());
                menuItem.setOnAction(a -> engine.load(e.getUrl()));
                history.getItems().add(menuItem);
            }
        });

        menuBar.getMenus().add(history);


        // 显示进度条
        ProgressBar progressBar = new ProgressBar();
        progressBar.progressProperty().bind(engine.getLoadWorker().progressProperty());
        progressBar.visibleProperty().bind(engine.getLoadWorker().stateProperty().isEqualTo(Worker.State.RUNNING));
        borderPane.setBottom(progressBar);


        Scene scene = new Scene(borderPane, 500, 500);


        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }
}