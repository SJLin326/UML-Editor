package mode;

import java.awt.event.MouseEvent;

import component.Port;
import component.Shape;
import interfaces.CreateLineInterface;

public class CreateLineMode extends Mode {

    private Port startPort;
    private Port endPort;
    private Shape sourceShape;
    private Shape targetShape;
    private CreateLineInterface strategy;

    public CreateLineMode(CreateLineInterface strategy) {
        super();
        this.strategy = strategy;
        for (Shape shape : canvas.shapes) {
            shape.setSelected(false);
        }
        canvas.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (canvas.checkIsInside(e) != null) {
            sourceShape = canvas.checkIsInside(e);
            startPort = sourceShape.findNearestPort(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (canvas.checkIsInside(e) != null & sourceShape != canvas.checkIsInside(e) & startPort != null) {
            targetShape = canvas.checkIsInside(e);
            endPort = targetShape.findNearestPort(e.getX(), e.getY());
            if (endPort != null) {
                // Strategy design pattern
                this.canvas.addShape(strategy.createLine(startPort, endPort));
            }
        }

        startPort = null;
        endPort = null;
        sourceShape = null;
        targetShape = null;

        canvas.repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
}