// Practical 6
// Author: Gustavo Ricou
// Date: 30/01/21
// Program to write mm of rain in a year
//Question 5 and 5

import java.util.*;
public class rain{
   public static void main(String [] args){
      Scanner keyboardIn = new Scanner (System.in);
      System.out.print("State the rain of the last 12 months in mm:\n");
      float[] rain= new float[12];

      for (int i=0; i<rain.length; i++){
         System.out.print("Insert rain of month "+(i+1)+":");
         rain[i] = keyboardIn.nextFloat();
         System.out.print("Thank you! \n");
         }
      int i2=0;
      for (int i=0; i<rain.length; i++){
         if (rain[i]>60){
            System.out.print("Month "+(i+1)+" had more than 60 mm of rain.\n");
            i2+=1;
            }
         }
      System.out.print("There are "+i2+" months that have 60mm or more rain.\n");

      }
   }     