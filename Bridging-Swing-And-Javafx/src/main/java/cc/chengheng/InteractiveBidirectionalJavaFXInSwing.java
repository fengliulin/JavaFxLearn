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
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InteractiveBidirectionalJavaFXInSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var frame = new JFrame("JavaFX 11 bidirectional interaction in Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // javafx
            var jfxPanel = new JFXPanel();
            Button button = new Button("Hello FX");
            Scene scene = new Scene(button);
            jfxPanel.setScene(scene);
            jfxPanel.setPreferredSize(new Dimension(200, 100));
            jfxPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

            // swing
            var panel = new JPanel(new BorderLayout());
            panel.add(new JLabel("Hello Swing North"), BorderLayout.NORTH);
            var southButton = new JButton("Hello Swing South Button");
            panel.add(southButton, BorderLayout.SOUTH);

            button.setOnMousePressed(e -> {
                SwingUtilities.invokeLater(() -> southButton.setText("FX Button Pressed"));
            });

            button.setOnMouseReleased(e -> {
                SwingUtilities.invokeLater(() -> southButton.setText("Hello Swing South"));
            });

            southButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Platform.runLater(() -> button.setText("Swing Button Pressed"));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    Platform.runLater(() -> button.setText("Hello FX"));
                }
            });

            southButton.addActionListener(e -> {
                var southJfxPanel = new JFXPanel();
                var southButton1 = new Button("Hello FX South");
                var southScene = new Scene(southButton1);
                southJfxPanel.setPreferredSize(new Dimension(200,50));

                panel.add(southJfxPanel, BorderLayout.SOUTH);

                Platform.runLater(() -> {
                    southJfxPanel.setScene(southScene);
                    SwingUtilities.invokeLater(frame::pack);
                });
            });

            panel.add(jfxPanel, BorderLayout.CENTER);
            frame.setContentPane(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

