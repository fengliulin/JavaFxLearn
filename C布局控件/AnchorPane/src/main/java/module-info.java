module cc.chengheng.anchorpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens cc.chengheng.anchorpane to javafx.fxml;
    exports cc.chengheng.anchorpane;
}