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


// 在javafx事件里面， 调用swing组件

public class SwingAndJavaFxEmbeddingInteractive {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame jframe = new JFrame("JavaFX 11 integrated in Swing");
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JFXPanel jfxPanel = new JFXPanel();
            Button button = new Button("Hello FX");
            Scene scene = new Scene(button);
            jfxPanel.setScene(scene);
            jfxPanel.setPreferredSize(new Dimension(200, 100));
            jfxPanel.setBorder(new EmptyBorder(5, 5, 5, 5));


            JPanel jpanel = new JPanel(new BorderLayout());
            JLabel jLabel = new JLabel("Hello Swing North");
            jpanel.add(jLabel, BorderLayout.NORTH);
            JLabel southLabel = new JLabel("Hello Swing South");
            jpanel.add(southLabel, BorderLayout.SOUTH);

            // java的属性修改 swing的属性
            button.setOnMousePressed(e -> {
                SwingUtilities.invokeLater(() -> {
                    southLabel.setText("FX Button Pressed");
                });
            });

            button.setOnMouseReleased(e -> {
                SwingUtilities.invokeLater(() -> {
                    southLabel.setText("Hello Swing South");

                });
            });


            // swing 修改 javafx的属性
            southLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    Platform.runLater(() -> button.setText("Swing Button Pressed"));
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    Platform.runLater(() -> button.setText("Hello FX"));
                }
            });



            jpanel.add(jfxPanel, BorderLayout.CENTER);
            jframe.setContentPane(jpanel);
            jframe.pack();
            jframe.setLocationRelativeTo(null);
            jframe.setVisible(true);
        });
    }
}

