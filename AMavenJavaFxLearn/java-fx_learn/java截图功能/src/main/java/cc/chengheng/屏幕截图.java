package cc.chengheng;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.robot.Robot;
import javafx.scene.transform.Shear;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Start Date: 2021/10/26
 * Author: 冯镠霖(fengliulin)
 */
public class 屏幕截图 extends Application {

    private ImageView imageView;
    private Stage primaryStage;
    private Stage stage;

    double startScreenX;
    double startScreenY;
    double endScreenX;
    double endScreenY;

    // 画截图区域
    private HBox hBoxView;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;

        Button bu = new Button("点击截图");
        imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true); // 是否保留源图像的纵横比

        AnchorPane root = new AnchorPane();
        root.setPrefWidth(600);
        root.setPrefHeight(600);
        root.setStyle("-fx-background-color: #ffb5c5");

        root.getChildren().addAll(bu, imageView);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(600);
        primaryStage.setWidth(600);
        primaryStage.show();

        bu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                show();

            }
        });

        // 设置按钮的快捷键
        KeyCodeCombination codeCombination = new KeyCodeCombination(KeyCode.P, KeyCombination.META_DOWN, KeyCombination.ALT_DOWN);
        Mnemonic mc = new Mnemonic(bu, codeCombination);
        scene.addMnemonic(mc);

    }

    public void show() {
        // 点击截图，最小化任务栏上
        primaryStage.setIconified(true);

        stage = new Stage();

        stage.initStyle(StageStyle.TRANSPARENT); // 设置透明样式

        // 场景必须有一个根节点
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-opacity: 0.7; -fx-background-color: #d3d7d4");


        Scene scene = new Scene(anchorPane);
        scene.setFill(Color.rgb(12, 102, 136, 0));

        Screen primary = Screen.getPrimary();
        Rectangle2D bounds = primary.getVisualBounds();


        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setScene(scene);
        stage.setFullScreenExitHint(""); // 设置全屏幕提示
//        stage.setFullScreen(true); // 设置全屏
        stage.setMaximized(true);
        stage.show();


        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ESCAPE) {
                    stage.close();
                    primaryStage.setIconified(false);
                }
            }
        });

        drag(anchorPane);
    }

    public void drag(AnchorPane an) {
        // 鼠标按下确定绘制的起始点
        an.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                an.getChildren().clear();

                hBoxView = new HBox();
                hBoxView.setBackground(null);
                // 设置边框
                hBoxView.setBorder(new Border(
                        new BorderStroke(Paint.valueOf("#cd3700"),
                                BorderStrokeStyle.SOLID, null, new BorderWidths(2))));

                startScreenX = event.getSceneX();
                startScreenY = event.getSceneY();

                hBoxView.setLayoutX(startScreenX);
                hBoxView.setLayoutY(startScreenY);

                an.getChildren().addAll(hBoxView);

                System.out.println(startScreenX);
                System.out.println(startScreenY);
            }
        });

        // 设置拖动检测
        an.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                an.startFullDrag(); // 启动完整拖拽的动作
            }
        });

        // 鼠标拖动划过
        an.setOnMouseDragOver(new EventHandler<MouseDragEvent>() {

            @Override
            public void handle(MouseDragEvent event) {
                Label label = new Label();
                label.setAlignment(Pos.CENTER);
                label.setPrefWidth(160);
                label.setPrefHeight(30);
                label.setTextFill(Paint.valueOf("#ffffff"));
                label.setStyle("-fx-background-color: #000000");

                an.getChildren().add(label);

                double sceneX = event.getSceneX();
                double sceneY = event.getSceneY();

                // 获取起点和终点坐标得到宽和高
                double width = sceneX - startScreenX;
                double height = sceneY - startScreenY;

                label.setLayoutX(startScreenX);
                label.setLayoutY(startScreenY - label.getPrefHeight());
                label.setText("宽度" + width + "高度:" + height);

                hBoxView.setPrefWidth(width);
                hBoxView.setPrefHeight(height);
            }
        });

        // 拖拽退出
        an.setOnMouseDragExited(new EventHandler<MouseDragEvent>() {

            private Button button;

            @Override
            public void handle(MouseDragEvent event) {
                endScreenX = event.getSceneX();
                endScreenY = event.getSceneY();

                button = new Button("选择完成");
                hBoxView.getChildren().add(button);
                hBoxView.setAlignment(Pos.BOTTOM_RIGHT);

                button.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        hBoxView.getChildren().clear();
                        stage.close();
                        getScreenImg();
                    }
                });
            }
        });
    }

    public synchronized void getScreenImg() {

        stage.setWidth(0);
        stage.close();

        double w = endScreenX - startScreenX;
        double h = endScreenY - startScreenY;

        // 屏幕截图api
        Robot robot = new Robot();
        Rectangle2D rectangle2D = new Rectangle2D(startScreenX, startScreenY, w, h);
        WritableImage image = robot.getScreenCapture(new WritableImage((int) w, (int) h), rectangle2D);

        imageView.setImage(image);

        primaryStage.setIconified(false);

        // 剪切板
        Clipboard cb = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putImage(image);
        cb.setContent(content);


    }
}
