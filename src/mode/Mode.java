package mode;

import java.awt.event.MouseEvent;

import editor.Canvas;

public abstract class Mode {

	protected Canvas canvas;

	public Mode() {
		this.canvas = Canvas.getInstance();
	}

	public abstract void mousePressed(MouseEvent e);

	public abstract void mouseReleased(MouseEvent e);

	public abstract void mouseDragged(MouseEvent e);

	public abstract void mouseClicked(MouseEvent e);
}