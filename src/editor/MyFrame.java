package editor;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import mode.ModeManager;

public class MyFrame extends JFrame {
    public MyFrame(String title) {
        super(title);

        JMenuBar myMenuBar = new MyMenuBar();
        this.setJMenuBar(myMenuBar);

        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        root.add(leftPanel, BorderLayout.WEST);

        JPanel rightPanel = Canvas.getInstance();
        root.add(rightPanel, BorderLayout.CENTER);
        // leftPanel.setBackground(Color.WHITE);

        new ModeManager();

        this.add(root);

        JToolBar myToolBar = MyToolBar.getInstance();
        myToolBar.setFloatable(false);
        myToolBar.setOrientation(JToolBar.VERTICAL);
        leftPanel.add(myToolBar);
    }
}