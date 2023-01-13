/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/12
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;

public class MultipleJavaFxScenesInSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame jframe = new JFrame("JavaFX 11 integrated in Swing (multiple)");
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JFXPanel northJfxPanel = new JFXPanel();
            Button northButton = new Button("Hello FX North");
            Scene northScene = new Scene(northButton);
            northJfxPanel.setScene(northScene);
            northJfxPanel.setPreferredSize(new Dimension(200, 50));


            JFXPanel southJfxPanel = new JFXPanel();
            Button southButton = new Button("Hello FX South");
            Scene southScene = new Scene(southButton);
            southJfxPanel.setScene(southScene);
            southJfxPanel.setPreferredSize(new Dimension(200, 50));


            JPanel jpanel = new JPanel(new BorderLayout());
            jpanel.add(northJfxPanel, BorderLayout.NORTH);
            jpanel.add(southJfxPanel, BorderLayout.SOUTH);
            jpanel.add(new JLabel("Hello Swing"), BorderLayout.CENTER);
            jframe.setContentPane(jpanel);
            jframe.pack();
            jframe.setLocationRelativeTo(null);
            jframe.setVisible(true);
        });
    }
}

