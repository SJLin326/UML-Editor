package editor.buttons;

import java.awt.event.ActionEvent;
import javax.swing.Icon;

import editor.MyToolBar;
import interfaces.CreateLineInterface;
import mode.CreateLineMode;
import mode.ModeManager;

public class CreateLineButton extends MyButton {

    private CreateLineInterface strategy;

    public CreateLineButton(CreateLineInterface strategy, Icon icon) {
        super(strategy, icon);
        this.strategy = strategy;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ModeManager.setMode(new CreateLineMode(strategy));
        MyToolBar.getInstance().updateButtonColors(this);
    }
}