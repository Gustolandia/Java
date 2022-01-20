// Practical 2
// Author: Gustavo Ricou
// Date: 08/12/21
// Program to write Hello World to screen

//Question 2

import java.util.*;
public class temperature{
   public static void main(String [] args){
      Scanner keyboardIn = new Scanner (System.in);
      System.out.print("State the temperatures of the last seven days\n");
      float temp;
      int cold=0;
      int mild=0;
      int hot=0;
      for (int i=0; i<7; i++){
         System.out.print("Temperature in day "+(i+1)+": ");
         
         temp = keyboardIn.nextFloat();
         System.out.print("Thank you! \n");
         if (temp<=6){
            cold++;
         }
         else if(temp>6&&temp<14){
            mild++;
         }
         else{
            hot++;
         }
      }
      System.out.print("Cold days:"+cold+"\n Mild days"+mild+"\n Hot days:"+hot);
      }
   }     