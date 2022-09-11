package chapter03_Graphics_Exercises;

import javax.swing.JFrame;

public class OlympicRingsViewer {
	public static void main(String[] args)
	   {
	      JFrame frame = new JFrame();

	      frame.setSize(300, 400);
	      frame.setTitle("Olympic rings");
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      OlympicRingsComponent component = new OlympicRingsComponent();
	      frame.add(component);

	      frame.setVisible(true);
	   }
}
