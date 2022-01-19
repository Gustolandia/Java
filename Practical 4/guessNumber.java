// Practical 2
// Author: Gustavo Ricou
// Date: 08/12/21
// Program to write Hello World to screen

//Question 2

import java.util.*;
public class guessNumber{
   public static void main(String [] args){
      Scanner keyboardIn = new Scanner (System.in);
      System.out.print("Guess a number between 1 and 10\n");
      int number=10;
      while (number!=7){
      System.out.print("Enter your guess:");
      number = keyboardIn.nextInt();
      if (number!=7){
      System.out.print("\n Wrong!");
      }
      }
      System.out.print("Well done!");
      }
   }     