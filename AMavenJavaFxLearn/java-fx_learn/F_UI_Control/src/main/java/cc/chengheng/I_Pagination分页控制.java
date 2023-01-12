package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Pagination;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;

/**
 * Start Date: 2021/10/25
 * Author: 冯镠霖(fengliulin)
 */
public class I_Pagination分页控制 extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {


        AnchorPane ap = new AnchorPane();

        Pagination pagination = new Pagination();
        pagination.setPrefWidth(200);
        pagination.setMinHeight(200);
        pagination.setStyle("-fx-background-color: #ffff55");

        pagination.setPageCount(200);
        pagination.setMaxPageIndicatorCount(5);

        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer param) {
                return new Button();
            }
        });

        ap.getChildren().addAll(pagination);

        //=======================================================
        Scene scene = new Scene(ap);
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
