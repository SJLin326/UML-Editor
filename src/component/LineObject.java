package component;

import java.awt.Graphics2D;

public abstract class LineObject extends Shape {

    protected Port startPort;
    protected Port endPort;

	public LineObject(Port startPort, Port endPort) {
		super(startPort, endPort);

		this.startPort = startPort;
		this.endPort = endPort;
	}

	@Override
	public void draw(Graphics2D g2d) {}
}