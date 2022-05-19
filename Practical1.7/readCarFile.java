import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class readCarFile
{
   public static void main (String args []) throws IOException
   {
      File readFile = new File ("cars.txt");
      Scanner input = new Scanner(readFile);
      
      while (input.hasNext())
      {
         int regNum= input.nextInt();
         String maker= input.next();
         String model= input.next();
         double value= input.nextDouble();
         System.out.println(regNum+" "+maker+" "+model+" "+value);
       }
       input.close();
    }
}
   