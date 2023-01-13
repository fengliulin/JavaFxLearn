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

public class InteractiveBidirectionalJavaFXInSwing1 {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var frame = new JFrame("JavaFX 11 integrated in Swing (multiple, dynamic)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // javafx
            var northJfxPanel = new JFXPanel();
            var northButton = new Button("Hello FX North");
            var northScene = new Scene(northButton);
            northJfxPanel.setScene(northScene);
            northJfxPanel.setPreferredSize(new Dimension(200, 50));

            // swing
            var panel = new JPanel(new BorderLayout());
            panel.add(northJfxPanel, BorderLayout.NORTH);
            var swingButton = new JButton("Add FX Scene in South");

            swingButton.addActionListener(e -> {
                // javafx
                var southJfxPanel = new JFXPanel();
                var southButton = new Button("Hello FX South");
                var southScene = new Scene(southButton);
                southJfxPanel.setPreferredSize(new Dimension(200, 50));

                panel.add(southJfxPanel, BorderLayout.SOUTH);

                Platform.runLater(() -> {
                    southJfxPanel.setScene(southScene);
                    SwingUtilities.invokeLater(frame::pack);
                });
            });
            panel.add(swingButton, BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

