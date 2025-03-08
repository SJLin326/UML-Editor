package component;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public abstract class Shape {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	// protected String name;

	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Shape() {
	}

	public Shape(Port startPort, Port endPort) {
	}

	public void setName(String newName) {
	}

	public abstract void draw(Graphics2D g2d);

	public Boolean isInside(int x, int y) {
		return false;
	}

	public void setSelected(Boolean isSelected) {
	}

	public Port findNearestPort(int x, int y) {
		return null;
	}

	public Boolean isInside(Point startPoint, Point endPoint) {
		return false;
	}

	public void move(int offsetX, int offsetY) {
	}

	public boolean getSelected() {
		return false;
	}

	public ArrayList<Shape> getChildren() {
		return null;
	}
}