import java.io.*;
import java.util.*;

public class CarFile
{
   public static void main(String [] args) throws IOException
   {
      Scanner keyboardIn = new Scanner(System.in);
      //Create objects of the FileWriter & PrintWriter classes
      FileWriter carFile = new FileWriter("cars.txt");
      PrintWriter pw = new PrintWriter(carFile);
      String reg, make, model;
      double value;
      char ans;
      do
      {
         System.out.print("Enter reg num of car:");
         reg = keyboardIn.next();
         System.out.print("Enter maker of car:");
         make = keyboardIn.next();
         System.out.print("Enter model of car:");
         model = keyboardIn.next();
         System.out.print("Enter value of car:");
         value = keyboardIn.nextDouble();
         pw.print(reg);
         pw.print(" ");//print space between data in the file
         pw.print(make);
         pw.print(" ");
         pw.print(model);
         pw.print(" " );
         pw.println(value);  
         System.out.print("Would you like to add another car (Y/N): ");
         ans = keyboardIn.next().charAt(0);
      }while(ans == 'y' || ans == 'Y');  //continue entering cars if user enters y or Y 
      pw.close(); //close the file
   }
}