package chapter03_Excercises;
/**
   This class models a tally counter.
*/
public class Counter
{
   private int value;

   /**
      Gets the current value of this counter.
      @return the current value
   */
   public int getValue()
   {
      return value;
   }

   /**
      Advances the value of this counter by 1.
   */
   public void click() 
   {
      value = value + 1;
   }

   /**
      Resets the value of this counter to 0.
   */
   public void reset()
   {
      value = 0;
   }
   
   /**
      Reduces the value of this counter by -1.
    */
   
   public void undo()
   {
	   value = value - 1;
	   value = Math.max(value, 0);
   }
}
