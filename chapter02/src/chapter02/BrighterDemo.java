package chapter02;

import java.awt.Color;
import javax.swing.JFrame;

public class BrighterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame();
		frame.setSize(200, 200);
		
		Color myColor = new Color(0, 0, 204) ;
		
		frame.getContentPane().setBackground(myColor);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
	}

}
