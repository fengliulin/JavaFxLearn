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
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;

public class WebViewToSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame jframe = new JFrame("JavaFX 11 integrated in Swing");
            jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


            JPanel jpanel = new JPanel(new BorderLayout());
            jpanel.add(new JLabel("Hello Swing North"), BorderLayout.NORTH);
            jpanel.add(new JLabel("Hello Swing South"), BorderLayout.SOUTH);


            JFXPanel jfxPanel = new JFXPanel();

            Platform.runLater(() -> {
                var webView = new WebView();
                var scene = new Scene(webView);
                webView.getEngine().load("https://openjfx.io/");
                jfxPanel.setScene(scene);
                jfxPanel.setPreferredSize(new Dimension(400,600));
                SwingUtilities.invokeLater(() -> {
                    jpanel.add(jfxPanel, BorderLayout.CENTER);
                    jframe.pack();
                    jframe.setLocationRelativeTo(null);
                });
            });

            jframe.setContentPane(jpanel);
            jframe.pack();
            jframe.setLocationRelativeTo(null);
            jframe.setVisible(true);
        });
    }
}

