module cc.chengheng.tilepane {
    requires javafx.controls;
    requires javafx.fxml;


    opens cc.chengheng.tilepane to javafx.fxml;
    exports cc.chengheng.tilepane;
}