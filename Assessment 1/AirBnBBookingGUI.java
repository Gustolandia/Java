import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.util.ArrayList;

public class AirBnBBookingGUI extends Application
{
   //Create ArrayList for AirBnBBookings
   ArrayList<AirBnBBooking> AirBnBList = new ArrayList<>();
   TextField txtDate;
   TextField txtAddress;
   TextField txtNoGuests;
   TextField txtNoNights;
   TextField txtCostNight;
   Button btnAddAirBnBBooking;
   Button btnViewAirBnBBookings;
   Button btnEditAirBnBBookings;
   Button btnSearchByAddress;
   Button btnDeleteAirBnB;
   Button btnCalculate;
   TextArea txtOutput;
   public void start(Stage stage)
   {
      //Create Labels
      Label lblDate = new Label("Date");
      Label lblAddress = new Label("Address");
      Label lblNoNights = new Label("No of Nights");
      Label lblNoGuests = new Label("No ofGuests");
      Label lblCostNight = new Label("Cost per Night");
      Label lblAirTitle = new Label("***************************  AirBNB Booking   ***************************");
      Label lblSeparator = new Label("*************************************************************");
      
      //Create all TextFields
      txtDate = new TextField();
      txtDate.setMaxWidth(100);
      txtAddress = new TextField();
      txtAddress.setMaxWidth(200);
      txtNoGuests = new TextField();
      txtNoGuests.setMaxWidth(50);
      txtNoNights = new TextField();
      txtNoNights.setMaxWidth(50);
      txtCostNight = new TextField();
      txtCostNight.setMaxWidth(50);
      
      //Create Buttons
      btnAddAirBnBBooking = new Button("Add Booking");
      btnAddAirBnBBooking.setOnAction(e -> addAirBnBBookings(e));
      btnViewAirBnBBookings = new Button("View All Bookings");
      btnViewAirBnBBookings.setOnAction(e -> viewAirBnBBookings(e));
      btnEditAirBnBBookings = new Button("Edit Booking");
      btnEditAirBnBBookings.setOnAction(e -> editBooking(e));
      btnSearchByAddress = new Button("Search by Address");
      btnSearchByAddress.setOnAction(e -> searchByAddress(e));
      btnCalculate = new Button("Calculate Booking Cost");
      btnCalculate.setOnAction(e -> calculate(e));
      btnDeleteAirBnB = new Button("Cancel Booking");
      btnDeleteAirBnB.setOnAction(e -> deleteAirBnBBooking(e));
      
      //Create TextArea for output
      txtOutput = new TextArea();
      txtOutput.setMaxSize(800,600);
      txtOutput.setEditable(false);
      
      //Create HBox and add all controls for input to it
      //Adding Labels and TextBoxes across the screen
      HBox input = new HBox(10);
      input.getChildren().addAll(lblDate, txtDate, lblAddress, txtAddress, lblNoGuests, txtNoGuests, lblNoNights, txtNoNights, lblCostNight, txtCostNight);
      input.setAlignment(Pos.CENTER);
      
      //Creating another HBox and adding part of the buttons to it
      HBox buttons1 = new HBox(4);
      buttons1.getChildren().addAll(btnAddAirBnBBooking, btnViewAirBnBBookings, btnEditAirBnBBookings, btnDeleteAirBnB);
      buttons1.setAlignment(Pos.CENTER);
      
      //Creating another HBox and adding part of the buttons to it (2)
      HBox buttons2 = new HBox(2);
      buttons2.getChildren().addAll(btnSearchByAddress, btnCalculate);
      buttons2.setAlignment(Pos.CENTER);
      
      //Create VBox and add 2 HBoxes to it and also TextArea
      VBox root = new VBox(10);
      root.setAlignment(Pos.CENTER);
      root.getChildren().addAll(lblAirTitle, input, lblSeparator, buttons1, buttons2, txtOutput);
      
      //Create Scene and add VBox to scene
      Scene scene = new Scene(root, 1000, 600);
      stage.setScene(scene);
      stage.setTitle("AirBn Bookings");
      stage.show();
      
      
   }//close start method
   
