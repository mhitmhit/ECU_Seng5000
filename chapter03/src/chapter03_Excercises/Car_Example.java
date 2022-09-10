package chapter03_Excercises;

import javax.swing.JFrame;


public class Car_Example {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// program that draws two squares with same center
		// Initialize Frame
	      JFrame window = new JFrame();

	      // Start Frame
	      window.setSize(400, 300);
	      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      // Draw Component
	      window.add(new Component_Example());

	      window.setVisible(true);
	}
}
