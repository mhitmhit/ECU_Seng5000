package chapter03_Excercises;
/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
   private double purchase;
   private double payment;
   private double totalSales = 0;
   private double salesCount = 0;

   /**
      Constructs a cash register with no money in it.
   */
   public CashRegister()
   {
      purchase = 0;
      payment = 0;
   }

   /**
      Records the sale of an item.
      @param amount the price of the item
   */
   public void recordPurchase(double amount)
   {
      purchase = purchase + amount;
      totalSales = totalSales + amount;
      salesCount = salesCount + 1;
   }

   /**
      Processes a payment received from the customer.
      @param amount the amount of the payment
   */
   public void receivePayment(double amount)
   {
      payment = payment + amount;
   }

   /**
      Computes the change due and resets the machine for the next customer.
      @return the change due to the customer
   */
   public double giveChange()
   {   
      double change = payment - purchase;
      purchase = 0;
      payment = 0;
      return change;
   }
   
   /**
    * reset daily sales count
    */
   public void reset()
   {
	   totalSales = 0;
	   salesCount = 0;
	   purchase = 0;
	   payment = 0;
   }
   
   /**
    * get daily total sales
    */
   public double getTotalSales()
   {
	   return totalSales;
   }
   
   /**
    * get daily sales count
    */
   public double getSalesCount()
   {
	   return salesCount;
   }
}
