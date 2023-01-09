package cc.chengheng.gridpane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.IOException;

public class GridPane extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GridPane.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);


        javafx.scene.layout.GridPane gridPane = new javafx.scene.layout.GridPane();
        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHalignment(HPos.RIGHT);
        c1.setPrefWidth(100);
        ColumnConstraints c2 = new ColumnConstraints();
        c1.setPrefWidth(100);
        gridPane.getColumnConstraints().addAll(c1, c2);

        RowConstraints r1 = new RowConstraints();
        r1.setPrefHeight(30);
        RowConstraints r2 = new RowConstraints();
        r2.setPrefHeight(30);
        gridPane.getRowConstraints().addAll(r1,r2);



        gridPane.setGridLinesVisible(true);
        gridPane.add(new Label("Label1"), 0, 0, 2, 1);
        gridPane.add(new Label("Label2 is very long"), 1, 0, 2, 2);


        stage.setTitle("Hello!");
        stage.setScene(new Scene(gridPane, 300, 300));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}