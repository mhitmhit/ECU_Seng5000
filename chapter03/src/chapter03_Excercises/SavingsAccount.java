package chapter03_Excercises;
/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
   this is the bank account class file
*/
public class SavingsAccount
{  
   private double balance;
   private double interest;

   /**
      Constructs a bank account with a zero balance.
   */
   public SavingsAccount()
   {   
      balance = 0;
      interest = 0;
   }

   /**
      Constructs a bank account with a given balance.
      @param initialBalance the initial balance
   */
   public SavingsAccount(double initialBalance, double interestRate)
   {   
      balance = initialBalance;
      interest = interestRate;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount)
   {  
      balance = balance + amount;
   }
   
   /**
    	add interest to the account
    */
   public void addInterest()
   {
	   balance = balance + (balance * (interest/100));
   }
 
   

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {   
      balance = balance - amount;
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {   
      return balance;
   }
}
