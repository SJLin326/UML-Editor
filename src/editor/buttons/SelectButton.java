package editor.buttons;

import java.awt.event.ActionEvent;
import javax.swing.Icon;

import editor.MyToolBar;
import mode.ModeManager;
import mode.SelectMode;

public class SelectButton extends MyButton {

    public SelectButton(Icon icon) {
        super(icon);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModeManager.setMode(new SelectMode());
        MyToolBar.getInstance().updateButtonColors(this);
    }
}