package mode;

import java.awt.event.MouseEvent;

import component.Shape;
import interfaces.CreateObjectInterface;

public class CreateObjectMode extends Mode {
    private CreateObjectInterface strategy;

    public CreateObjectMode(CreateObjectInterface strategy) {
        super();
        this.strategy = strategy;
        for (Shape shape : canvas.shapes) {
            shape.setSelected(false);
        }
        canvas.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Strategy design pattern
        canvas.addShape(strategy.createObject(e.getX(), e.getY()));
        canvas.repaint();
    }
}