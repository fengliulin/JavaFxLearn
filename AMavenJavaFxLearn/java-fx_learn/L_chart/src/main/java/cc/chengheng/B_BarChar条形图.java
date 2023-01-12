package cc.chengheng;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.function.Consumer;

/**
 * Start Date: 2021/10/27
 * Author: 冯镠霖(fengliulin)
 */
public class B_BarChar条形图 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

//        BarChart<String, Number> barChart1 = getView1();
        BarChart<String, Number> barChart2 = getView2();
        BarChart<String, Number> barChart3 = getView3();
        /*BarChart<Number, String> barChart4 = getView4();*/
//        barChart2.setLayoutY(300);


//        barChart1.setAnimated(true);
////        barChart1.setLegendSide(Side.LEFT);
//        barChart1.setTitleSide(Side.RIGHT);

//        barChart1.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT); // 设置方向
//        barChart1.setBarGap(50); // 设置条的间隙
//        barChart1.setCategoryGap(50);


        Button button = new Button("button");

        AnchorPane root = new AnchorPane();
        root.setPrefWidth(600);
        root.setPrefHeight(600);
        root.setStyle("-fx-background-color: #ffb5c5");

        root.getChildren().addAll(/*barChart1, barChart2,*/ barChart3);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(600);
        primaryStage.setWidth(600);
        primaryStage.show();
    }

    public BarChart<String, Number> getView1() {
        CategoryAxis x = new CategoryAxis();
        x.setLabel("国家");

//        x.setStartMargin(30);// 距离左边边缘的距离
//        x.setGapStartAndEnd(true); // 前后留空间

        x.setSide(Side.BOTTOM); // 轴位置
        x.setTickLabelFill(Paint.valueOf("#ff55ff")); //设置轴刻度标签颜色
//        x.setTickLabelGap(20); // 轴刻度间距
        x.setTickLabelRotation(20); // 轴刻度标签旋转
//        x.setTickLabelsVisible(false); // 轴刻度标签是否显示
//        x.setTickLength(100); // 刻度长度
//        x.setTickMarkVisible(false); // 是否显示刻度


        NumberAxis y = new NumberAxis();
        y.setLabel("生产总值");

        // 数据
        ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();
        XYChart.Data<String, Number> d1 = new XYChart.Data<>("中国1", 81);
        XYChart.Data<String, Number> d2 = new XYChart.Data<>("中国2", 82);
        XYChart.Data<String, Number> d3 = new XYChart.Data<>("中国3", 20);
        data.add(d1);
        data.add(d2);
        data.add(d3);


        XYChart.Series<String, Number> xy = new XYChart.Series<>();
        xy.setData(data);
        xy.setName("生产总值");

        ObservableList<XYChart.Series<String, Number>> list = FXCollections.observableArrayList();
        list.add(xy);
        BarChart<String, Number> barChart = new BarChart<>(x, y, list);
        barChart.setTitle("第一种方式");
        return barChart;
    }

    public BarChart<String, Number> getView2() {
        CategoryAxis x = new CategoryAxis();
        x.setLabel("国家");

        NumberAxis y = new NumberAxis();
        y.setLabel("生产总值");



        // 数据
        ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();
        XYChart.Data<String, Number> d1 = new XYChart.Data<>("GDP", 81);
        XYChart.Data<String, Number> d2 = new XYChart.Data<>("GDP", 82);
        XYChart.Data<String, Number> d3 = new XYChart.Data<>("GDP", 20);

        XYChart.Data<String, Number> d4 = new XYChart.Data<>("GNP", 10);
        XYChart.Data<String, Number> d5 = new XYChart.Data<>("GNP", 30);
        XYChart.Data<String, Number> d6 = new XYChart.Data<>("GNP", 20);

        data.add(d1);
        data.add(d2);
        data.add(d3);

        // 系列
        XYChart.Series<String, Number> xy1 = new XYChart.Series<>();
        xy1.setName("中国");

        XYChart.Series<String, Number> xy2 = new XYChart.Series<>();
        xy2.setName("美国");

        XYChart.Series<String, Number> xy3 = new XYChart.Series<>();
        xy3.setName("日本");

        // xy1.getData()给你创建好了，直接添加
        xy1.getData().add(d1);
        xy1.getData().add(d4);

        xy2.getData().add(d2);
        xy2.getData().add(d5);

        xy3.getData().add(d3);
        xy3.getData().add(d6);

        BarChart<String, Number> barChart = new BarChart<>(x, y);
        barChart.getData().add(xy1);
        barChart.getData().add(xy2);
        barChart.getData().add(xy3);

        barChart.setTitle("第二种方式");

        return barChart;
    }

    public BarChart<String, Number> getView3() {
        CategoryAxis x = new CategoryAxis();
        x.setLabel("国家");

        NumberAxis y = new NumberAxis();
        y.setLabel("生产总值");



        // 控制数据区域
        ObservableList<XYChart.Data<String, Number>> data = FXCollections.observableArrayList();
        XYChart.Data<String, Number> d1 = new XYChart.Data<>("中国", 81);
        XYChart.Data<String, Number> d2 = new XYChart.Data<>("美国", 82);
        XYChart.Data<String, Number> d3 = new XYChart.Data<>("日本", 20);

        XYChart.Data<String, Number> d4 = new XYChart.Data<>("中国", 10);
        XYChart.Data<String, Number> d5 = new XYChart.Data<>("美国", 30);
        XYChart.Data<String, Number> d6 = new XYChart.Data<>("日本", 20);

        data.add(d1);
        data.add(d2);
        data.add(d3);

//        d1.setExtraValue("Df");

        // 系列
        XYChart.Series<String, Number> xy1 = new XYChart.Series<>();
        xy1.setName("GNP");

        XYChart.Series<String, Number> xy2 = new XYChart.Series<>();
        xy2.setName("GDP");


        // xy1.getData()给你创建好了，直接添加
        xy1.getData().add(d1);
        xy1.getData().add(d2);
        xy1.getData().add(d3);

        xy2.getData().add(d4);
        xy2.getData().add(d5);
        xy2.getData().add(d6);

        // 给数据区域上面放数字
        xy1.getData().forEach(new Consumer<XYChart.Data<String, Number>>() {
            @Override
            public void accept(XYChart.Data<String, Number> data) {
                HBox hBox = new HBox();
                hBox.setAlignment(Pos.CENTER);
                hBox.getChildren().add(new Label(String.valueOf(data.getYValue())));
                data.setNode(hBox);
                data.getNode().setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        System.out.println(data.getXValue());
                    }
                });
            }
        });

        BarChart<String, Number> barChart = new BarChart<>(x, y);
        barChart.getData().add(xy1);
        barChart.getData().add(xy2);

        barChart.setTitle("第三种方式");

        return barChart;
    }

    // 反转条形图
    public BarChart<Number, String> getView4() {
        CategoryAxis x = new CategoryAxis();
        x.setLabel("国家");

        NumberAxis y = new NumberAxis();
        y.setLabel("生产总值");



        // 控制数据区域
        ObservableList<XYChart.Data<Number, String>> data = FXCollections.observableArrayList();
        XYChart.Data<Number, String> d1 = new XYChart.Data<>(81,"中国" );
        XYChart.Data<Number, String> d2 = new XYChart.Data<>(82,"美国" );
        XYChart.Data<Number, String> d3 = new XYChart.Data<>(20,"日本" );

        XYChart.Data<Number, String> d4 = new XYChart.Data<>(10,"中国" );
        XYChart.Data<Number, String> d5 = new XYChart.Data<>(30,"美国" );
        XYChart.Data<Number, String> d6 = new XYChart.Data<>(20,"日本" );

        data.add(d1);
        data.add(d2);
        data.add(d3);

        // 系列
        XYChart.Series<Number, String> xy1 = new XYChart.Series<>();
        xy1.setName("GNP");

        XYChart.Series<Number, String> xy2 = new XYChart.Series<>();
        xy2.setName("GDP");


        // xy1.getData()给你创建好了，直接添加
        xy1.getData().add(d1);
        xy1.getData().add(d2);
        xy1.getData().add(d3);

        xy2.getData().add(d4);
        xy2.getData().add(d5);
        xy2.getData().add(d6);


        BarChart<Number, String> barChart = new BarChart<>(y, x);
        barChart.getData().add(xy1);
        barChart.getData().add(xy2);

        barChart.setTitle("第四种方式");

        return barChart;
    }
}
