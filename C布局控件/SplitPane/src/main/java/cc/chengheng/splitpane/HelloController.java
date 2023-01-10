package cc.chengheng.splitpane;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;



    @FXML
    public void button_OnAction(ActionEvent actionEvent) {
        SplitPane splitPane = new SplitPane();

        splitPane.getItems().add(new AnchorPane());
        splitPane.getItems().add(new AnchorPane());
        splitPane.getItems().add(new AnchorPane());

        ObservableList<SplitPane.Divider> dividers = splitPane.getDividers();

        splitPane.setDividerPositions(0.2d, 0.8);

        System.out.println();
//        splitPane.setDividerPositions(2, 0.8d);



        Scene scene = new Scene(splitPane, 500, 500);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}