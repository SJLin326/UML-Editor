package editor;

import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MyMenuBar extends JMenuBar {

    protected Canvas canvas;

    public MyMenuBar() {

        JMenu edit = new JMenu("Edit");
        this.add(edit);

        JMenuItem group = new JMenuItem("Group");
        edit.add(group);

        JMenuItem unGroup = new JMenuItem("UnGroup");
        edit.add(unGroup);

        JMenuItem changeObjectName = new JMenuItem("Change Object Name");
        edit.add(changeObjectName);

        this.canvas = Canvas.getInstance();

        group.addActionListener((ActionEvent e) -> {
            if (canvas.countSelectedShapes() > 1) {
                canvas.group();
                canvas.repaint();
            }
        });

        unGroup.addActionListener((ActionEvent e) -> {
            if (canvas.countSelectedShapes() == 1) {
                canvas.ungroup();
                canvas.repaint();
            }
        });

        changeObjectName.addActionListener((ActionEvent e) -> {
            if (canvas.countSelectedShapes() == 1) {
                // 弹出输入對話框
                String newName = JOptionPane.showInputDialog(null, "", "Change Object Name",
                        JOptionPane.PLAIN_MESSAGE);
                if (newName != null) {
                    canvas.setSelectedShapesName(newName);
                }
            }
            canvas.repaint();
        });
    }
}