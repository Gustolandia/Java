// Practical 1.1
// Author: Gustavo Ricou
// Date: 13/03/21
// Program to write mm of rain in a year
//Question 3 and 4 and 5

import java.util.*;

public class computerTest{
   public static void main(String [] args){
      
      Scanner keyboardIn = new Scanner (System.in);
      ArrayList <ComputerGame>  gameList = new ArrayList <ComputerGame>();
      gameList.add( new ComputerGame("Heavy Rain", 2010, 39.99));
      gameList.add( new ComputerGame("Red Dead Redemption", 2010, 45.99));
      gameList.add( new ComputerGame("Mass Effect 2 ", 2009, 35.99));
      gameList.add( new ComputerGame("Batman Arkham Asylum", 2019, 19.99));
      gameList.add( new ComputerGame("Fable 2", 2008, 11.99));
      
      
      for (ComputerGame g: gameList){
         System.out.println(g);  
         }

      int option=-1;
      int year=0;
      double max=0.0;
      double min=10000.0;
      String gameMax="";
      String gameMin="";
      while (option!=0){
         System.out.print("\nChoose your option:\n 1.Choose a year to see the games \n 2.See most expensive and least expensive game\n 0.Exit System\n Choose here: ");
         
         option = keyboardIn.nextInt();
         
         switch (option){
            case 1:
               System.out.print("Please insert a year:");
               year = keyboardIn.nextInt();
               System.out.println("\n\nThe titles published in "+year+" are");
               for (ComputerGame g: gameList){
                  if(g.getYear()==year){
                  
                     System.out.println(g.getTitle());
                     }  
                  }
               System.out.println("\n");
               break;
            case 2:
               for (ComputerGame g: gameList){
                  if (g.getPrice()>max){
                     max=g.getPrice();
                     gameMax=g.getTitle();
                     }
                  if(g.getPrice()<min){
                     min=g.getPrice();
                     gameMin=g.getTitle();
                     }
                   
                  }
               System.out.println("The most expensive game is "+ gameMax);
               System.out.println("The least expensive game is "+ gameMin);      
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