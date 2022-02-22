// Practical 9A
// Author: Gustavo Ricou
// Date: 21/02/21




public class mortgage{
   private int accountNumber;
   private static int nextAccNo = 1;
   private String propertyAddress;
   private double propertyValue;
   private double balance;
   private int mortgageTerm;
   
      
   public mortgage(String a, double v, double b){
      accountNumber=nextAccNo;
      nextAccNo+=1;
      propertyAddress=a;
      propertyValue=v;
      balance=b;
      mortgageTerm=25;
      }
      
   public double getAccount(){
      return accountNumber;
      }    
   public double getBalance(){
      return balance;
      }
      
   public double getPropertyValue(){
      return propertyValue;
      }
         
   public void makePayment(double p){
      balance-=p;
      }
   public void topUp(double p){
      balance+=p;
      }
   public double monthlyRepayment(){
      return balance/(25*12);
      }
   
   }   