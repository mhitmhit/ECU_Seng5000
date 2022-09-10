package chapter03_Excercises;
/**
   A class to test the CashRegister class.
*/
public class CashRegisterTester
{
   public static void main(String[] args)
   {
      

      

      // day 1
      System.out.println("day 1");      
      
      CashRegister register = new CashRegister();
      register.recordPurchase(20);
      register.recordPurchase(10);
      register.recordPurchase(20);
      register.recordPurchase(10);
      register.recordPurchase(20);
      register.recordPurchase(10);
      register.recordPurchase(10);
      
      System.out.println("Expected daily sales is 100: " + register.getTotalSales()); 
      System.out.println("Expected Sales count is 7: " + register.getSalesCount()); 
      
      // day 2
      register.reset();
      register.recordPurchase(20);
      register.recordPurchase(10);
      System.out.println("Expected daily sales is 30: " + register.getTotalSales()); 
      System.out.println("Expected Sales count is 2: " + register.getSalesCount()); 
      
   }
}
