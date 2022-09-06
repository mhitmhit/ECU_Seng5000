package chapter02;

import javax.swing.JFrame;

public class NameViewer
{
   public static void main(String[] args)
   {
      // Initialize Frame
      JFrame window = new JFrame();

      // Start Frame
      window.setSize(400, 300);
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // Draw Component
      window.add(new NameComponent());

      window.setVisible(true);
   }
}
