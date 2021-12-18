// Practical 2
// Author: Gustavo Ricou
// Date: 08/12/21
// Program to write Hello World to screen

//Question 8

import java.util.*;
public class areaCircle{
   public static void main(String [] args){
      Scanner meh= new Scanner(System.in);
      System.out.print("Your diameter:");
      double diameter = meh.nextDouble();
      final double PI=3.14;
      double area=PI*diameter*diameter/4;
      
      System.out.print("The are is "+area);

      }
   }     