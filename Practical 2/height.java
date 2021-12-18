// Practical 2
// Author: Gustavo Ricou
// Date: 08/12/21
// Program to write Hello World to screen

//Question 8

import java.util.*;
public class height{
   public static void main(String [] args){
      Scanner meh= new Scanner(System.in);
      System.out.print("Your total height in feet:");
      double feetTotalDouble = meh.nextDouble();
      int feetTotal= (int)Math.round(feetTotalDouble);
      int feet=feetTotal%12;
      int inch=feetTotal/12;
      
      System.out.print("The value in of your height is "+inch+" inches and "+feet+" feet");

      }
   }     