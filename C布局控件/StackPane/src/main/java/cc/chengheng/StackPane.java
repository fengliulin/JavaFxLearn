/******************************************
 * ProjectName : 程衡服装进销存
 * Web         : www.chengheng.cc
 * Start Date  : ${DATE}
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class StackPane extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        AnchorPane anchorPane = new AnchorPane();
        // 创建一个椭圆
        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(Color.LIGHTBLUE);

        Text text = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24d));

        javafx.scene.layout.StackPane stackPane = new javafx.scene.layout.StackPane();
        stackPane.setPrefWidth(100);
        stackPane.setPrefHeight(200);
        stackPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
//        stackPane.setAlignment(Pos.TOP_RIGHT);

        stackPane.getChildren().addAll(ellipse, text);


        anchorPane.getChildren().add(stackPane);
        Scene scene = new Scene(anchorPane, 350, 230, Color.LIGHTYELLOW);

        Stage stage = new Stage();
        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}