   //Method to add AirBnBBookings
   public void addAirBnBBookings(ActionEvent e)
   {
      String date, address;
      int noGuests, noNights;
      double costNight;
      try
      {
         //Get values from TextFields and numbers must be positive
         if(txtDate.getText().isEmpty() || txtAddress.getText().isEmpty() || txtNoNights.getText().isEmpty() || txtNoGuests.getText().isEmpty() || txtCostNight.getText().isEmpty() || Integer.parseInt(txtNoGuests.getText())<=0 || Integer.parseInt(txtNoNights.getText())<=0 || Double.parseDouble(txtCostNight.getText())<=0)
         {
            txtOutput.setText("You must enter values in all 5 fields and the numbers must be positive");
         }
         else
         {
            noGuests = Integer.parseInt(txtNoGuests.getText());
            noNights = Integer.parseInt(txtNoNights.getText());
            date = txtDate.getText();
            address = txtAddress.getText();
            costNight = Double.parseDouble(txtCostNight.getText());
         
            //Call constructor and add AirBnBBooking to Arraylist
            AirBnBList.add(new AirBnBBooking(date,noNights,address, noGuests, costNight));
            txtOutput.clear();
            txtOutput.setText("AirBnBBooking successfully added");
            //Clear TextFields
            txtDate.clear();
            txtAddress.clear();
            txtNoNights.clear();
            txtNoGuests.clear();
            txtCostNight.clear();
         }
      }//close try
      catch(NumberFormatException ex)
      {  
         txtOutput.clear();
         txtOutput.setText("Please ensure to enter valid numbers on nights, guests and in the cost per night.");
      }
   }//close add AirBnBloyee method
   
   //View AirBnB method
   public void viewAirBnBBookings(ActionEvent e)
   {
      txtOutput.clear();
      if(AirBnBList.size()==0)
      {
         txtOutput.setText("No bookings yet.");
      }
      else{
      //For each 
         for(AirBnBBooking AirBnB: AirBnBList)
         {
            txtOutput.appendText(AirBnB + "\n");
         } 
      }
   }//close view AirBnB method
   
