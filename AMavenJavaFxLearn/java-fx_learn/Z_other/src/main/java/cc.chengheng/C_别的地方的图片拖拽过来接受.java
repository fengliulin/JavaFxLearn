package cc.chengheng;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

/**
 * 先设置拖拽检测
 * 完整的拖拽、释放、完成
 * 都是这个过程
 */
public class C_别的地方的图片拖拽过来接受 extends Application {
    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {


        HBox hBox = new HBox();
        hBox.setPrefHeight(300);
        hBox.setPrefWidth(300);
        hBox.setStyle("-fx-background-color: #ffff55");
        ImageView iv = new ImageView();
        iv.setPreserveRatio(true); // 保持宽高比
        iv.setFitWidth(300);
        hBox.getChildren().add(iv);



        hBox.setOnDragEntered(event -> {
            hBox.setBorder(new Border(new BorderStroke(Paint.valueOf("#ff0000"), BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(5), new Insets(0))));
            // 系统的传输模式是 COPY
            System.out.println(event.getTransferMode());
        });

        hBox.setOnDragExited(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
//                hBox.setBorder(new Border(new BorderStroke(Paint.valueOf("#ff000000"), BorderStrokeStyle.SOLID, new CornerRadii(0), new BorderWidths(5), new Insets(0))));
                hBox.setBorder(null);
            }
        });

        hBox.setOnDragOver(event -> {
            System.out.println(event.getTransferMode());
           event.acceptTransferModes(TransferMode.COPY); // 不调用这个，setOnDragDropped无效
        });

        // 拖拽放下的时候
        hBox.setOnDragDropped(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                Dragboard db = event.getDragboard();
                List<File> files = db.getFiles();
                if (db.hasFiles()) {
                    Object obj = db.getContent(DataFormat.IMAGE);
                    Image image = (Image) obj;
                    iv.setImage(image);
                } else if (db.hasUrl()) { // 浏览器里拖过来
                    Image im = new Image(db.getUrl());
                    iv.setImage(im);
                }
            }
        });




        //================================================================
        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(hBox);

        AnchorPane.setLeftAnchor(hBox, 200.0);
        AnchorPane.setTopAnchor(hBox, 100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);


        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

    }
}
