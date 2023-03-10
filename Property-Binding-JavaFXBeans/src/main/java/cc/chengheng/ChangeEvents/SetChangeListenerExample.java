/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/11
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng.ChangeEvents;

import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

import java.util.Arrays;

public class SetChangeListenerExample {
    public static void main(String[] args) {
        ObservableSet<String> set = FXCollections.observableSet();
        set.addListener(new MyListener());

        set.add("First");

        set.addAll(Arrays.asList("Second", "Third"));

        set.remove("Third");
    }


    private static class MyListener implements SetChangeListener<String> {
        @Override
        public void onChanged(Change<? extends String> change) {
            System.out.println("\tset = " + change.getSet());

            System.out.println(prettyPrint(change));
        }
        private String prettyPrint(
                Change<? extends String> change) {
            StringBuilder sb =
                    new StringBuilder("\tChange" +
                            " event data:\n");
            sb.append("\t\tWas added: ")
                    .append(change.wasAdded())
                    .append("\n");
            sb.append("\t\tWas removed: ")
                    .append(change.wasRemoved())
                    .append("\n");
            sb.append("\t\tElement added: ")
                    .append(change.getElementAdded())
                    .append("\n");
            sb.append("\t\tElement removed: ")
                    .append(change.getElementRemoved())
                    .append("\n");
            return sb.toString();
        }
    }
}

