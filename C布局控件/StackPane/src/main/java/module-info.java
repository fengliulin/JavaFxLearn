/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/9
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
module cc.chengheng.StackPane {
    requires javafx.controls;
    requires javafx.fxml;

    opens cc.chengheng to javafx.fxml;
    exports cc.chengheng;
}