package editor.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;

import interfaces.CreateLineInterface;
import interfaces.CreateObjectInterface;
import mode.ModeManager;

public class MyButton extends JButton implements ActionListener {

    protected ModeManager modeManager;

    public MyButton(CreateObjectInterface strategy, Icon icon) {
        initbutton(icon);
    }

    public MyButton(CreateLineInterface strategy, Icon icon) {
        initbutton(icon);
    }

    public MyButton(Icon icon) {
        initbutton(icon);
    }

    public void initbutton(Icon icon) {
        this.setIcon(icon);
        // 取消按鈕圖案的邊框
        this.setFocusPainted(false);
        // 添加 ActionListener
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
