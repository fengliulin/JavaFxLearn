package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * Start Date: 2021/10/27
 * Author: 冯镠霖(fengliulin)
 */
public class D_BubbleChart气泡图 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        BubbleChart<Number, Number> bubbleChart = getView();


        AnchorPane root = new AnchorPane();
        root.setPrefWidth(600);
        root.setPrefHeight(600);
        root.setStyle("-fx-background-color: #ffb5c5");

        root.getChildren().addAll(bubbleChart);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(600);
        primaryStage.setWidth(600);
        primaryStage.show();
    }

    public BubbleChart<Number, Number> getView() {
        NumberAxis x = new NumberAxis("x轴", 0, 100,10);
        NumberAxis y = new NumberAxis("y轴", 0, 100,10);

        XYChart.Series<Number, Number> xy1 = new XYChart.Series<>();
        xy1.setName("xy1");

        XYChart.Series<Number, Number> xy2 = new XYChart.Series<>();
        xy2.setName("xy2");

        XYChart.Data<Number, Number> d1 = new XYChart.Data<>(10, 10);
        XYChart.Data<Number, Number> d2 = new XYChart.Data<>(10, 20);
        XYChart.Data<Number, Number> d3 = new XYChart.Data<>(10, 30);
        XYChart.Data<Number, Number> d4 = new XYChart.Data<>(10, 40);

        // 额外数据
//        d1.setExtraValue(10); // 可以设置气泡大小，指的半径

        XYChart.Data<Number, Number> d5 = new XYChart.Data<>(24, 25);
        XYChart.Data<Number, Number> d6 = new XYChart.Data<>(16, 90);
        XYChart.Data<Number, Number> d7 = new XYChart.Data<>(80, 30);
        XYChart.Data<Number, Number> d8 = new XYChart.Data<>(90, 80);

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

        BubbleChart<Number, Number> bubbleChart = new BubbleChart<>(x, y);
        bubbleChart.getData().add(xy1);
        bubbleChart.getData().add(xy2);
        bubbleChart.setTitle("气泡图");

        return bubbleChart;
    }
}
