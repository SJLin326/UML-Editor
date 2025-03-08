package component.Line;

import java.awt.Color;
import java.awt.Graphics2D;

import component.LineObject;
import component.Port;

public class CompositionLine extends LineObject {

	public CompositionLine(Port startPort, Port endPort) {
		super(startPort, endPort);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
        g2d.setColor(Color.BLACK);

        // 方向
        double angle = Math.atan2(endPort.getY() - startPort.getY(), endPort.getX() - startPort.getX());
        // 端點
        int arrowLength = 10;

        // 畫線
        g2d.drawLine(endPort.getX(), endPort.getY(), (int) (endPort.getX() - arrowLength * Math.cos(angle - Math.PI / 4)), (int) (endPort.getY() - arrowLength * Math.sin(angle - Math.PI / 4)));
        g2d.drawLine(endPort.getX(), endPort.getY(), (int) (endPort.getX() - arrowLength * Math.cos(angle + Math.PI / 4)), (int) (endPort.getY() - arrowLength * Math.sin(angle + Math.PI / 4)));
        g2d.drawLine((int) (endPort.getX() - arrowLength * Math.cos(angle) * Math.sqrt(2)), (int) (endPort.getY() - arrowLength * Math.sin(angle) * Math.sqrt(2)), (int) (endPort.getX() - arrowLength * Math.cos(angle - Math.PI / 4)), (int) (endPort.getY() - arrowLength * Math.sin(angle - Math.PI / 4)));
        g2d.drawLine((int) (endPort.getX() - arrowLength * Math.cos(angle) * Math.sqrt(2)), (int) (endPort.getY() - arrowLength * Math.sin(angle) * Math.sqrt(2)), (int) (endPort.getX() - arrowLength * Math.cos(angle + Math.PI / 4)), (int) (endPort.getY() - arrowLength * Math.sin(angle + Math.PI / 4)));
        g2d.drawLine(startPort.getX(), startPort.getY(),(int) (endPort.getX() - arrowLength * Math.cos(angle) * Math.sqrt(2)), (int) (endPort.getY() - arrowLength * Math.sin(angle) * Math.sqrt(2)));
	}	
}
