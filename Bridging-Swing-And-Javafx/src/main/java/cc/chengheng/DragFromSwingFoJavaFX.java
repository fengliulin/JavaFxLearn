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
import javafx.scene.control.Label;
import javafx.scene.input.DataFormat;
import javafx.scene.input.TransferMode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DragFromSwingFoJavaFX {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var frame = new JFrame("JavaFX 11 DnD in Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            var jfxPanel = new JFXPanel();
            var label = new Label("Hello FX");
            var scene = new Scene(label);
            jfxPanel.setScene(scene);
            jfxPanel.setPreferredSize(new Dimension(200, 100));
            label.setOnDragOver(event -> {
                var dragboard = event.getDragboard();
                if (dragboard.getContentTypes().contains(DataFormat.lookupMimeType("application/x-java-serialized-object"))) {
                    event.acceptTransferModes(TransferMode.COPY);
                }
                event.consume();
            });
            label.setOnDragDropped(event -> {
                var dataFormat = DataFormat.lookupMimeType("application/x-java-serialized-object");
                var dragboard = event.getDragboard();
                if (dragboard.hasContent(dataFormat)) {
                    String content = (String) dragboard.getContent(dataFormat);
                    label.setText(content);
                }
                event.setDropCompleted(true);
                event.consume();
            });
            var panel = new JPanel(new BorderLayout());
            var northField = new JTextField("Hello Swing North");
            northField.setDragEnabled(true);
            northField.addMouseListener(new MouseDragAdapter());
            var southField = new JTextField("Hello Swing South");
            southField.setDragEnabled(true);
            southField.addMouseListener(new MouseDragAdapter());
            panel.add(northField, BorderLayout.NORTH);
            panel.add(southField, BorderLayout.SOUTH);

            panel.add(jfxPanel, BorderLayout.CENTER);
            frame.setContentPane(panel);

            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static class MouseDragAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            var component = (JComponent) e.getSource();
            component.getTransferHandler().exportAsDrag(component, e, TransferHandler.COPY);
        }

    }
}

