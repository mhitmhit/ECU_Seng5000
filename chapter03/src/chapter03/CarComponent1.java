package chapter03;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


import javax.swing.JComponent;

public class CarComponent1 extends JComponent {
	public void paint(Graphics g)
	   {
	      Graphics2D g2 = (Graphics2D) g;
	      
	      // top of car reference points
	      Point2D.Double r1 = new Point2D.Double(20,10);
	      Point2D.Double r2 = new Point2D.Double(40,10);
	      Point2D.Double r3 = new Point2D.Double(10,20);
	      Point2D.Double r4 = new Point2D.Double(50,20);
	      
	      // car roof
	      Line2D.Double roof = new Line2D.Double(r1, r2);
	      g2.draw(roof);
	      
	      // car front windshield
	      Line2D.Double frontWind = new Line2D.Double(r1, r3);
	      g2.draw(frontWind);
	      
	      // car rear windshield
	      Line2D.Double rearWind = new Line2D.Double(r2, r4);
	      g2.draw(rearWind);
	      
	      // car chasis
	      Rectangle box1 = new Rectangle(0, 20, 60, 10);
	      g2.draw(box1);
	      
	      // wheels
	      Ellipse2D.Double frontTire = new Ellipse2D.Double(10, 30, 10, 10);
	      g2.draw(frontTire);
	      Ellipse2D.Double rearTire = new Ellipse2D.Double(40, 30, 10, 10);
	      g2.draw(rearTire);
	      Ellipse2D.Double rearTire2 = new Ellipse2D.Double(70, 30, 10, 10);
	      g2.draw(rearTire2);
	   }
	
}
