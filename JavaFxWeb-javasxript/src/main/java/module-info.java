module cc.chengheng.Property {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires jdk.jsobject;
    requires javafx.beaninfo;


    opens cc.chengheng to javafx.fxml;
    exports cc.chengheng;
    exports cc.chengheng.Dukescript;
    opens cc.chengheng.Dukescript to javafx.fxml;
}