module cc.chengheng.splitpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens cc.chengheng.splitpane to javafx.fxml;
    exports cc.chengheng.splitpane;
}