// Practical 6
// Author: Gustavo Ricou
// Date: 30/01/21
// Program to write mm of rain in a year
//Question 5 and 5

import java.util.*;

public class testmortgage{
   public static void main(String [] args){
      
      Scanner keyboardIn = new Scanner (System.in);
      mortgage homeLoan= new mortgage("23 Main Street", 100000.0, 70000.);
      int option=-1;
      while (option!=0){
         System.out.print("Choose your option:\n 1.View All Mortgage Details\n 2.View Remaining Balance\n 3.Make a Payment on Mortgage\n 4.Top Up Mortgage\n 5.View Monthly Repayments\n 0.Exit System\n Choose here: ");
         
         option = keyboardIn.nextInt();
         switch (option){
            case 1:
               System.out.println("Your account number "+homeLoan.getAccount()   +" has a balance of "+homeLoan.getBalance()+" and a property value of "+homeLoan.getPropertyValue());

               break;
            case 2:
               System.out.println("Your balance is "+homeLoan.getBalance());
               break;
            case 3:
               System.out.println("Please state how much you would like to repay:");
               double pay = keyboardIn.nextDouble();
               homeLoan.makePayment(pay);
               
               break;
            case 4:
               System.out.println("Please state how much you would like to indebt yourself more:");
               double debt = keyboardIn.nextDouble();
               homeLoan.topUp(debt);

               break;
            case 5:
               System.out.println("Your monthly repayment is: "+homeLoan.monthlyRepayment());

               break;
            case 0:
               System.out.println("Exiting...");
               break;
            default:
               System.out.println("Please insert a valid option");
            }
         }
      }
   }     