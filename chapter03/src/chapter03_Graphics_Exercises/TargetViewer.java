package chapter03_Graphics_Exercises;

import javax.swing.JFrame;


public class TargetViewer {
	{
	      JFrame frame = new JFrame();

	      frame.setSize(500, 500);
	      frame.setTitle("Target Practice");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      TargetComponent component = new TargetComponent();
	      frame.add(component);
	 
	      frame.setVisible(true);
	   }
}