   //Method search by Address 
   public void searchByAddress(ActionEvent e)
   {
      Stage stage2 = new Stage();
      stage2.setTitle("Search by address");
      
      TextField txtAddress2 = new TextField();
      txtAddress2.setMaxWidth(400);
      Label lblAddress2 = new Label("Address to search:");
      HBox inputSea= new HBox(4);
      inputSea.setAlignment(Pos.CENTER);
      inputSea.getChildren().addAll(lblAddress2, txtAddress2);
      Button btnAddress2 = new Button("Search Address");
      btnAddress2.setOnAction(el1->
         {
               if(AirBnBList.size()==0){
                  txtAddress2.setText("No bookings");
               }
               else{
                  for(AirBnBBooking AirBnB: AirBnBList)
                     {
                        if(txtAddress2.getText().equals(AirBnB.getAddress())){
                           txtOutput.setText("This is the booking you searched:\n"+AirBnB+"\n");
                           stage2.close();
                           
                        }
                        
                     }
                     txtAddress2.setText("Address not found, try again.");
                  }
                  
         });
      VBox root2 = new VBox(4);
      Button btnCancel = new Button("Cancel");
      btnCancel.setOnAction(el2->stage2.close());
      root2.getChildren().addAll(inputSea, btnAddress2, btnCancel);
      root2.setAlignment(Pos.CENTER);
      stage2.setScene(new Scene(root2, 650, 650));
      stage2.show();
        

   }//close search by address method

         
   //Method edit bookings 
   public void editBooking(ActionEvent e)
   {
      Stage stage2 = new Stage();
      stage2.setTitle("Edit Booking");
      
      TextField txtBookingNo = new TextField();
      txtBookingNo.setMaxWidth(400);
      Label lblBooking = new Label("Booking Number to edit:");
      HBox inputEdit= new HBox(4);
      inputEdit.setAlignment(Pos.CENTER);
      inputEdit.getChildren().addAll(lblBooking, txtBookingNo);
      Button editBooking = new Button("Edit now");
      VBox root2 = new VBox(4);
      root2.getChildren().addAll(inputEdit, editBooking);
      editBooking.setOnAction(el1->
         {
            try{
               if(AirBnBList.size()==0){
                  txtBookingNo.setText("No bookings");
               }
               else{
                  for(AirBnBBooking AirBnB: AirBnBList){
                        System.out.println(AirBnB.getBookingNumber());
                        System.out.println(txtBookingNo.getText());
                        if(AirBnB.getBookingNumber()==Integer.parseInt(txtBookingNo.getText())){
                           //HERE WILL BE THE ENTIRE EDITTING
                           root2.getChildren().removeAll(inputEdit, editBooking);
                           TextArea txtOutput2 = new TextArea();
                           txtOutput2.setMaxSize(800,200);
                           txtOutput2.setEditable(false);
                           TextField txtDate2 = new TextField();
                           txtDate2.setMaxWidth(100);
                           txtDate2.setText(AirBnB.getDate());
                           TextField txtAddress2 = new TextField();
                           txtAddress2.setMaxWidth(200);
                           txtAddress2.setText(AirBnB.getAddress());
                           TextField txtNoGuests2 = new TextField();
                           txtNoGuests2.setMaxWidth(50);
                           txtNoGuests2.setText(AirBnB.getNoGuests()+"");
                           TextField txtNoNights2 = new TextField();
                           txtNoNights2.setMaxWidth(50);
                           txtNoNights2.setText(AirBnB.getNights()+"");
                           TextField txtCostNight2 = new TextField();
                           txtCostNight2.setMaxWidth(50);
                           txtCostNight2.setText(AirBnB.getCostPerNight()+"");
                           TextField txtType2 = new TextField();
                           txtType2.setMaxWidth(200);
                           txtType2.setText(AirBnB.getPropertyType());
                           TextField txtPet2 = new TextField();
                           txtPet2.setMaxWidth(50);
                           txtPet2.setText(AirBnB.petsAllowed()+"");
                           
                           Label lblDate2 = new Label("Date");
                           Label lblAddress2 = new Label("Address");
                           Label lblNoNights2 = new Label("No of Nights");
                           Label lblNoGuests2 = new Label("No ofGuests");
                           Label lblCostNight2 = new Label("Cost per Night");
                           Label lblType2 = new Label("Type of property");
                           Label lblPet2 = new Label("Pets? true if yes, any other value if false.");
                           
                           HBox inputEdit2= new HBox(8);
                           inputEdit2.setAlignment(Pos.CENTER);
                           HBox inputEdit3= new HBox(6);
                           inputEdit3.setAlignment(Pos.CENTER);
                           
                           inputEdit2.getChildren().addAll(lblDate2, txtDate2, lblAddress2, txtAddress2, lblNoNights2, txtNoNights2, lblNoGuests2, txtNoGuests2);
                           inputEdit3.getChildren().addAll(lblCostNight2, txtCostNight2, lblType2, txtType2, lblPet2, txtPet2);
                           Button btnEdit = new Button("Edit Booking");
                           btnEdit.setOnAction(el2->
                           {
                              try{
                              
                                 AirBnB.setDate(txtDate2.getText());
                                 AirBnB.setAddress(txtAddress2.getText());
                                 AirBnB.setNights(Integer.parseInt(txtNoNights2.getText()));
                                 AirBnB.setGuests(Integer.parseInt(txtNoGuests2.getText()));
                                 AirBnB.setCostPerNight(Double.parseDouble(txtCostNight2.getText()));
                                 AirBnB.setPropertyType(txtType2.getText());
                                 AirBnB.setPetsAllowed(Boolean.parseBoolean(txtPet2.getText()));
                                 txtDate2.setText(AirBnB.getDate());
                                 txtAddress2.setText(AirBnB.getAddress());
                                 txtNoGuests2.setText(AirBnB.getNoGuests()+"");
                                 txtNoNights2.setText(AirBnB.getNights()+"");
                                 txtCostNight2.setText(AirBnB.getCostPerNight()+"");
                                 txtType2.setText(AirBnB.getPropertyType());
                                 txtPet2.setText(AirBnB.petsAllowed()+"");
   
                                 txtOutput2.setText("Booking editted");
                              }
                              catch(NumberFormatException ex2)
                              {
                                 txtOutput2.setText("Please insert numbers in the respective field.");
                              }

                           });
                           Button btnCancel = new Button("Cancel");
                           btnCancel.setOnAction(el2->stage2.close());
                           
                           HBox inputEdit4= new HBox(8);
                           inputEdit4.setAlignment(Pos.CENTER);
                           inputEdit4.getChildren().addAll(btnEdit, btnCancel);
                           
                           
                           root2.getChildren().addAll(inputEdit2, inputEdit3, inputEdit4, txtOutput2);

                        }
                        
                        
                        
                     }
                     txtBookingNo.setText("Booking number not found, try again.");
                  }
                  }
            catch(NumberFormatException ex)
            {
               txtBookingNo.setText("Please insert a valid number");
            }
         });

      root2.setAlignment(Pos.CENTER);
      stage2.setScene(new Scene(root2, 650, 650));
      stage2.show();
        

   }//close edit bookings
   
   
   //Method cancel booking 
   public void deleteAirBnBBooking(ActionEvent e)
   {
      Stage stage2 = new Stage();
      stage2.setTitle("Delete booking");
      
      TextField txtBookingNo = new TextField();
      txtBookingNo.setMaxWidth(400);
      Label lblBooking = new Label("Booking Number to delete:");
      HBox inputDel= new HBox(4);
      inputDel.setAlignment(Pos.CENTER);
      inputDel.getChildren().addAll(lblBooking, txtBookingNo);
      Button delBooking = new Button("Delete Booking");
      Button btnCancel = new Button("Cancel");
      btnCancel.setOnAction(el2->stage2.close());
      delBooking.setOnAction(el1->
         {
            try{
               if(AirBnBList.size()==0){
                  txtBookingNo.setText("No bookings");
               }
               else{
                  for(int i = 0; i < AirBnBList.size(); i++)
                     {
                     
                        if(AirBnBList.get(i).getBookingNumber()==Integer.parseInt(txtBookingNo.getText())){
                           txtOutput.setText(AirBnBList.get(i).getBookingNumber() + " booking has been deleted");
                           AirBnBList.remove(i);
                           stage2.close();
                           
                        }
                        
                           
                        
                     }
                     txtBookingNo.setText("Number not found, try again.");
                  }
                  }
            catch(NumberFormatException ex)
            {
               txtBookingNo.setText("Please insert a valid number");
            }
         });
      VBox root2 = new VBox(4);
      root2.getChildren().addAll(inputDel, delBooking, btnCancel);
      root2.setAlignment(Pos.CENTER);
      stage2.setScene(new Scene(root2, 650, 650));
      stage2.show();
        

   }//close delete AirBnBloyee method


