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

public class EmployeeGUI extends Application
{
   //Create ArrayList for Employees
   ArrayList<Employee> empList = new ArrayList<>();
   TextField txtEmpNo;
   TextField txtName;
   TextField txtSalary;
   TextField txtTitle;
   Button btnAddEmployee;
   Button btnViewEmployees;
   Button btnSearchJob;
   Button btnSearchSalary;
   Button btnDeleteEmp;
   TextArea txtOutput;
   public void start(Stage stage)
   {
      //Create Labels
      Label lblEmpNo = new Label("Emp No");
      Label lblName = new Label("Name");
      Label lblJob = new Label("Job Title");
      Label lblSalary = new Label("Salary €");
      
      //Create all TextFields
      txtEmpNo = new TextField();
      txtEmpNo.setMaxWidth(50);
      txtName = new TextField();
      txtName.setMaxWidth(100);
      txtSalary = new TextField();
      txtSalary.setMaxWidth(50);
      txtTitle = new TextField();
      txtTitle.setMaxWidth(100);
      //Create Buttons
      btnAddEmployee = new Button("Add Employee");
      btnAddEmployee.setOnAction(e -> addEmployees(e));
      btnViewEmployees = new Button("View Employees");
      btnViewEmployees.setOnAction(e -> viewEmployees(e));
      btnSearchJob = new Button("Search by Job Title");
      btnSearchJob.setOnAction(e -> searchJob(e));
      btnSearchSalary = new Button("Search by Salary");
     
      btnDeleteEmp = new Button("Delete Employee");
      btnDeleteEmp.setOnAction(e -> deleteEmployee(e));
      
      //Create TextArea for output
      txtOutput = new TextArea();
      txtOutput.setMaxSize(500,400);
      txtOutput.setEditable(false);
      
      //Create HBox and add all controls for input to it
      //Adding Labels and TextBoxes across the screen
      HBox input = new HBox(8);
      input.getChildren().addAll(lblEmpNo, txtEmpNo, lblName, txtName, lblSalary, txtSalary, lblJob, txtTitle);
      
      //Creating another HBox and adding buttons to it
      HBox buttons = new HBox(8);
      buttons.getChildren().addAll(btnAddEmployee, btnViewEmployees, btnSearchJob, btnSearchSalary, btnDeleteEmp);
      
      //Create VBox and add 2 HBoxes to it and also TextArea
      VBox root = new VBox(10);
      root.getChildren().addAll(input, buttons, txtOutput);
      
      //Create Scene and add VBox to scene
      Scene scene = new Scene(root, 600, 400);
      stage.setScene(scene);
      stage.setTitle("Employee Portal");
      stage.show();
      
      
   }//close start method
   
   //Method to add Employees
   public void addEmployees(ActionEvent e)
   {
      int empNo;
      String name, job;
      double salary;
      try
      {
         //Get values from TextFields
         if(txtEmpNo.getText().isEmpty() || txtName.getText().isEmpty() || txtTitle.getText().isEmpty() || txtSalary.getText().isEmpty())
         {
            txtOutput.setText("You must enter values in all 4 fields");
         }
         else
         {
            empNo = Integer.parseInt(txtEmpNo.getText());
            name = txtName.getText();
            job = txtTitle.getText();
            salary = Double.parseDouble(txtSalary.getText());
         
            //Call constructor and add Employee to Arraylist
            empList.add(new Employee(empNo,name,salary, job));
            txtOutput.setText("Employee successfully added");
            //Clear TextFields
            txtEmpNo.clear();
            txtName.clear();
            txtTitle.clear();
            txtSalary.clear();
         }
      }//close try
      catch(NumberFormatException ex)
      {
         txtOutput.setText("Please ensure to enter numbers only for Employee number and salary");
      }
   }//close add employee method
   
   //View employees method
   public void viewEmployees(ActionEvent e)
   {
      //Clear Text output area
      txtOutput.clear();
      for(int i = 0; i < empList.size(); i++)
      {
         txtOutput.appendText(empList.get(i) +"\n" );
      }
      
      //For each 
      /*for(Employee emp: empList)
      {
         txtOutput.appendText(emp + "\n");
      } */
   }//close view employee method
         
   //Method to search for employees based on job title
   public void searchJob(ActionEvent e)
   {
      //Clear Text output area
      txtOutput.clear();
      boolean empFound = false;
      //Get job title from user to search with
      if(txtTitle.getText().isEmpty())
      {
         txtOutput.setText("You need to enter a job title first");
      }
      else
      {
         String search = txtTitle.getText();
      
         for(int i = 0; i < empList.size(); i++)
         {
            if(search.equalsIgnoreCase(empList.get(i).getJob()))
            {
               txtOutput.appendText(empList.get(i).getEmpName() +"\n");
               empFound = true;
            }
         } //close for
         if(empFound == false)  //if(!empFound)
         {
            txtOutput.setText("No employee found matching that job title");
         }
      }
   }//close search job title method
   
   public void deleteEmployee(ActionEvent e)
   {
      //Get employee number from user
      int empNo = Integer.parseInt(txtEmpNo.getText());
      //Check if employee number entered matches employee number in array list
      for(int i = 0; i < empList.size(); i++)
      {
         if(empNo == empList.get(i).getEmpNum())
         {
            //remove that employee
            empList.remove(i);
            txtOutput.setText("Employee was successfully removed");
         }
      }//close for
   }//close delete employee method

      
   
      
   public static void main(String[]args)
   {
      launch(args);
   }
}