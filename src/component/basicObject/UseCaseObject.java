package component.basicObject;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import component.BasicObject;

public class UseCaseObject extends BasicObject {

    public UseCaseObject(int x, int y) {
        super(x, y, 160, 80);
        this.name = "UseCase";
    }

    @Override
    public void draw(Graphics2D g2d) {

        g2d.setColor(Color.BLACK);
        // 抗鋸齒
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 繪製橢圓形
        g2d.drawOval(x, y, width, height);

        g2d.setColor(Color.lightGray);
        // 填充
        g2d.fillOval(x + 1, y + 1, width - 1, height - 1);

        g2d.setColor(Color.BLACK);
        FontMetrics metrics = g2d.getFontMetrics();
        g2d.drawString(name, x + (width - metrics.stringWidth(name)) / 2,
                y + (height - metrics.getHeight()) / 2 + metrics.getAscent());

        if (isSelected) {
            showPort(g2d);
        }
    }
}
