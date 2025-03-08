package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;

import component.Shape;

public class SelectMode extends Mode {

	private Point startPoint;
	private Point endPoint;
	private int moveObject = 0;
	private int selectArea = 0;
	private Shape selectedShape;

	public SelectMode() {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		canvas.selectObject(e);
		canvas.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		startPoint = e.getPoint();

		if (canvas.checkIsInside(e) != null) {
			selectedShape = canvas.checkIsInside(e);
			canvas.selectObject(e);
			moveObject = 1;
		} else {
			selectArea = 1;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		endPoint = e.getPoint();
		if (moveObject == 1) {
			selectedShape.move(endPoint.x - startPoint.x, endPoint.y - startPoint.y);
			startPoint = e.getPoint();
		} else if (selectArea == 1) {
			canvas.calculateSelectedArea(startPoint, endPoint);
		}
		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endPoint = e.getPoint();

		if (moveObject == 1) {
		} else if (selectArea == 1) {
			canvas.isContain(startPoint, endPoint);
			startPoint = null;
			endPoint = null;
			canvas.calculateSelectedArea(startPoint, endPoint);
		}

		canvas.repaint();

		moveObject = 0;
		selectArea = 0;
	}
}