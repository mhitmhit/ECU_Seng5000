package chapter03_Excercises;
public class CounterDemo
{
   public static void main(String[] args)
   {
      Counter tally = new Counter();
      tally.click();
     tally.click();
     tally.undo();
     tally.undo();
     tally.undo();
     tally.undo();
     tally.click();
      int result = tally.getValue(); // Sets result to 2
      System.out.print("result: ");
      System.out.println(result);
   }
}
