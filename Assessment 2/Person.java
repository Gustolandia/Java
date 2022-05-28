/*Class to represent attributes of Person object
To be used for Assignment 2
Author: Gustavo Pedro Ricou                          */

import java.io.*;
import java.util.*;


public class Person implements Serializable
{
   //instance variables
   private int pps;
   private String name;
   private int age;
   private char gender;
   private int height;
   private int weight;
   private String occupation;
   
   private static ArrayList <Integer> ppss = new ArrayList <Integer>(); //the arraylist of all pps
   
   
   //Constructors
   
   public Person(int p, String n, int a, char g, int h, int w, String o) throws IllegalArgumentException
   {
      if (ppss.contains(p)) { //unique pps
         throw new IllegalArgumentException("pps must be unique. Person not created. Try again.");
      }
      else if(a<0||h<=0||w<=0){
         throw new IllegalArgumentException("age "+age+ " cannot be negative, height "+height+" and weight "+weight+" have to be above 0. Person not created. Try again.");
      }
      else{
         pps = p;
         ppss.add(pps);
         name = n;
         age = a;
         gender = g;
         height = h;
         weight = w;
         occupation= o;
         }
   }
   
   //Methods
   public int getPps()
   {
      return pps;
   }
   
   public String getName()
   {
      return name;
   }
   
   public int getAge()
   {
      return age;
   }
   
   public char getGender()
   {
      return gender;
   }
   
   public int getHeight()
   {
      return height;
   }
   
   public int getWeight()
   {
      return weight;
   }   

   public String getOccupation()
   {
      return occupation;
   }
      
   public String toString() 
   {
		return "Pps: " + pps + "\nName: " + name + "\nAge: " + age + "\nGender: " + gender + "\nHeight: " + height + "\nWeight: " + weight + "\nOccupation: " + occupation;
	}
   
}