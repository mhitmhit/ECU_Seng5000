package A2_Q3;
/**
   A cash register totals up sales and computes change due.
*/
public class CashRegister
{
   private double purchase;
   private double payment;
   private String receipt="Purchased Items: ";

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
      receipt = receipt.concat(String.valueOf(amount))+", ";
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
    * Prints price of all purchased items and total amount due.
    */
   public void printReceipt()
   {
	   System.out.println(receipt);
	   System.out.println("the total amount due is: "+ purchase);
   }
}
