module com.example.flowpane {
    requires javafx.controls;
    requires javafx.fxml;


    opens cc.chengheng.flowpane to javafx.fxml;
    exports cc.chengheng.flowpane;
}