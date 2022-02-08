// Practical 6
// Author: Gustavo Ricou
// Date: 30/01/21
// Program to write mm of rain in a year
//Question 5 and 5

import java.util.*;
public class circle{
   private double radius;
   public static final double PI= 3.14;  
   
   public circle(){
      radius=0.0;
      }
   public double getRadius(){
      return radius;
      }
   public void setRadius(double r){
      radius=r;
      }
   public double getCircumference(){
      return 2*PI*radius;
      }
   public double getArea(){
      return PI*radius*radius;
      }
   }   