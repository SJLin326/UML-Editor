package editor;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import editor.buttons.CreateLineButton;
import editor.buttons.CreateObjectButton;
import editor.buttons.SelectButton;
import interfaces.AssociationLineStrategy;
import interfaces.ClassObjectStrategy;
import interfaces.CompositionLineStrategy;
import interfaces.GeneralizationLineStrategy;
import interfaces.UseCaseObjectStrategy;

public class MyToolBar extends JToolBar {

    private static MyToolBar instance;
    private ArrayList<JButton> buttons = new ArrayList<>();

    private MyToolBar() {

        // 按鈕
        ImageIcon selectIcon = new ImageIcon(".\\src\\icon\\selectIcon.png");
        JButton select = new SelectButton(selectIcon);
        this.add(select);
        buttons.add(select);

        ImageIcon associationLineIcon = new ImageIcon(".\\src\\icon\\associationLineIcon.png");
        JButton associationLine = new CreateLineButton(new AssociationLineStrategy(), associationLineIcon);
        this.add(associationLine);
        buttons.add(associationLine);

        ImageIcon generalizationLineIcon = new ImageIcon(".\\src\\icon\\generalizationLineIcon.png");
        JButton generalizationLine = new CreateLineButton(new GeneralizationLineStrategy(), generalizationLineIcon);
        this.add(generalizationLine);
        buttons.add(generalizationLine);

        ImageIcon compositionLineIcon = new ImageIcon(".\\src\\icon\\compositionLineIcon.png");
        JButton compositionLine = new CreateLineButton(new CompositionLineStrategy(), compositionLineIcon);
        this.add(compositionLine);
        buttons.add(compositionLine);

        ImageIcon classObjectIcon = new ImageIcon(".\\src\\icon\\classObjectIcon.png");
        JButton classObject = new CreateObjectButton(new ClassObjectStrategy(), classObjectIcon);
        this.add(classObject);
        buttons.add(classObject);

        ImageIcon useCaseIcon = new ImageIcon(".\\src\\icon\\useCaseIcon.png");
        JButton useCase = new CreateObjectButton(new UseCaseObjectStrategy(), useCaseIcon);
        this.add(useCase);
        buttons.add(useCase);
    }

    public synchronized static MyToolBar getInstance() {
        if (instance == null) {
            instance = new MyToolBar();
        }
        return instance;
    }

    public void updateButtonColors(JButton clickedButton) {
        // 設定顏色
        for (JButton button : buttons) {
            if (button == clickedButton) {
                button.setBackground(Color.DARK_GRAY);
            } else {
                button.setBackground(null);
            }
        }
    }
}