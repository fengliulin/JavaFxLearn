package cc.chengheng;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Start Date: 2021/10/27
 * Author: 冯镠霖(fengliulin)
 */
public class E_ScatterChart散点图 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ScatterChart<String, Number> scatterChart = getView();

        AnchorPane root = new AnchorPane();
        root.setPrefWidth(600);
        root.setPrefHeight(600);
        root.setStyle("-fx-background-color: #ffb5c5");

        root.getChildren().addAll(scatterChart);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(600);
        primaryStage.setWidth(600);
        primaryStage.show();
    }

    public ScatterChart<String, Number> getView() {
        CategoryAxis x = new CategoryAxis(); // 类别
        x.setLabel("x轴");
        NumberAxis y = new NumberAxis("y轴", 0, 100,10);

        XYChart.Series<String, Number> xy1 = new XYChart.Series<>();
        xy1.setName("xy1");

        XYChart.Series<String, Number> xy2 = new XYChart.Series<>();
        xy2.setName("xy2");

        XYChart.Series<String, Number> xy3 = new XYChart.Series<>();
        xy3.setName("xy3");

        XYChart.Data<String, Number> d1 = new XYChart.Data<>("一", 10);
        XYChart.Data<String, Number> d2 = new XYChart.Data<>("二", 20);
        XYChart.Data<String, Number> d3 = new XYChart.Data<>("三", 30);
        XYChart.Data<String, Number> d4 = new XYChart.Data<>("四", 40);

        XYChart.Data<String, Number> d5 = new XYChart.Data<>("一", 25);
        XYChart.Data<String, Number> d6 = new XYChart.Data<>("二", 90);
        XYChart.Data<String, Number> d7 = new XYChart.Data<>("三", 30);
        XYChart.Data<String, Number> d8 = new XYChart.Data<>("四", 80);

        XYChart.Data<String, Number> d9 = new XYChart.Data<>("五", 50);

        // 系列数据1
        xy1.getData().add(d1);
        xy1.getData().add(d2);
        xy1.getData().add(d3);
        xy1.getData().add(d4);

        // 系列数据2
        xy2.getData().add(d5);
        xy2.getData().add(d6);
        xy2.getData().add(d7);
        xy2.getData().add(d8);

        xy3.getData().add(d9);

        ScatterChart<String, Number> scatterChart = new ScatterChart<>(x, y);
        scatterChart.getData().add(xy1);
        scatterChart.getData().add(xy2);
        scatterChart.getData().add(xy3);
        scatterChart.setTitle("散点图");

        return scatterChart;
    }
}
