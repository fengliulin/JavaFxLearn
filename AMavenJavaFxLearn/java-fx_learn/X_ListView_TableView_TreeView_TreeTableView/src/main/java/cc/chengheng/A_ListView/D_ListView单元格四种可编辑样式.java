package cc.chengheng.A_ListView;

import javafx.application.Application;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.control.cell.ChoiceBoxListCell;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;

/*
默认超出，就会出现滚动条
 */
public class D_ListView单元格四种可编辑样式 extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        Data d1 = new Data("A");
        Data d2 = new Data("B");
        Data d3 = new Data("C");

        ObservableList<Data> list = FXCollections.observableArrayList();
        list.add(d1);
        list.add(d2);
        list.add(d3);

        ListView<Data> listView = new ListView<>(list);


        // 文本框修改
        /*Callback<ListView<Data>, ListCell<Data>> call = TextFieldListCell.forListView(new StringConverter<Data>() {
            @Override
            public String toString(Data object) {
                return object.getName();
            }

            @Override
            public Data fromString(String string) {
                return new Data(string + " -new");
            }
        });*/

        // 组合框下拉选择修改
       /* Callback<ListView<Data>, ListCell<Data>> call = ComboBoxListCell.forListView(new StringConverter<Data>() {
            @Override
            public String toString(Data object) {
                return object.getName();
            }

            @Override
            public Data fromString(String string) {
                return new Data(string + " -new");
            }
        }, new Data("D"), new Data("E"));*/

        // 选择框样式选择
        /*Callback<ListView<Data>, ListCell<Data>> call = ChoiceBoxListCell.forListView(new StringConverter<Data>() {
            @Override
            public String toString(Data object) {
                return object.getName();
            }

            @Override
            public Data fromString(String string) {
                return new Data(string + " -new");
            }
        }, new Data("D"), new Data("E"));*/

        // 复选框样式的单元格
        Callback<ListView<Data>, ListCell<Data>> call = CheckBoxListCell.forListView(new Callback<Data, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(Data param) {
               /* if (param.getName().equals("A")) {
                    return new SimpleBooleanProperty(true);
                } else if (param.getName().equals("B")) {
                    return new SimpleBooleanProperty(false);
                }

                return new SimpleBooleanProperty(true);*/

                 if (param.getName().equals("A")) {
                     param.setSbl(true);
                    return param.getSbl();
                } else if (param.getName().equals("B")) {
                     param.setSbl(false);
                     return param.getSbl();
                }

                param.setSbl(true);
                return param.getSbl();
            }
        }, new StringConverter<Data>() {
            @Override
            public String toString(Data object) {
                return object.getName();
            }

            @Override
            public Data fromString(String string) {
                return new Data(string + " -new");
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Data>() {
            @Override
            public void changed(ObservableValue<? extends Data> observable, Data oldValue, Data newValue) {

                System.out.println(newValue.getName() + "-" + newValue.getSblBoolean());
            }
        });

        d1.getSbl().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println(newValue.booleanValue());
            }
        });

        listView.setEditable(true);
        listView.setCellFactory(call);

        listView.setPrefWidth(300);
        listView.setPrefHeight(150);


        listView.setOnEditStart(event -> {
            System.out.println("开始" + event.getSource());
        });

        listView.setOnEditCommit(event -> {
            System.out.println("开始提交");
            list.set(event.getIndex(), event.getNewValue());
        });

        listView.setOnEditCancel(event -> {
            System.out.println("取消");
        });


        Button bu = new Button("button");


        bu.setOnAction(event -> {
            listView.edit(2);
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
        private SimpleBooleanProperty sbl = new SimpleBooleanProperty();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Data(String name) {
            this.name = name;
        }

        public boolean isSbl() {
            return sbl.get();
        }

        public SimpleBooleanProperty getSbl() {
            return sbl;
        }

        public void setSbl(boolean sbl) {
            this.sbl.set(sbl);
        }

        public boolean getSblBoolean() {
            return sbl.get();
        }
    }
}
