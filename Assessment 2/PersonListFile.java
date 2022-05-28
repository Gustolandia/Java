/*Author: Gustavo Pedro Ricou                          */

import java.io.*;
import java.util.*;

public class PersonListFile
{
   public static void main (String args []) throws FileNotFoundException, IOException
   
   {
      Scanner KeyboardIn = new Scanner (System.in);
      FileOutputStream fos = new FileOutputStream ("PersonList.txt");
      ObjectOutputStream oos = new ObjectOutputStream (fos);
      ArrayList <Person> personList = new ArrayList <>();
      int pps, age, height, weight;
      String name, occupation;
      char answer='y';
      char gender;
      
      do
      {
         try{
            System.out.print ("Enter pps number: ");
            pps=KeyboardIn.nextInt();
            System.out.print("Enter name: "); 
            name=KeyboardIn.next();   
            do{
               System.out.print ("Enter age: ");
               age=KeyboardIn.nextInt();
               if(age<0){
                   System.out.print ("Positive age please! ");

                  }
               }
            while(age<0);
            System.out.print("Enter gender (m/f/o): "); 
            gender=KeyboardIn.next().charAt(0);
            do{
               System.out.print ("Enter height: ");
               height=KeyboardIn.nextInt();
               if(height<0){
                   System.out.print ("Height above 0 please!");

                  }
               }
            while(height<=0); 

            do{
               System.out.print ("Enter weight: ");
               weight=KeyboardIn.nextInt();
               if(weight<=0){
                   System.out.print ("Weight above 0 please!");

                  }
               }
            while(weight<=0);
            System.out.print("Enter occupation: "); 
            occupation=KeyboardIn.next(); 

            personList.add(new Person(pps, name, age, gender, height, weight, occupation));
            System.out.print("Enter another person? (y/n)"); 
            answer=KeyboardIn.next().charAt(0);
         }
         catch(InputMismatchException er){
            System.out.println("Integer values only, enter again");
            KeyboardIn.nextLine();
            continue; 
         }
         catch(IllegalArgumentException er){
            System.out.println(er);
            KeyboardIn.nextLine();
            continue;
         }
      }
      while (answer=='y' || answer=='Y');
      
      oos.writeObject(personList);
      System.out.println("File successfully created");
      oos.close(); 
   }   
}