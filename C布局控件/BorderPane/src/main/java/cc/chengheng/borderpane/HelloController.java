package cc.chengheng.borderpane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void borderPane_OnAction(ActionEvent actionEvent) {

        BorderPane borderPane = new BorderPane();
        Label colorLabel = new Label("Color: Lightblue");
        colorLabel.setFont(new Font("Verdana", 18));
        borderPane.setTop(colorLabel);
        Rectangle rectangle = new Rectangle(100, 50, Color.LIGHTBLUE);
        borderPane.setCenter(rectangle);
        BorderPane.setAlignment(colorLabel, Pos.CENTER);
        BorderPane.setMargin(colorLabel, new Insets(20, 10, 5, 10));
        borderPane.setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        Scene scene = new Scene(borderPane, 500, 500);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}