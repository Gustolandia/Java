// Practical 6
// Author: Gustavo Ricou
// Date: 30/01/21
// Program to write mm of rain in a year
//Question 5 and 5

import java.util.*;
public class testcircle{
   public static void main(String [] args){
      Scanner keyboardIn = new Scanner (System.in);
      System.out.print("State the radius: ");
      double radius = keyboardIn.nextDouble();
      circle myCircle= new circle();
      myCircle.setRadius(radius);
      double circumference=myCircle.getCircumference();
      double area=myCircle.getArea();
      System.out.print("The area for your circle with radius "+ radius+ " is "+area+"and the circumference is "+circumference);

      }
   }     