package cc.chengheng.A_ListView;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.function.Consumer;

/*
默认超出，就会出现滚动条
 */
public class E_ListView自定义单元格 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Data d1 = new Data("A1", "18");
        Data d2 = new Data("A2", "19");
        Data d3 = new Data("A3", "20");
        Data d4 = new Data("A4", "21");


        ObservableList<Data> list = FXCollections.observableArrayList(new Callback<Data, Observable[]>() {
            @Override
            public Observable[] call(Data param) {
                SimpleStringProperty[] array = new SimpleStringProperty[]{
                        param.age
                };
                return array;
            }
        });

        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);


        ListView<Data> listView = new ListView<>(list);
        listView.setPlaceholder(new Label("没有数据")); // 设置占位符
        listView.setPrefWidth(300);
        listView.setPrefHeight(150);

        listView.setEditable(true);
        // 自定义单元格
        listView.setCellFactory(new Callback<ListView<Data>, ListCell<Data>>() {

            int index = 0;
            Data temp = null;
            ListCell<Data> cell= null;

            /**
             *
             * @param param 传递的是 上面的listView 对象
             * @return
             */
            @Override
            public ListCell<Data> call(ListView<Data> param) {
                param.setOnEditStart(new EventHandler<ListView.EditEvent<Data>>() {

                    @Override
                    public void handle(ListView.EditEvent<Data> event) {
                        index = event.getIndex();
                        temp = param.getItems().get(index);
                    }
                });


                ListCell<Data> listCell = new ListCell<>() {

                    /**
                     * 选中单元格触发
                     * @param selected
                     */
                    @Override
                    public void updateSelected(boolean selected) {
                        System.out.println("updateSelected");
                        super.updateSelected(selected);
                    }

                    /**
                     *
                     * @param oldItem
                     * @param newItem
                     * @return
                     */
                    @Override
                    protected boolean isItemChanged(Data oldItem, Data newItem) {
                        System.out.println("isItemChanged");
                        return super.isItemChanged(oldItem, newItem);
                    }

                    @Override
                    public void commitEdit(Data newValue) {
                        super.commitEdit(newValue);
                    }

                    @Override
                    public void cancelEdit() {
                        super.cancelEdit();
                        HBox hBox = new HBox(10);
                        hBox.setAlignment(Pos.CENTER_LEFT);

                        Image image = new Image(getClass().getResource("/a.jpeg").toExternalForm());
                        ImageView iv = new ImageView(image);
                        iv.setPreserveRatio(true);
                        iv.setFitHeight(20.0);

                        Button bu = new Button(temp.name + " 按钮");

                        Label name = new Label(temp.name);
                        Label age = new Label(temp.age.get());

                        hBox.getChildren().addAll(iv, bu, name, age);

//                            setGraphic(new Label(item.name + "=" + item.age.get()));
                        setGraphic(hBox);
                    }

                    /**
                     * 编辑列表的单元格
                     */
                    @Override
                    public void startEdit() {
                        cell = this;
                        super.startEdit();
                        System.out.println("开始编辑");
                        HBox hBox = new HBox(10);
                        hBox.setAlignment(Pos.CENTER_LEFT);

                        Image image = new Image(getClass().getResource("/a.jpeg").toExternalForm());
                        ImageView iv = new ImageView(image);
                        iv.setPreserveRatio(true);
                        iv.setFitHeight(20.0);

                        Button bu = new Button("按钮");

                        TextField name = new TextField(temp.name);
                        TextField age = new TextField(temp.age.get());

                        hBox.getChildren().addAll(iv, bu, name, age);

//                            setGraphic(new Label(item.name + "=" + item.age.get()));
                        setGraphic(hBox);


                        name.setOnKeyPressed(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent event) {
                                if (event.getCode() == KeyCode.ENTER) {
                                    if(name.getText().equals("")) {
                                        cell.commitEdit(temp);
                                    } else {
                                        String newName = name.getText();
                                        String newAge = age.getText();

                                        temp.name = newName;
                                        temp.age.set(newAge);

                                        cell.commitEdit(temp);
                                    }
                                }
                            }
                        });

                        age.setOnKeyPressed(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent event) {
                                if (event.getCode() == KeyCode.ENTER) {
                                    if(age.getText().equals("")) {
                                        cell.commitEdit(temp);
                                    } else {
                                        String newName = name.getText();
                                        String newAge = age.getText();

                                        temp.name = newName;
                                        temp.age.set(newAge);

                                        cell.commitEdit(temp);
                                    }
                                }
                            }
                        });

                    }

                    /**
                     *
                     * @param item
                     * @param empty true 没有数据; false 有数据
                     */
                    @Override
                    protected void updateItem(Data item, boolean empty) {
                        super.updateItem(item, empty); // 不能删除
                        if (!empty) { // 不为空，有数据
                            HBox hBox = new HBox(10);
                            hBox.setAlignment(Pos.CENTER_LEFT);

                            Image image = new Image(getClass().getResource("/a.jpeg").toExternalForm());
                            ImageView iv = new ImageView(image);
                            iv.setPreserveRatio(true);
                            iv.setFitHeight(20.0);

                            Button bu = new Button(item.name + " 按钮");

                            Label name = new Label(item.name);
                            Label age = new Label(item.age.get());

                            hBox.getChildren().addAll(iv, bu, name, age);

//                            setGraphic(new Label(item.name + "=" + item.age.get()));
                            setGraphic(hBox);

                            bu.setOnAction(event -> {
                                System.out.println("按钮");
                            });
                        }
                    }
                };

                return listCell;
            }
        });


        // 插入还是删除，只有有操作就会有监听 InvalidationListener
        list.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                ObservableList<Data> data = (ObservableList) observable;
                data.forEach(new Consumer<Data>() {
                    @Override
                    public void accept(Data d) {
                        System.out.println(d.name + "-" + d.age.get());
                    }
                });
            }
        });


        list.addListener(new ListChangeListener<Data>() {
            @Override
            public void onChanged(Change<? extends Data> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        System.out.println("添加动作");
                    }
                    if (c.wasRemoved()) {
                        System.out.println("删除动作");
                    }
                    if (c.wasReplaced()) {
                        System.out.println("替换动作");
                    }
                    if (c.wasPermutated()) {
                        System.out.println("排序动作");
                    }
                    if (c.wasUpdated()) {
                        System.out.println("更新动作");
                    }
                }
            }
        });

        Button bu = new Button("button");

        bu.setOnAction(event -> {
            d1.name = "dddd";
            d1.age.set("300"); // 这个被包装了， 所以更改，会刷新，把上面修改的也去刷新了

        });


        //================================================================
        AnchorPane an = new AnchorPane();
        an.getChildren().addAll(listView, bu);

        AnchorPane.setLeftAnchor(listView, 200.0);
        AnchorPane.setTopAnchor(listView, 100.0);

        Scene scene = new Scene(an);
        primaryStage.setScene(scene);


        primaryStage.setTitle("javaFx");
        primaryStage.setHeight(800);
        primaryStage.setWidth(800);
        primaryStage.show();
    }

    static class Data {
        private String name;
        private SimpleStringProperty age = new SimpleStringProperty();

        public Data(String name, String age) {
            this.name = name;
            this.age.set(age);
        }
    }
}
