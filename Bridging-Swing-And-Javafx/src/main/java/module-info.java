module cc.chengheng.Property {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires javafx.web;


    opens cc.chengheng to javafx.fxml;
    exports cc.chengheng;
    exports cc.chengheng.三D;
    opens cc.chengheng.三D to javafx.fxml;
}