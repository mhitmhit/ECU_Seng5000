package chapter02;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

class NameComponent extends JComponent
{
   public void paint(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;

      g2.setColor(Color.BLUE);
      Rectangle box = new Rectangle(25, 25, 100, 50);
      g2.draw(box);

      g2.setColor(Color.RED);
      g2.drawString("testing testereeer", 40, 50);
   }
}