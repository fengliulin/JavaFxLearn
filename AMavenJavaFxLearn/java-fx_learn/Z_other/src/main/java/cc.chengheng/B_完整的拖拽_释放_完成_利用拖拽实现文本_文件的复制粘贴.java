package cc.chengheng;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 先设置拖拽检测
 * 完整的拖拽、释放、完成
 * 都是这个过程
 */
public class B_完整的拖拽_释放_完成_利用拖拽实现文本_文件的复制粘贴 extends Application {
    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        TextField tf = new TextField();

        Label label = new Label("hello world");

        // 拖拽检测
        label.setOnDragDetected(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // TransferMode.COPY 它只是一个期望的模式， 并不会限制你的代码怎么写
                Dragboard db = label.startDragAndDrop(TransferMode.COPY);


                Text text = new Text(label.getText());

                // 设置拖拽面板的图标
                WritableImage wi = new WritableImage((int) label.getWidth(), (int) label.getHeight());
                text.snapshot(new SnapshotParameters(), wi);
                db.setDragView(wi);

                // 剪切板存数据
                ClipboardContent content = new ClipboardContent();
                content.putString(label.getText());

                db.setContent(content);
            }
        });


        // setOnMouseDragged, 对它无效， 需要设置拖动检测， 得是一个拖动面板
        tf.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.COPY);
        });

        // 拖动释放鼠标按钮时
        tf.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                tf.setText(event.getDragboard().getString());

                // 设置完成, 之后调用 setOnDragDone
                event.setDropCompleted(true);
            }
        });

        // 拖拽完成
        label.setOnDragDone(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
               label.setText("");
            }
        });



        //================================================================
        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(tf, label);

        AnchorPane.setLeftAnchor(tf, 200.0);
        AnchorPane.setLeftAnchor(label, 10.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);


        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

    }
}
