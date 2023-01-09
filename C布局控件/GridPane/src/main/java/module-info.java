module com.example.gridpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens cc.chengheng.gridpane to javafx.fxml;
    exports cc.chengheng.gridpane;
}