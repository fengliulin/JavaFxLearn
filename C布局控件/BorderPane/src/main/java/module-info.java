module cc.chengheng.borderpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens cc.chengheng.borderpane to javafx.fxml;
    exports cc.chengheng.borderpane;
}