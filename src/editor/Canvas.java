package editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

import component.CompositeObject;
import component.Shape;
import mode.ModeManager;

public class Canvas extends JPanel implements MouseListener, MouseMotionListener {

	public ArrayList<Shape> shapes = new ArrayList<>();
	private volatile static Canvas instance;

	public Point startPoint;
	private int offsetX = 0;
	private int offsetY = 0;

	public Canvas() {
		this.setBackground(Color.white);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	public static Canvas getInstance() {
		if (instance == null) {
			instance = new Canvas();
		}
		return instance;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// 畫圖
		for (Shape shape : shapes) {
			shape.draw(g2d);
		}

		g2d.setColor(Color.BLACK);
		if (startPoint != null) {
			// 畫選取框框
			g2d.drawRect(startPoint.x, startPoint.y, offsetX, offsetY);
		}
	}

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ModeManager.getMode().mouseClicked(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		ModeManager.getMode().mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		ModeManager.getMode().mouseReleased(e);
	}

	public void mouseDragged(MouseEvent e) {
		ModeManager.getMode().mouseDragged(e);
	}

	public Shape checkIsInside(MouseEvent e) {
		boolean found = false;
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (found == false & shapes.get(i).isInside(e.getX(), e.getY())) {
				return shapes.get(i);
			}
		}
		return null;
	}

	// 會有黑框框
	public void selectObject(MouseEvent e) {
		boolean found = false;
		for (int i = shapes.size() - 1; i >= 0; i--) {
			if (found == false & shapes.get(i).isInside(e.getX(), e.getY())) {
				shapes.get(i).setSelected(true);
				found = true;
			} else
				shapes.get(i).setSelected(false);

		}
	}

	public void calculateSelectedArea(Point startPoint, Point endPoint) {
		if (startPoint != null & endPoint != null) {
			this.startPoint = new Point();
			this.startPoint.x = (int) Math.min(startPoint.getX(), endPoint.getX());
			this.startPoint.y = (int) Math.min(startPoint.getY(), endPoint.getY());
			offsetX = (int) Math.abs(startPoint.getX() - endPoint.getX());
			offsetY = (int) Math.abs(startPoint.getY() - endPoint.getY());
		} else {
			this.startPoint = startPoint;
			offsetX = 0;
			offsetY = 0;

		}
	}

	public void isContain(Point startPoint, Point endPoint) {
		for (Shape shape : shapes) {
			if (shape.isInside(startPoint, endPoint)) {
				shape.setSelected(true);
			} else {
				shape.setSelected(false);
			}
		}
	}

	public int countSelectedShapes() {
		int count = 0;
		for (Shape shape : shapes) {
			if (shape.getSelected()) {
				count++;
			}
		}
		return count;
	}

	// 添加設置選中 Shape 對象名稱的方法
	public void setSelectedShapesName(String name) {
		for (Shape shape : shapes) {
			if (shape.getSelected()) {
				shape.setName(name);
			}
		}
	}

	public void group() {
		ArrayList<Shape> Selectedshapes = new ArrayList<>();

		for (Shape shape : shapes) {
			if (shape.getSelected()) {
				Selectedshapes.add(shape);
			}
		}

		// 移除選中的形狀
		for (Shape shape : Selectedshapes) {
			shapes.remove(shape);
		}

		// 添加至 compositeObject
		addShape(new CompositeObject(Selectedshapes));
	}

	public void ungroup() {
		ArrayList<Shape> shapesToRemove = new ArrayList<>();
		ArrayList<Shape> childrenToAdd = new ArrayList<>();

		// 找到需要刪除的形狀，並將其子形狀添加到新列表中
		for (Shape shape : shapes) {
			if (shape.getSelected()) {
				childrenToAdd.addAll(shape.getChildren());
				shapesToRemove.add(shape);
			}
		}

		// 從形狀列表中移除選定的形狀
		shapes.removeAll(shapesToRemove);

		// 將子形狀添加回形狀列表中
		shapes.addAll(childrenToAdd);

	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
}