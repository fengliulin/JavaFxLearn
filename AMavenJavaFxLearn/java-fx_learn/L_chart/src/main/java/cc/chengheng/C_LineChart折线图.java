package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * Start Date: 2021/10/27
 * Author: 冯镠霖(fengliulin)
 */
public class C_LineChart折线图 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        LineChart<Number, Number> lineChart1 = getView1();
        LineChart<String, Number> lineChart2 = getView2();
        LineChart<Number, String> lineChart3 = getView3();

        Button button = new Button("button");

        AnchorPane root = new AnchorPane();
        root.setPrefWidth(600);
        root.setPrefHeight(600);
        root.setStyle("-fx-background-color: #ffb5c5");

        root.getChildren().addAll(lineChart3);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(600);
        primaryStage.setWidth(600);
        primaryStage.show();
    }

    public LineChart<Number, Number> getView1() {
        NumberAxis x = new NumberAxis("x轴", 0, 100,10);
        NumberAxis y = new NumberAxis("y轴", 0, 100,10);

        // 就是颜色
        XYChart.Series<Number, Number> xy1 = new XYChart.Series<>();
        xy1.setName("xy1");

        XYChart.Series<Number, Number> xy2 = new XYChart.Series<>();
        xy2.setName("xy2");

        XYChart.Data<Number, Number> d1 = new XYChart.Data<>(10, 10);
        XYChart.Data<Number, Number> d2 = new XYChart.Data<>(10, 20);
        XYChart.Data<Number, Number> d3 = new XYChart.Data<>(10, 30);
        XYChart.Data<Number, Number> d4 = new XYChart.Data<>(10, 40);

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

        LineChart<Number, Number> lineChart = new LineChart<>(x, y);
        lineChart.getData().add(xy1);
        lineChart.getData().add(xy2);

//        lineChart.setCreateSymbols(false); // 控制点

        return lineChart;
    }

    public LineChart<String, Number> getView2() {
        CategoryAxis x = new CategoryAxis();
        NumberAxis y = new NumberAxis("y轴", 0, 100,10);

        // 就是颜色
        XYChart.Series<String, Number> xy1 = new XYChart.Series<>();
        xy1.setName("xy1");

        XYChart.Series<String, Number> xy2 = new XYChart.Series<>();
        xy2.setName("xy2");

        XYChart.Data<String, Number> d1 = new XYChart.Data<>("一", 10);
        XYChart.Data<String, Number> d2 = new XYChart.Data<>("二", 20);
        XYChart.Data<String, Number> d3 = new XYChart.Data<>("三", 30);
        XYChart.Data<String, Number> d4 = new XYChart.Data<>("四", 40);

        XYChart.Data<String, Number> d5 = new XYChart.Data<>("一", 25);
        XYChart.Data<String, Number> d6 = new XYChart.Data<>("二", 90);
        XYChart.Data<String, Number> d7 = new XYChart.Data<>("三", 30);
        XYChart.Data<String, Number> d8 = new XYChart.Data<>("四", 80);

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

        LineChart<String, Number> lineChart = new LineChart<>(x, y);
        lineChart.getData().add(xy1);
        lineChart.getData().add(xy2);

//        lineChart.setCreateSymbols(false); // 控制点

        return lineChart;
    }

    public LineChart<Number, String> getView3() {
        CategoryAxis y = new CategoryAxis();
        NumberAxis x = new NumberAxis("x轴", 0, 100,10);

        // 就是颜色
        XYChart.Series<Number, String> xy1 = new XYChart.Series<>();
        xy1.setName("xy1");

        XYChart.Series<Number, String> xy2 = new XYChart.Series<>();
        xy2.setName("xy2");

        XYChart.Data<Number, String> d1 = new XYChart.Data<>(10, "一");
        XYChart.Data<Number, String> d2 = new XYChart.Data<>(10, "二");
        XYChart.Data<Number, String> d3 = new XYChart.Data<>(10, "三");
        XYChart.Data<Number, String> d4 = new XYChart.Data<>(10, "四");

        XYChart.Data<Number, String> d5 = new XYChart.Data<>(24, "一");
        XYChart.Data<Number, String> d6 = new XYChart.Data<>(16, "二");
        XYChart.Data<Number, String> d7 = new XYChart.Data<>(80, "三");
        XYChart.Data<Number, String> d8 = new XYChart.Data<>(90, "四");

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

        // 设置鼠标放到圆点上显示Tooltip
        xy1.getData().forEach(new Consumer<XYChart.Data<Number, String>>() {
            @Override
            public void accept(XYChart.Data<Number, String> data) {
                HBox hBox = new HBox();
                data.setNode(hBox);
                Tooltip tip = new Tooltip(data.getXValue() + "-" + data.getYValue());
                Tooltip.install(data.getNode(), tip);

                data.getNode().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        System.out.println(data.getXValue());
                    }
                });
            }
        });

        LineChart<Number, String> lineChart = new LineChart<>(x, y);
        lineChart.getData().add(xy1);
        lineChart.getData().add(xy2);

//        lineChart.setCreateSymbols(false); // 控制点

        return lineChart;
    }
}
