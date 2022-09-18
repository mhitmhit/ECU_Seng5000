package A2_Q2;

import java.awt.Rectangle;

public class AddTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Create a rectangle box with upper left corner x=5, y=10, width=20, height=30
		 * 
		 */
		Rectangle box = new Rectangle(5, 10, 20, 30);
		
		/**
		 * Adds a point, specified by the integer arguments newx,newy to the bounds of this Rectangle. 
		 */
		box.add(0, 0);
		
		/**
		 * Printing expected Values
		 */
		// rectangle new upper left corner will be 0, 0
		System.out.println("the expected x value of upper corner of rectangle is: 0" );
		System.out.println("the expected  value of upper corner of rectangle is: 0" );
		// new width of the triangle will be: 20 + 5 =25;
		System.out.println("the expected Width of the rectangle is: 25" );
		// new Height of the triangle will be: 30 + 10 = 40;
		System.out.println("the expected Height of the rectangle is: 40" );
		
		
		/**
		 * Printing actual Values
		 */
		System.out.println("the actual x value of upper corner of rectangle is: " + box.getX() );
		System.out.println("the actual  value of upper corner of rectangle is: " + box.getY());
		System.out.println("the actual Width of the rectangle is: " + box.getWidth() );
		System.out.println("the actual Height of the rectangle is: " + box.getHeight() );
	}

}
