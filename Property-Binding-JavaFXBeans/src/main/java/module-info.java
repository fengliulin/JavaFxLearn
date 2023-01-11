module cc.chengheng.Property {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens cc.chengheng to javafx.fxml;
    exports cc.chengheng.JavaFxBean;

}