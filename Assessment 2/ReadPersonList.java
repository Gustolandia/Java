/*Author: Gustavo Pedro Ricou                          */


import java.io.*;
import java.util.*;

public class ReadPersonList
{
   public static void main(String args[]) throws IOException, ClassNotFoundException
   {
      //Create objects to read from file
      FileInputStream PersonFile = new FileInputStream("PersonList.txt");
      ObjectInputStream readPersonFile = new ObjectInputStream(PersonFile);
      
      //Read ArrayList from file
      ArrayList<Person> personList = (ArrayList<Person>) readPersonFile.readObject();
  
      Scanner keyboardIn = new Scanner (System.in);

      
      readPersonFile.close();
      
      int option=6;
      int pps;
      String occupation;
      do
      {  
         try{
            //Display Menu
            System.out.println("\n1. View all Persons");
            System.out.println("2. ViewPerson by PPS");
            System.out.println("3. View number of males and females on file");
            System.out.println("4. Calculate average age of persons on file");
            System.out.println("5. Search by occupation to create a new file Occupation.txt");
            System.out.println("0. Exit System\n");
            System.out.print("Enter your option: ");
            option = keyboardIn.nextInt();
            
            switch(option)
            {
               case 0:
               System.out.print("\nExiting...");
               break;
               
               case 1:
               viewPersons(personList); //call method viewPersons and pass it the ArrayList called personList
               break;
               
               case 2:
               try{
                  //Ask user to enter a pps
                  System.out.print("\nEnter pps of person you wish to search for: ");
                  pps = keyboardIn.nextInt();
                  searchPps(personList, pps);
                  break;}
               catch(InputMismatchException ex){
                  System.out.println("\nInteger values only, enter again! ");
                  keyboardIn.nextLine();
                  break; 
               }
               
               case 3:
               viewMF(personList); //call method viewMF and pass it the ArrayList called personList
   
               break;
               
               case 4:
               calcAge(personList); //call method calcAge and pass it the ArrayList called personList
   
               break;
               
               case 5:
               //Ask user to enter a occupation
               System.out.print("\nEnter occupation of person you wish to search for: ");
               occupation = keyboardIn.next();
               searchOccupation(personList, occupation);
               break;
               
               default:
               System.out.print("\nPlease insert a valid option!");
   
               
            }//close switch
         }
         catch(InputMismatchException er){
            System.out.println("\nPlease insert a valid option!");
            keyboardIn.nextLine();
            continue; 
         }

      }while(option != 0);
   }//close main method
   
   //Method to View all persons
   public static void viewPersons(ArrayList<Person> personList)
   {
      
      int i=0;
      for(Person p: personList)
      {
         System.out.println("\n"+p);
         i+=1;
      }
      if(i==0){
         System.out.println("\nNo people! ");

      }
   }//close view persons method
   
   //Method to search for pps of person
   public static void searchPps(ArrayList<Person> personList, int pps)
   {
      int j = 0;
      for(int i = 0; i < personList.size(); i++)
      {
         if(pps==personList.get(i).getPps())
         {
            System.out.println(personList.get(i));
            j+=1;
         }
      }
      if(j==0){
         System.out.println("\nNo people with that pps! ");

      }

   }//close search pps method
   
   //Method to search for pps of person
   public static void viewMF(ArrayList<Person> personList)
   {  int m=0;
      int f=0;
      int o=0;
      int i = 0;
      for(i = 0; i < personList.size(); i++)
      {
         if('m'==Character.toLowerCase(personList.get(i).getGender()))
         {
           m+=1 ;  
         }
         else if('f'==Character.toLowerCase(personList.get(i).getGender())){
         
            f+=1;
         }
         else{
            o+=1;
         }
      }
      if(i==0){
         System.out.println("\nNo people! ");

      }

      System.out.println("\nMale: "+m+";\nFemale: "+f+";\nOther: "+o);
   }//close search gender method
   
   //Method to Calculate average age persons
   public static void calcAge(ArrayList<Person> personList)
   {
      double age, ageTotal=0;
      int i=0;
      for(Person p: personList)
      {
         ageTotal+=p.getAge();
         i+=1;
      }
      if(i==0){
         System.out.println("\nNo people! ");

      }
      else{
         age=ageTotal/(personList.size());
         System.out.println("\nAverage age is: "+ age);
         }


   }//close calculate average method
   
   //Method to search for occupation of person
   public static void searchOccupation(ArrayList<Person> personList, String occupation) throws FileNotFoundException, IOException
   {  
      

      ArrayList <Person> occupationList = new ArrayList <>();
      int i=0;
      for(Person p: personList)
      {
         if(occupation.equalsIgnoreCase(p.getOccupation()))
         {
            System.out.println(p+"\n");
            occupationList.add(p);
            i+=1;
         }
      }
      if(i==0){
         System.out.println("\nNo people with that occupation! No file created. ");

      }
      else{
         FileOutputStream fos = new FileOutputStream ("Occupation.txt");
         ObjectOutputStream oos = new ObjectOutputStream (fos);
         oos.writeObject(occupationList);
         System.out.println("\nFile successfully created!\n");
         oos.close(); 
         }


   }//close search occupation method

}//close class