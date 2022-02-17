// Practical 6
// Author: Gustavo Ricou
// Date: 30/01/21
// Program to write mm of rain in a year
//Question 5 and 5


public class testemployee{
   public static void main(String [] args){

      employee myEmp1= new employee();
      System.out.println(myEmp1.viewDetails());
      employee myEmp2= new employee(3567, "Brendan Doherty", 50000.0);
      System.out.println(myEmp2.viewDetails());
      employee myEmp3= new employee(1525, "John Smith", 55000.0, "Plumber");      
      System.out.println(myEmp3.viewDetails());
      myEmp3.reduceSalary(3000);
      System.out.println(myEmp3.viewDetails());
      System.out.print(myEmp3.getMonthlyWage());
      }
   }     