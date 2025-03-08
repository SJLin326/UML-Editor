package editor;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame frame = new MyFrame("UML Editor");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1024, 768);
		frame.setVisible(true);
	}
}