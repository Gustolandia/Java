
//Software Development

// Assignment 1
// Student number: L00170136
// Name: Gustavo Pedro Ricou



import java.util.*; //keyboard listening package
public class electrical{
   public static void main(String [] args){
      Scanner keyboardIn = new Scanner (System.in); //keyboard listening package
      
      //Start of the program
      System.out.print("****\tLYIT Electric\t****\n");
      System.out.print("Please enter the following customer details\n");
      System.out.print("Enter the customer type Residential[R] or Business[B]:");
      char cType= keyboardIn.next().charAt(0); //read if it is residential or business customer
      
      //make sure only r and u is allowed (capital letter or not)
      while (cType!='R' && cType!='B' && cType!='b' && cType!='r'){
         System.out.print("Invalid customer type entered - please re-enter. [R] or [B]:");
         cType= keyboardIn.next().charAt(0);
         }
      
      
      //initialize variables used in the final bill (all initialized at 0 for simplicity
      int units=0; //number of units consumed
      double usage=0.0; //price paid for the units consumed
      double standingC=0.0; //standing charge for the month
      double total=0.0; //total=standing charge+usage
      double vat=0.0; //vat will be calculated from 13% over total
      double due=0.0; //due will be total +vat
      
      
      //if residential custommer
      if ( cType=='R' || cType=='r'){
         System.out.print("Please enter the number of units used this month:");
         units=keyboardIn.nextInt();         //save in units the number of units
         System.out.print("How many years is the customer with the company:");
         int years=keyboardIn.nextInt();          //save in years the number of years a customer has been with the company
         System.out.print("Which meter  is the customer on Urban [U] or Rural [R]:");
         char mType= keyboardIn.next().charAt(0); //u for urban and r for rural area customer
         while (mType!='R' && mType!='U' && mType!='u' && mType!='r'){ //make sure the values for residential or urban are valid
            System.out.print("Invalid meter type entered - please re-enter. [R] or [U]:\n");
            mType= keyboardIn.next().charAt(0);
            }
         
         
         //if the customer has more than 3 years with the company and consumdes more than 200 units, he does not pay the 1st 200 units and pays the remaining at 23 cents
         if (years>=3 && units>200){
            double dUnits=units-200;
            usage=dUnits*0.23;
            }
            
            //if the customer is less than 3 years with the company and consumed less than 200, then all units are paid at 18 cents
         else if (years<3 && units<=200){
            usage=units*0.18;
         }
         
         //if the customer has been less than 3 years with the company and consumded more than 200, all units until 200 are paid at 18 cents and the remainder units at 23 cents
         else if(years<3 && units>200){
            usage=200*0.18+(units-200)*0.23;
            }
            
         //if the customer has been more than 3 years with the company and consumed less than 200, he won't pay anything, therefore usage remains at 0 and we do not need to change initial value of 0
         
         
         // rural areas 21.50 standing charges
         if ( mType=='R' || mType=='r'){
            standingC=21.5;
            }
            
            
         //urban area 17.50 standing charges   
         else{
            standingC=17.5;
            }
            

         }
         
         //if it is not residential, it is business
      else{
      
      
         System.out.print("How many businesses are registered to the elctric supply:");
         int numberB=keyboardIn.nextInt();
         //number of business will be upper limit of for cycle
         for (int i=0; i<numberB; i++){
            System.out.print("Enter number of units used by business "+(i+1)+":"); //i chose for cycle starting at 0, so add 1 for business 1,2, etc
            int unitsB=keyboardIn.nextInt(); //innver variable for each business number of units
            units=units+unitsB; //total amount of units will add for each business
            }
         usage=units*0.25; //calculation of usage at 25 cents the unit
         standingC=20.0; //standing charges for business are always 20

         }
      total=usage+standingC; //value of total, standing charges + usage of units
      vat=total*0.13; //VAT of 13% applied to all expenses
      due=total+vat; //the due value to pay with vat
      
      //final values, \n and \t chosen to align as in example outputs
      System.out.print("\nElectric Bill for month ending 31st January 2022\n\n");
      System.out.print("Customer Type "+cType+"\n");
      System.out.print("Usage "+units+" Units \t"+"Ç"+usage+"\n");
      System.out.print("Standing Charge\tÇ"+standingC+"\n\n");
      System.out.print("Total\t\t\t\tÇ"+total+"\n");
      System.out.print("VAT @ 13%\t\tÇ"+vat+"\n");
      System.out.print("Amount Due\t\tÇ"+due+"\n");


      }
   }     