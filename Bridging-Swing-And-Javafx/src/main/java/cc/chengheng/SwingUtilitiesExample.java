/******************************************
 * ProjectName : 程衡服装进销存            
 * Web         : www.chengheng.cc
 * Start Date  : 2023/1/12
 * Author      : 冯镠霖(fengliulin)
 * Email       : menin@163.com
 ******************************************/
package cc.chengheng;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;

public class SwingUtilitiesExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame jFrame = new JFrame("JavaFx 17 集成在  Swing");
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JFXPanel jfxPanel = new JFXPanel();
            Button button = new Button("Hello Fx");
            Scene scene = new Scene(button);
            jfxPanel.setScene(scene);
            jfxPanel.setPreferredSize(new Dimension(100,200));

            JPanel jPanel = new JPanel(new BorderLayout());
            jPanel.add(new JLabel("Hello Swing North"), BorderLayout.NORTH);
            jPanel.add(new JLabel("Hello Swing South"), BorderLayout.SOUTH);
            jPanel.add(jfxPanel, BorderLayout.CENTER);
            jFrame.setContentPane(jPanel);
            jFrame.pack();
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        });


    }
}

