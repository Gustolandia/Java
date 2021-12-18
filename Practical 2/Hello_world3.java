// Practical 2
// Author: Gustavo Ricou
// Date: 08/12/21
// Program to write Hello World to screen

//Question 1

import java.util.*;
public class Hello_world3{
   public static void main(String [] args){
      Scanner meh= new Scanner(System.in);
      double euro, rate, result;
      System.out.print("Amount in Euros:");
      euro = meh.nextDouble();
      System.out.print("Conversion rate:");
      rate = meh.nextDouble();
      result=rate*euro;
      System.out.print("The value in your currency is "+result);

      }
   }     