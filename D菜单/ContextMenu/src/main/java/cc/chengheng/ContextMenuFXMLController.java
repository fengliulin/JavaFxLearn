package cc.chengheng;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ContextMenuFXMLController implements Initializable {


    public Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void button_OnAction(ActionEvent actionEvent) {

        Menu file = new Menu("File");
        Menu help = new Menu("Help");

        Menu newMenu = new Menu("Create New...");

        newMenu.getItems().addAll(
                new MenuItem("nihao")
        );

        file.getItems().addAll(newMenu, new SeparatorMenuItem(), new MenuItem("退出"));

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(file, help);
        System.out.println();

        Scene scene = new Scene(menuBar);

        Stage stage = new Stage();
        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();
    }

    public void menuButton_OnAction(ActionEvent actionEvent) {

        MenuButton menuButton = new MenuButton();
        menuButton.setText("MenuButton");
        menuButton.getItems().addAll(
                new MenuItem("nihao1"),
                new MenuItem("nihao2")
        );

        menuButton.setOnAction(event -> {
            System.out.println("被点击");
        });

        SplitMenuButton splitMenuButton = new SplitMenuButton();
        splitMenuButton.setText("Perform action!");

        splitMenuButton.getItems().addAll(
                new MenuItem("nihao3"),
                new MenuItem("nihao3")
        );

        splitMenuButton.setOnAction(event -> {
            System.out.println("分割按钮被点击");
        });

        VBox menuBar = new VBox();
        menuBar.getChildren().addAll(menuButton, splitMenuButton);


        Scene scene = new Scene(menuBar);

        Stage stage = new Stage();
        stage.setTitle("MyShapes with JavaFx");
        stage.setScene(scene);
        stage.show();
    }
}