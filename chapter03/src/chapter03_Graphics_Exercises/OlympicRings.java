package chapter03_Graphics_Exercises;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class OlympicRings {

	public void draw(Graphics2D g2) {
		// TODO Auto-generated method stub
	    
		Ellipse2D.Double ring1 = new Ellipse2D.Double(0, 0, 100, 100);
	    Ellipse2D.Double ring2 = new Ellipse2D.Double(100, 0, 100, 100);
	    Ellipse2D.Double ring3 = new Ellipse2D.Double(200, 0, 100, 100);
	    Ellipse2D.Double ring4 = new Ellipse2D.Double(0, 0, 100, 100);
	    Ellipse2D.Double ring5 = new Ellipse2D.Double(0, 0, 100, 100);
	    
	    g2.setColor(Color.BLUE);
	    g2.draw(ring1); 
	    g2.setColor(Color.BLACK);
	    g2.draw(ring2); 
	    g2.setColor(Color.RED);
	    g2.draw(ring3); 
	}
	
}
