package chapter02;

import javax.swing.JFrame;

public class TwoSquareViewer {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// program that draws two squares with same center
		// Initialize Frame
	      JFrame window = new JFrame();

	      // Start Frame
	      window.setSize(400, 300);
	      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      // Draw Component
	      window.add(new TwoSquareComponent());

	      window.setVisible(true);
	}
}




