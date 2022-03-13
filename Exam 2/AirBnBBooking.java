// Exam 2
// Author: Gustavo Ricou
// Date: 27/02/21
// Student number: L00170136


//Defining all necessary instance variable + a booking number

public class AirBnBBooking{
   private int bookingNumber;
   private static int nextBooNo = 1;
   private int day;
   private int month;
   private int year;
   private int nights;
   private String address;
   private int guests;
   private double costNight;
   private String propertyType;
   private boolean pet;
   
   //with pet and propertyType default   
   public AirBnBBooking(int d, int m, int y, int n, String a, int g, double c){
      bookingNumber=nextBooNo;
      nextBooNo+=1;
      day=d;
      month=m;
      year=y;
      nights=n;
      address=a;
      guests=g;
      costNight=c;
      propertyType="Apartment";
      pet=false;
      }
      
   //with pet default   
   public AirBnBBooking(int d, int m, int y, int n, String a, int g, double c, String pt){
      bookingNumber=nextBooNo;
      nextBooNo+=1;
      day=d;
      month=m;
      year=y;
      nights=n;
      address=a;
      guests=g;
      costNight=c;
      propertyType=pt;
      pet=false;
      }
   //with property type default   
   public AirBnBBooking(int d, int m, int y, int n, String a, int g, double c, boolean p){
      bookingNumber=nextBooNo;
      nextBooNo+=1;
      day=d;
      month=m;
      year=y;
      nights=n;
      address=a;
      guests=g;
      costNight=c;
      propertyType="Apartment";
      pet=p;
      }
    //no defaults, all defined by the user  
    public AirBnBBooking(int d, int m, int y, int n, String a, int g, double c, String pt, boolean p){
      bookingNumber=nextBooNo;
      nextBooNo+=1;
      day=d;
      month=m;
      year=y;
      nights=n;
      address=a;
      guests=g;
      costNight=c;
      propertyType=pt;
      pet=p;
      }
      
      
   //setters   
   public void setDay(int d){ //splitted the date into 3 parts in order to calculate the price
      day=d;
      }
   public void setMonth(int m){
      month=m;
      }
   public void setYear(int y){
      year=y;
      }
   public void setNights(int n){
      nights=n;
      }
   public void setAddress(String a){
      address=a;
      }
   public void setGuests(int g){
      guests=g;
      }
   public void setCostNight(double c){
      costNight=c;
      }
   public void setPropertyType(String pt){
      propertyType=pt;
      }
   public void setPet(boolean p){
      pet=p;
      }
   
   
   //getters
   public int getBookingNumber(){
      return bookingNumber;
      }   
   public int getDay(){
      return day;
      }
   public int getMonth(){
      return month;
      }
   public int getYear(){
      return year;
      }
   public String getDate(){
      return year+"/"+month+"/"+day;
      }      
   public int getNights(){
      return nights;
      }
   public String getAddress(){
      return address;
      }
   public int getGuests(){
      return guests;
      }
   public double getCostNight(){
      return costNight;
      }
   public String getPropertyType(){
      return propertyType;
      }
   public boolean getPet(){
      return pet;
      }
   public double getTotal(){
      
      int cDay = day;     //current day
      int cMonth = month;  //current month
      int cYear = year;    //current year
      double total=0.0;
      for (int i=0;i<nights;i++){
         //add value of the stay of 1 night in a specific month
         if (cMonth==6 || cMonth==7 || cMonth==8){ //june, july august
            total+=costNight+15.0;
            }
         else if (cMonth==12){ //decembre
            total+=costNight+10.0;
            }
         else {
            total+=costNight;
            }
         //change day and month   
         if (cMonth==4 || cMonth==6 || cMonth==9 || cMonth==11){ //months with 30 days
            if (cDay>=30){
               cDay=1;
               cMonth+=1;
               }
            else{
               cDay+=1;
               }
            }
         else if (cMonth==2){ //February
            if (cDay>=28){
               cDay=1;
               cMonth+=1;
               }
            else{
               cDay+=1;
               }
            }
         else if (cMonth==12){ //Decembre (year change)
            if (cDay>=31){
               cDay=1;
               cMonth=1;
               cYear+=1;
               }
            else{
               cDay+=1;
               }
            }

         else {            //rest of the days
            if (cDay>=31){
               cDay=1;
               cMonth+=1;
               }
            else{
               cDay+=1;
               }
            }   
         }
      
      return total;
      }

      
      public double getCostPerGuest(){
         return getTotal()/guests;
         }
      public String toString(){
         if (pet){
            return "Booking details:\nBooking number: "+bookingNumber+"\nDate: "+year+"/"+month+"/"+day+"\nNumber of nights: "+nights+"\nProperty Address: "+address+"\nNumber of guests: "+guests+"\nCost per night: "+costNight+"\nProperty Type: "+propertyType+"\nPets: Allowed";
            }
         else{
            return "Booking details:\nBooking number: "+bookingNumber+"\nDate: "+year+"/"+month+"/"+day+"\nNumber of nights: "+nights+"\nProperty Address: "+address+"\nNumber of guests: "+guests+"\nCost per night: "+costNight+"\nProperty Type: "+propertyType+"\nPets: Not Allowed";
            }
         }
      
    
   
   }   
