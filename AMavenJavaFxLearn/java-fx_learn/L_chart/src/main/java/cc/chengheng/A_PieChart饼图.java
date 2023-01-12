package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.robot.Robot;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.function.Consumer;

/**
 * Start Date: 2021/10/27
 * Author: 冯镠霖(fengliulin)
 */
public class A_PieChart饼图 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        PieChart.Data d1 = new PieChart.Data("data1", 40);
        PieChart.Data d2 = new PieChart.Data("data2", 10);
        PieChart.Data d3 = new PieChart.Data("data3", 10);
        PieChart.Data d4 = new PieChart.Data("data4", 20);
        PieChart.Data d5 = new PieChart.Data("data5", 20);

        ObservableList<PieChart.Data> dataList = FXCollections.observableArrayList();
        dataList.add(d1);
        dataList.add(d2);
        dataList.add(d3);
        dataList.add(d4);
        dataList.add(d5);

        PieChart pieChart = new PieChart(dataList);
//        pieChart.setLabelLineLength(100); // 设置线的长度
        pieChart.setPrefWidth(400);
        pieChart.setPrefHeight(400);
        pieChart.setStartAngle(90);
        pieChart.setLabelsVisible(true);


//        pieChart.setClockwise(false);
//
//        pieChart.setLegendVisible(false);
//
//        pieChart.setTitle("这是标题");
//
        pieChart.setLegendSide(Side.RIGHT);

        pieChart.setAnimated(true); // 设置动画



        // 鼠标放上数据区域，提示
        pieChart.getData().forEach(new Consumer<PieChart.Data>() {
            @Override
            public void accept(PieChart.Data data) {
                Node node = data.getNode();
                Tooltip tooltip = new Tooltip(Double.toString(data.getPieValue()));

                tooltip.setFont(new Font(20));

                // 节点关联
                Tooltip.install(node, tooltip);

                data.pieValueProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        System.out.println(
                        );
                    }
                });
            }
        });


        Button button = new Button("button");

        AnchorPane root = new AnchorPane();
        root.setPrefWidth(600);
        root.setPrefHeight(600);
        root.setStyle("-fx-background-color: #ffb5c5");

        root.getChildren().addAll(button, pieChart);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(600);
        primaryStage.setWidth(600);
        primaryStage.show();
    }
}
