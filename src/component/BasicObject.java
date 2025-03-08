package component;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public abstract class BasicObject extends Shape {

    protected String name;
    protected boolean isSelected = false;
    Port[] ports = new Port[4];

    public BasicObject(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;

        ports[0] = new Port(x + width / 2, y); // 上
        ports[1] = new Port(x, y + height / 2); // 左
        ports[2] = new Port(x + width, y + height / 2); // 右
        ports[3] = new Port(x + width / 2, y + height); // 下
    }

    public BasicObject() {
    }

    @Override
    public void move(int offsetX, int offsetY) {
        this.x += offsetX;
        this.y += offsetY;
        for (Port port : ports) {
            port.move(offsetX, offsetY);
        }
    }

    @Override
    public Boolean isInside(int x, int y) {
        if (this.x <= x & this.y <= y & this.x + width >= x & this.y + height >= y) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean isInside(Point startPoint, Point endPoint) {
        if (this.x >= Math.min(startPoint.getX(), endPoint.getX())
                & this.y >= Math.min(startPoint.getY(), endPoint.getY())
                & this.x + width <= Math.max(startPoint.getX(), endPoint.getX())
                & this.y + height <= Math.max(startPoint.getY(), endPoint.getY())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setSelected(Boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public boolean getSelected() {
        return this.isSelected;
    }

    public void showPort(Graphics2D g2d) {
        g2d.setColor(Color.BLACK);
        // 上
        g2d.fillRect(ports[0].getX() - ports[0].getLength() / 2, ports[0].getY() - ports[0].getLength(),
                ports[0].getLength(), ports[0].getLength());
        // 左
        g2d.fillRect(ports[1].getX() - ports[1].getLength(), ports[1].getY() - ports[1].getLength() / 2,
                ports[1].getLength(), ports[1].getLength());
        // 右
        g2d.fillRect(ports[2].getX(), ports[2].getY() - ports[2].getLength() / 2, ports[2].getLength(),
                ports[2].getLength());
        // 下
        g2d.fillRect(ports[3].getX() - ports[3].getLength() / 2, ports[3].getY(), ports[3].getLength(),
                ports[3].getLength());
    }

    @Override
    public Port findNearestPort(int x, int y) {
        Port nearestPort = null;
        double minDistance = Double.MAX_VALUE;
        for (Port port : ports) {
                double distance = Math.sqrt(Math.pow(port.getX() - x, 2) + Math.pow(port.getY() - y, 2));
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestPort = port;
                }
        }
        return nearestPort;
    }

    @Override
    public void setName(String newName) {
        this.name = newName;
    }

    public ArrayList<Shape> getChildren() {
        return null;
    }
}
