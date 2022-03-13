// Exam 2
// Author: Gustavo Ricou
// Date: 27/02/21
// Student number: L00170136

import java.util.*;

public class testAirBnBBooking{
   public static void main(String [] args){
      Scanner keyboardIn = new Scanner (System.in);
      System.out.print("Start your Booking. State the year of your arrival: "); //splitting the date into 3 values for easier execution
      int year = keyboardIn.nextInt();
      System.out.print("\nState the month of your arrival (1-12): ");
      int month = keyboardIn.nextInt();
      while (month>12 || month<1){ //months must be between 1 and 12
         System.out.print("\nWrong value! State the month of your arrival (1-12): ");
         month = keyboardIn.nextInt();
         }
      System.out.print("\nState the day of your arrival: ");
      int day = keyboardIn.nextInt();
      while (day>31 || day<1){ //some restrictions regarding input of days 
         System.out.print("\nWrong value! State the day of your arrival: ");
         day = keyboardIn.nextInt();
         }
      System.out.print("\nHow many nights are you staying? ");
      int nights = keyboardIn.nextInt();
      while (nights<1){ //nights must be positive
         System.out.print("\nWrong value! State the number of nights: ");
         nights = keyboardIn.nextInt();
         }
      keyboardIn.nextLine();
      System.out.print("\nWhat is the address of the property? ");
      String address = keyboardIn.nextLine();
      
      System.out.print("\nWhat are the number of guests? ");
      int guests = keyboardIn.nextInt();
      while (guests>20 || guests<1){ //restrictions on number of guests
         System.out.print("\nWrong value! State the number of guests (max 20): ");
         guests = keyboardIn.nextInt();
         }
      System.out.print("\nWhat is the cost per night? ");
      double cost = keyboardIn.nextDouble();
      while (cost<0.0){ //cost must be positive
         System.out.print("\nWrong value! State the cost per night: ");
         cost = keyboardIn.nextDouble();
         }
      System.out.println("\nWould you like to decalre the property type or if it allows pets? Choose one option.\n 1. Declare property type; \n 2. Declare pet. \n 3. Declare both. \n 4. Declare none");
      int choice = keyboardIn.nextInt();//It is optional for the user to declare pets allowed or property type
      while (choice!=1&&choice!=2&&choice!=3&&choice!=4){
         System.out.println("\nWrong Choice! Would you like to decalre the property type or if it allows pets? Choose one option.\n 1.Declare property type; \n 2. Declare pet. \n 3. Declare both. \n 4. Decalre none");
         choice = keyboardIn.nextInt();
         }
      AirBnBBooking booking1; //Declaring the object
      switch (choice){ //Each of the options chosen by the user: declare pets, declare type of property or both or none
            case 1:
               keyboardIn.nextLine();
               System.out.print("\nWhat is property type? ");
               String type = keyboardIn.nextLine();
               booking1= new AirBnBBooking(day, month, year, nights, address, guests, cost, type);
               break;
            case 2:
               boolean pet;
               keyboardIn.nextLine();
               System.out.println("\nPets allowed? y or n? "); //converting y or n to boolean
               char t = keyboardIn.next().charAt(0);
               while (t!='y'&&t!='n'){
                  System.out.println("\nWrong letter! Pets allowed? y or n? Small letters! ");
                  t = keyboardIn.next().charAt(0);
                  }
               if (t=='y'){
                  pet=true;
                  }
               else{
                  pet=false;
                  }
               booking1= new AirBnBBooking(day, month, year, nights, address, guests, cost, pet);
               break;
            case 3: //case1+case2
               boolean pet2;
               keyboardIn.nextLine();
               System.out.println("\nWhat is property type? ");
               String type2 = keyboardIn.nextLine();
               System.out.print("Pets allowed? y or n? ");
               char t2 = keyboardIn.next().charAt(0);
               while (t2!='y'&&t2!='n'){
                  System.out.print("\nWrong letter! Pets allowed? y or n? Small letters! ");
                  t2 = keyboardIn.next().charAt(0);
                  }
               if (t2=='y'){
                  pet2=true;
                  }
               else{
                  pet2=false;
                  }

               booking1= new AirBnBBooking(day, month, year, nights, address, guests, cost, type2, pet2);

               break;
            default:
               booking1= new AirBnBBooking(day, month, year, nights, address, guests, cost);
         } 
           
      
      System.out.println("\nThank you. Let us proceed.");

      int option=-1;
      while (option!=0){ //menu that was in the exam that needed to be included
         System.out.println("\nChoose your option:\n 1.View Booking Details\n 2.Change Number of Nights\n 3.View Price Per Guest\n 4.View Total Price\n 5.Check if Pets are Allowed\n 0.Exit \n Choose here: ");
         
         option = keyboardIn.nextInt();
         switch (option){
            case 1:
               System.out.println(booking1.toString());
               break;
            case 2:
               System.out.println("Please state the new number of nights: ");
               int n = keyboardIn.nextInt();
               booking1.setNights(n);
               break;
            case 3:
               System.out.println("Price per guest is: "+booking1.getCostPerGuest());
               break;
            case 4:
               System.out.println("Total price is: "+booking1.getTotal());
               break;
            case 5:
               boolean t= booking1.getPet();
               if(t){
                  System.out.println("Pets allowed");
                  }
               else{
                  System.out.println("Pets not allowed");
               } 
               break;
            case 0:
               System.out.println("Exiting...");
               break;
            default:
               System.out.println("Please insert a valid option");
            }
         }
      }
   }     