package cc.chengheng.tilepane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;


    @FXML
    public void tilePane_OnAction(ActionEvent actionEvent) {
        javafx.scene.layout.TilePane tilePane = new javafx.scene.layout.TilePane();

        // 设置显示瓷砖面板的行和列，也就是显示方式
        tilePane.setPrefColumns(3);
        tilePane.setPrefRows(3);

        tilePane.setTileAlignment(Pos.CENTER);
        tilePane.setPrefTileHeight(100);
        tilePane.setPrefTileWidth(100);
        tilePane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        tilePane.setOrientation(Orientation.VERTICAL);

        // 3*3的超出会显示， 少会隐藏，
        tilePane.getChildren().addAll(
                new Rectangle(50, 50, Color.RED),
                new Rectangle(50, 50, Color.GREEN),
                new Rectangle(50, 50, Color.BLUE),
                new Rectangle(50, 50, Color.YELLOW),
                new Rectangle(50, 50, Color.CYAN),
                new Rectangle(50, 50, Color.PURPLE),
                new Rectangle(50, 50, Color.BROWN),
                new Rectangle(50, 50, Color.PINK),
                new Rectangle(50, 50, Color.ORANGE),
                new Rectangle(50, 50, Color.RED)
        );
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(new Scene(tilePane));
        stage.show();
    }


    @FXML
    public void tileUsage_OnAction(ActionEvent actionEvent) {
        javafx.scene.layout.TilePane tilePane = new javafx.scene.layout.TilePane();
        tilePane.setPrefColumns(2);
        tilePane.setPrefRows(2);
        tilePane.setTileAlignment(Pos.CENTER);

        Circle redCircle = new Circle(50, Color.RED);
        Circle greenCircle = new Circle(50, Color.GREEN);
        Circle blueCircle = new Circle(50, Color.BLUE);
        Circle yellowCircle = new Circle(50, Color.YELLOW);

        List<Circle> circles = new ArrayList<>();
        circles.add(redCircle);
        circles.add(greenCircle);
        circles.add(blueCircle);
        circles.add(yellowCircle);

        // 设置自定义属性"selected"
        circles.forEach(circle -> {
            circle.getProperties().put("selected", Boolean.FALSE);
        });

        tilePane.getChildren().addAll(circles);


        tilePane.setOnMouseClicked(event -> {
            tilePane.getChildren().stream().filter(node -> {
                // 场景
                Point2D point2D = new Point2D(event.getSceneX(), event.getSceneY());

                // 算法是， 圆是以半径，  场景的x- 半径  场景的y-半径
                Point2D localPoint = node.sceneToLocal(event.getSceneX(), event.getSceneY(), true);
                boolean contains = node.contains(localPoint);
                if (contains) {
                    node.sceneToLocal(event.getSceneX(), event.getSceneY(), true);
                    System.out.println();
                }
                return contains;
            }).findFirst().ifPresent(node -> {
                Boolean selected = (Boolean) node.getProperties().get("selected");
                if (selected == null || selected == Boolean.FALSE) {
                    node.setOpacity(0.3d);
                    node.getProperties().put("selected", Boolean.TRUE);
                } else {
                    node.setOpacity(1.0d);
                    node.getProperties().put("selected", Boolean.FALSE);
                }
            });
        });

        tilePane.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.S)) {
                Collections.shuffle(circles);
                tilePane.getChildren().clear();
                tilePane.getChildren().addAll(circles);
            }
        });
        Stage primaryStage = new Stage();
        primaryStage.setTitle("TileApp");
        primaryStage.setScene(new Scene(tilePane));
        primaryStage.show();
    }
}

















