package component;

public class Port {
    private int x;
    private int y;
    private int length = 10;

    public Port(int x, int y) {
    	this.x = x;
    	this.y = y;
    }
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }
    
    public int getLength() {
    	return this.length;
    }

	public void move(int offsetX, int offsetY) {
    	this.x += offsetX;
    	this.y += offsetY;
	}
}