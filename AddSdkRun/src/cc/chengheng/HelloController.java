/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/9
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController {
    public void myShapes_OnAction(ActionEvent actionEvent) {
        // 创建一个椭圆
        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(Color.LIGHTBLUE);

        Text text = new Text("My Shapes");
        text.setFont(new Font("Arial Bold", 24d));

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(ellipse, text);

//        Scene scene = new Scene(stackPane, 350, 230, Color.LIGHTYELLOW);

        ellipse.setCenterX(175);
        ellipse.setCenterY(115);

        text.setX(175-(text.getLayoutBounds().getWidth() / 2));
        text.setY(115+(text.getLayoutBounds().getHeight() / 2));
        Group group = new Group(ellipse, text);
        Scene scene = new Scene(group, 350, 230, Color.LIGHTYELLOW);

        Stage stage = new Stage();
        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();


    }
}

