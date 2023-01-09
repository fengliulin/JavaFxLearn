module cc.chengheng.javafxlearn {
    requires javafx.controls;
    requires javafx.fxml;


    opens cc.chengheng.javafxlearn to javafx.fxml;
    exports cc.chengheng.javafxlearn;
}