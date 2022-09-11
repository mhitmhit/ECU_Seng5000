package chapter03_Graphics_Exercises;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class OlympicRingsComponent  extends JComponent
{  
	public OlympicRingsComponent() {
		
	}
	
   public void paintComponent(Graphics g)
   {  
      Graphics2D g2 = (Graphics2D) g;

      OlympicRings olym22 = new OlympicRings();
      
      olym22.draw(g2);         
   }
}