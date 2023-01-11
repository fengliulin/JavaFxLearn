/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/11
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class 更改可观察列表的监听器 {
    public static void main(String[] args) {
        ObservableList<String> strings = FXCollections.observableArrayList();

        strings.addListener((Observable observable) -> {
            System.out.println("\tlist invalidated");
        });

        strings.addListener((ListChangeListener.Change<? extends String> change) -> {
            System.out.println("\tstrings = " +
                    change.getList());
        });

        strings.add("First");
        strings.add("First1");
        strings.add("First2");

        strings.set(1, "New First");

        for (String string : strings) {
            System.out.println(string);
        }
    }

}

