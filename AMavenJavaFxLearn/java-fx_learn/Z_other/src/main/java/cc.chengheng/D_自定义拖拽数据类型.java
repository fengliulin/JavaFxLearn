package cc.chengheng;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.File;
import java.io.Serializable;
import java.util.List;

/**
 * 先设置拖拽检测
 * 完整的拖拽、释放、完成
 * 都是这个过程
 */
public class D_自定义拖拽数据类型 extends Application {

    private AnchorPane an;

    public static void main(String[] args) {
        launch();
    }

    private DataFormat personFormat = new DataFormat("data/person");

    @Override
    public void start(Stage primaryStage) throws Exception {

        Person person = new Person("张三", 18, getClass().getResource("/s.jpeg").toExternalForm());

        Button btn = new Button("数据");
        VBox view;
        {// 拖拽图标的面板
            view = new VBox();
            view.setStyle("-fx-border-color: #ff0000");
            view.setPrefWidth(300);
            view.setPrefHeight(500);

            Button bu = new Button("个人详情");
//        bu.setMaxWidth(dataPane.getPrefWidth());
            bu.prefWidthProperty().bind(view.prefWidthProperty());

            TextField t1 = new TextField();
            TextField t2 = new TextField();

            ImageView iv = new ImageView();
            iv.setPreserveRatio(true);
            iv.setFitWidth(view.getPrefWidth());

            view.getChildren().addAll(bu, t1, t2, iv);

            TextField nameView = (TextField) view.getChildren().get(1);
            TextField ageView = (TextField) view.getChildren().get(2);
            ImageView imageView = (ImageView) view.getChildren().get(3);

            nameView.setText(person.getName());
            ageView.setText(String.valueOf(person.getAge()));
            imageView.setImage(new Image(person.getPhoto()));
        }


        // 数据面板
        VBox dataPane = new VBox();
        dataPane.setStyle("-fx-border-color: #ff0000");
        dataPane.setPrefWidth(300);
        dataPane.setPrefHeight(500);

        Button bu = new Button("个人详情");
//        bu.setMaxWidth(dataPane.getPrefWidth());
        bu.prefWidthProperty().bind(dataPane.prefWidthProperty());

        TextField t1 = new TextField();
        TextField t2 = new TextField();

        ImageView iv = new ImageView();
        iv.setPreserveRatio(true);
        iv.setFitWidth(dataPane.getPrefWidth());


        dataPane.getChildren().addAll(bu, t1, t2, iv);


        // 拖拽检测
        btn.setOnDragDetected(event -> {
            // 拖拽面板
            Dragboard db = btn.startDragAndDrop(TransferMode.COPY);

            // 需要显示出来, 拿到快照，在移除
            an.getChildren().add(view);


            WritableImage wi = new WritableImage(300, 500);
            view.snapshot(new SnapshotParameters(), wi);

            db.setDragView(wi);

            an.getChildren().remove(view);

            ClipboardContent content = new ClipboardContent();
            content.put(personFormat, person);

            db.setContent(content);
        });

        dataPane.setOnDragOver(event -> {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        });

        // 拖砖扔下
        dataPane.setOnDragDropped(event -> {
            Dragboard db = event.getDragboard();
            Object content = db.getContent(DataFormat.lookupMimeType("data/person"));

            Person p = (Person) content;

            TextField name = (TextField) dataPane.getChildren().get(1);
            TextField age = (TextField) dataPane.getChildren().get(2);
            ImageView imageView = (ImageView) dataPane.getChildren().get(3);

            name.setText(p.getName());
            age.setText(String.valueOf(p.getAge()));
            imageView.setImage(new Image(p.getPhoto()));
        });


        //================================================================
        an = new AnchorPane();
        an.getChildren().addAll(btn, dataPane);

        AnchorPane.setLeftAnchor(dataPane, 200.0);
        AnchorPane.setTopAnchor(dataPane, 100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);


        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();

    }


    static class Person implements Serializable {
        private String name;
        private int age;
        private String photo;

        public Person(String name, int age, String photo) {
            this.name = name;
            this.age = age;
            this.photo = photo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    ", photo='" + photo + '\'' +
                    '}';
        }
    }
}
