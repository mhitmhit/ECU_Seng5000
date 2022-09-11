package chapter03_Graphics_Exercises;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import javax.swing.JComponent;

public class TargetComponent extends JComponent {
	
	public int calculateCenter(int circleDim) {
		int value = 250 - (circleDim/2);
		return value;
	}
	
	public void paintComponent(Graphics g)
	   {
	      Graphics2D g2 = (Graphics2D) g;

	      Ellipse2D.Double circle1 = new Ellipse2D.Double(calculateCenter(300), calculateCenter(300), 300, 300);
	      Ellipse2D.Double circle2 = new Ellipse2D.Double(calculateCenter(200), calculateCenter(200), 200, 200);
	      Ellipse2D.Double circle3 = new Ellipse2D.Double(calculateCenter(100), calculateCenter(100), 100, 100);
	      
	      g2.setColor(Color.YELLOW);
	      g2.fill(getBounds());
	      
	      g2.draw(circle1);
	      g2.draw(circle2);
	      g2.draw(circle3);
	      
	      g2.setColor(Color.BLACK);
	      g2.fill(circle1);
	      g2.setColor(Color.WHITE);
	      g2.fill(circle2);
	      
	      g2.setColor(Color.BLACK);
	      g2.fill(circle3);
	      
	      
	      
	      
	      
	      
	      //Point2D.Double boardCenter = new Point2D.Double(250,250);
//	      Line2D.Double centerPoint = new Line2D.Double(boardCenter, boardCenter);
//	      g2.draw(centerPoint);
	      
	      
//	      // top of car reference points
//	      Point2D.Double r1 = new Point2D.Double(20,10);
//	      Point2D.Double r2 = new Point2D.Double(40,10);
//	      Point2D.Double r3 = new Point2D.Double(10,20);
//	      Point2D.Double r4 = new Point2D.Double(50,20);
//	      
//	      // car roof
//	      Line2D.Double roof = new Line2D.Double(r1, r2);
//	      g2.draw(roof);
//	      
//	      // car front windshield
//	      Line2D.Double frontWind = new Line2D.Double(r1, r3);
//	      g2.draw(frontWind);
//	      
//	      // car rear windshield
//	      Line2D.Double rearWind = new Line2D.Double(r2, r4);
//	      g2.draw(rearWind);
//	      
//	      // car chasis
////	      Rectangle box1 = new Rectangle(0, 20, 60, 10);
////	      g2.draw(box1);
	      
	      // wheels
	      
	   
	      
	   }
	
}