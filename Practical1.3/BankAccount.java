/* Bank Account Class
Author: Clare Doherty
Class representing a Bank Account */

public class BankAccount
{
   //declare instance variables
   private int accNum;
   private String custName;
   private double balance;
   
   //Constructor
   public BankAccount()
   {
      accNum = 0;
      custName = "";
      balance = 0.00;
   }
   
   public BankAccount(int num, String name, double bal)
   {
      accNum = num;
      custName = name;
      balance = bal;
   }
   //Methods
   //set Account number
   public void setAccNum(int num)
   {
      accNum= num;
   }
   
   //Get Account number
   public int getAccNum()
   {
      return accNum;
   }
   //set Customer Name
   public void setCustName(String name)
   {
      custName = name;
   }
   
   //Get Account name
   public String getCustName()
   {
      return custName;
   }
   
   //set Balance
   public void setBalance(double bal)
   {
      balance = bal;
   }
   
   //View Balance
   public double viewBalance()
   {
      return balance;
   }
   
   //Deposit Money
   public void depositMoney(double amount)
   {
      balance = balance + amount;
   }
   
   //Withdraw Money
   public void withdrawMoney(double amount)
   {
      if(balance > amount)
      {
         balance = balance - amount;
      }
      else
      {  
         System.out.println("You have insufficient funds to withdraw €" +amount);
      }
   }
   
   public String toString()
   {
      return "Acc Number: "+accNum+ "\t Customer Name: "+custName+ "\t Balance €"+balance;
   }
}//close class