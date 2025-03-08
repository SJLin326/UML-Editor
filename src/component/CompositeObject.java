package component;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class CompositeObject extends BasicObject {

	ArrayList<Shape> children = new ArrayList<Shape>();

	public CompositeObject(ArrayList<Shape> selectedshapes) {
		for (Shape shape : selectedshapes) {
			children.add(shape);
		}
		calculatePosition();
	}

	@Override
	public void draw(Graphics2D g2d) {
		for (Shape shape : children) {
			if (this.getSelected() == true) {
				shape.setSelected(true);
			} else {
				shape.setSelected(false);
			}
			shape.draw(g2d);
		}
	}

	public ArrayList<Shape> getChildren() {
		return children;
	}

	@Override
	public void move(int offsetX, int offsetY) {
		for (Shape shape : children) {
			shape.move(offsetX, offsetY);
		}
		this.x += offsetX;
		this.y += offsetY;
	}

	private void calculatePosition() {

		// 初始化最小 x 和 y 值為第一個圖形
		this.x = children.get(0).x;
		this.y = children.get(0).y;

		// 找最小的(x, y)當作標
		for (Shape shape : children) {
			this.x = Math.min(this.x, shape.x);
			this.y = Math.min(this.y, shape.y);
		}

		// 計算寬高
		this.width = 0;
		this.height = 0;
		for (Shape shape : children) {
			this.width = Math.max(this.width, shape.x + shape.width - this.x);
			this.height = Math.max(this.height, shape.y + shape.height - this.y);
		}
	}

    @Override
    public Port findNearestPort(int x, int y) {
        return null;
    }

}