   //Method calculate cost 
   public void calculate(ActionEvent e)
   {
      Stage stage2 = new Stage();
      stage2.setTitle("Calculate cost");
      
      TextField txtBookingNo = new TextField();
      txtBookingNo.setMaxWidth(400);
      Label lblBooking = new Label("Booking Number to calculate total cost:");
      HBox inputCost= new HBox(4);
      inputCost.setAlignment(Pos.CENTER);
      inputCost.getChildren().addAll(lblBooking, txtBookingNo);
      Button btnCancel = new Button("Cancel");
      btnCancel.setOnAction(el2->stage2.close());
      Button costBooking = new Button("Calculate cost");
      costBooking.setOnAction(el1->
         {
            try{
               if(AirBnBList.size()==0){
                  txtBookingNo.setText("No bookings");
               }
               else{
                  for(AirBnBBooking AirBnB: AirBnBList)
                     {
                     
                        if(AirBnB.getBookingNumber()==Integer.parseInt(txtBookingNo.getText())){
                           txtOutput.setText("The booking number "+AirBnB.getBookingNumber()+" costs a total of "+AirBnB.totalBookingPrice() + " euros");
                           stage2.close();
                           
                        }
                        
                     }
                     txtBookingNo.setText("Booking number not found, try again.");
                  }
                  }
            catch(NumberFormatException ex)
            {
               txtBookingNo.setText("Please insert a valid number");
            }
         });
      VBox root2 = new VBox(4);
      root2.getChildren().addAll(inputCost, costBooking, btnCancel);
      root2.setAlignment(Pos.CENTER);
      stage2.setScene(new Scene(root2, 650, 650));
      stage2.show();
        

   }//close calculate cost method
      
   
      
   public static void main(String[]args)
   {
      launch(args);
   }
}