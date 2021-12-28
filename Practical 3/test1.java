// Practical 2
// Author: Gustavo Ricou
// Date: 08/12/21
// Program to write Hello World to screen

//Question 2

import java.util.*;
public class test1{
   public static void main(String [] args){
      Scanner keyboardIn = new Scanner (System.in);
      System.out.print("Enter your room temp: ");
      int temp = keyboardIn.nextInt();
      if( temp <0)
      {
         System.out.print("Freezing");
      }
      else if(temp >=0 && temp <=6)
      {
         System.out.print("Very Cold");
      }
      else if(temp >=7 && temp <=14)
     {
         System.out.print("Warm");
      }
      else if(temp >=15 && temp <=21)
      {
         System.out.print("Hot");
      }
      else
      {
         System.out.print("Very Hot");
      }
      }
   }     