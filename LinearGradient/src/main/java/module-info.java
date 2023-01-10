module cc.chengheng.lineargradient {
    requires javafx.controls;
    requires javafx.fxml;


    opens cc.chengheng.lineargradient to javafx.fxml;
    exports cc.chengheng.lineargradient;
}