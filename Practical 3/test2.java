// Practical 2
// Author: Gustavo Ricou
// Date: 08/12/21
// Program to write Hello World to screen

//Question 2

import java.util.*;
public class test2{
   public static void main(String [] args){
      Scanner keyboardIn = new Scanner (System.in);
      System.out.print("Enter your ship category: ");
      char category = keyboardIn.next().charAt(0);
      switch (category)
      {
         case 'B':
         case 'b':System.out.print("Battleship");
            break; 
         
         case 'C':
         case 'c':System.out.print("Cruiser");
            break;
         
         case 'D':
         case 'd':System.out.print("Destroyer"); 
            break;
         
         case 'E':
         case 'e':System.out.print("Frigate");
            break;
            
         default:System.out.print("No such ship found"); 
         
            }
      }
   }     