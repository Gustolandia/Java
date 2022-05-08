/*
Class to represent AirBnB Booking
Author: Clare Doherty (altered by Gustavo Ricou)
*/

public class AirBnBBooking
{
   //Instance variables
   private int bookingNumber;
   private String date;
   private int numberOfNights; 
   private String address; 
   private int numberOfGuests; 
   private double costPerNight;
   private String propertyType; 
   private boolean petsAllowed;
   private static int nextBookingNumber = 100; 
     
   //Constructors
   public AirBnBBooking(String dateIn, int nights, String add, int noGuests, double cost)
   {
      bookingNumber = nextBookingNumber++;
      date = dateIn;
      costPerNight = cost;
      numberOfNights = nights;
      address = add;
      if(noGuests > 20)
      {
         noGuests = 20;  //Set maximum number to 20
      }
      else
      {
         numberOfGuests = noGuests;
      }
      propertyType = "Apartment";
      petsAllowed = false;
   }  
   
   public AirBnBBooking(String dateIn, int nights, String add, int noGuests, double cost, String type, boolean pets)
   {
      bookingNumber = nextBookingNumber++;
      date = dateIn;
      costPerNight = cost;        
      if(noGuests > 20)
      {
         numberOfGuests = 20;  //Set maximum to 20
      }
      else
      {
         numberOfGuests = noGuests;
      }
      propertyType = type;
      petsAllowed = pets;
   }  
   
   //Mutator Methods
   //Set Date
   public void setDate(String dateIn)
   {
      date = dateIn;
   }
   //Set Address
   public void setAddress(String add)
   {
      address = add; 
   }
   //Set number of nights
   public void setNights(int nights)
   {
      numberOfNights = nights;
   }
   //Set  number of guests
   public void setGuests(int guests)
   {
      if(guests > 20)
      {
         numberOfGuests = 20;
      }
      else
      {
         numberOfGuests = guests;
      }
   }
   //Set cost per night
   public void setCostPerNight(double cost) 
   {
        costPerNight = calcCostPerNight(date, cost);
   
   }
   //Set Property type
   public void setPropertyType(String type) 
   {
      propertyType = type; 
   }
   //Set pets allowed
   public void setPetsAllowed(boolean allowPets) 
   {
      petsAllowed = allowPets; 
   }
   /**** Accessor Methods ****/
   //Get Booking number
   public int getBookingNumber()
   {
      return bookingNumber;
   }
   //Get date
   public String getDate()
   {
      return date;
   }
   //Get number of nights
   public int getNights() 
   {
      return numberOfNights; 
   }
   //Get address
   public String getAddress() 
   {
      return address; 
   }

   //Get number of guests
   public int getNoGuests() 
   {
      return numberOfGuests; 
   }
   //Get cost per night
   public double getCostPerNight() 
   {
      return costPerNight; 
   }
   //Get property type
   public String getPropertyType() 
   {
      return propertyType; 
   }
   //Get pets allowed
   public boolean petsAllowed()
   {
      if(petsAllowed)
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   //Calculate total booking price
   public double totalBookingPrice()
   {
      return costPerNight * numberOfNights;
   }
   
   //Calculate price per guest
   
   public double pricePerGuest() // return cost per guest
   {
      return costPerNight * numberOfNights / numberOfGuests;
      //Could also call method totalBookingPrice as code is same
      //return totalBookingPrice() / numberOfGuests; 
   }
   //Return all booking details
   public String toString() 
   {
      return "***** BOOKING DETAILS *****\n" +
            "Booking No: "+bookingNumber+
            "\tAddress: " + address +
            "\tDate: " + date+
            "\tNumber of Nights: "+numberOfNights+
            "\tCost Per Night: €" + costPerNight +
            "\tGuests "+numberOfGuests+
            "\tProperty Type: " + propertyType +
            "\tPets Allowed: " + petsAllowed;
   }
   //Check date to calculate costPerNight
   public double calcCostPerNight(String dateIn, double costIn)
   {
      double cost;
      if(dateIn.contains("june")||dateIn.contains("july")||dateIn.contains("august"))
      {
         cost = costIn + 15; 
      }
      else if(dateIn.contains("december"))
      {
         cost = costIn + 10;
      }
      else
      {
         cost = costIn;
      }
      return cost;
   }
}