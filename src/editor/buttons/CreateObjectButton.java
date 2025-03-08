package editor.buttons;

import java.awt.event.ActionEvent;
import javax.swing.Icon;

import editor.MyToolBar;
import interfaces.CreateObjectInterface;
import mode.CreateObjectMode;
import mode.ModeManager;

public class CreateObjectButton extends MyButton {

    private CreateObjectInterface strategy;

    public CreateObjectButton(CreateObjectInterface strategy, Icon icon) {
        super(strategy, icon);
        this.strategy = strategy;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModeManager.setMode(new CreateObjectMode(strategy));
        MyToolBar.getInstance().updateButtonColors(this);
    }
}