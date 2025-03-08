package component.basicObject;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import component.BasicObject;

public class ClassObject extends BasicObject {

    public ClassObject(int x, int y) {
        super(x, y, 140, 126);
        name = "Class";
    }

    @Override
    public void draw(Graphics2D g2d) {
        // 圖形
        // 繪製ClassObject(矩形+兩條線)
        g2d.setColor(Color.BLACK);
        // 抗鋸齒
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawRect(x, y, width, height);
        // 填滿白色
        g2d.setColor(Color.lightGray);
        g2d.fillRect(x + 1, y + 1, width - 1, height - 1);

        g2d.setColor(Color.BLACK);
        g2d.drawLine(x, y + height / 3, x + width, y + height / 3);
        g2d.drawLine(x, y + 2 * height / 3, x + width, y + 2 * height / 3);

        FontMetrics metrics = g2d.getFontMetrics();
        g2d.drawString(name, x + (width - metrics.stringWidth(name)) / 2,
                y + (height - metrics.getHeight()) / 2 + metrics.getAscent());

        if (isSelected) {
            showPort(g2d);
        }
    }
}
