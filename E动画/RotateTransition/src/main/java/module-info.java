module cc.chengheng.rotatetransition {
    requires javafx.controls;
    requires javafx.fxml;


    opens cc.chengheng.property to javafx.fxml;
    exports cc.chengheng.property;
}