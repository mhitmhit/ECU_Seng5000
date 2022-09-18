package chapter02;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

public class TwoSquareComponent extends JComponent {
	public void paint(Graphics g)
	   {
	      Graphics2D g2 = (Graphics2D) g;

	      Rectangle box1 = new Rectangle(0, 100, 100, 100);
	      
	      box1.add(0, 10);
	      g2.draw(box1);
	      
	      Rectangle box2 = new Rectangle(50, 50, 50, 50);
	      //g2.draw(box2);
	   }
	
}
