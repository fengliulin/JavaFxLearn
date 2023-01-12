module cc.chengheng.Property {
    requires javafx.controls;
    requires javafx.fxml;


    opens cc.chengheng to javafx.fxml;
    exports cc.chengheng;
}