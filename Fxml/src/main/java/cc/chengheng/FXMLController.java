package cc.chengheng;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.beans.binding.When;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    @FXML private Text text2;

    @FXML private StackPane stackPane;

    private RotateTransition rotate;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rotate = new RotateTransition(Duration.millis(2500), stackPane);
        rotate.setToAngle(360);
        rotate.setFromAngle(0);
        rotate.setInterpolator(Interpolator.LINEAR); // 设置插值器

        text2.strokeProperty().bind(new When(rotate.statusProperty().isEqualTo(Animation.Status.RUNNING))
                .then(Color.GREEN).otherwise(Color.RED));

        rotate.statusProperty().addListener((observable, oldValue, newValue) -> { // 属性改变监听
            text2.setText("旧的值" + oldValue + ", 新值" + newValue);
        });

        //添加css样式
//        text2.getStyleClass().add("myText");

    }

    @FXML
    public void stackPane_OnMouseClicked(MouseEvent mouseEvent) {
        if (rotate.getStatus().equals(Animation.Status.RUNNING)) {
            rotate.pause();
        } else {
            System.out.println();
            rotate.play();
        }
    }
}