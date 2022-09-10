package chapter03;

import javax.swing.JFrame;

public class CarViewer1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// program that draws two squares with same center
		// Initialize Frame
	      JFrame window = new JFrame();

	      // Start Frame
	      window.setSize(400, 400);
	      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      // Draw Component
	      window.add(new CarComponent1());

	      window.setVisible(true);
	}
}




