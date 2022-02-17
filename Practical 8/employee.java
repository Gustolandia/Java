// Practical 6
// Author: Gustavo Ricou
// Date: 30/01/21
// Program to write mm of rain in a year
//Question 5 and 5

import java.util.*;
public class employee{
   private int employeeNumber;
   private String name;
   private String jobTitle;
   private double salary;
   
   public employee(){
      employeeNumber=0;
      name="no name";
      jobTitle="no job";
      salary=0.0;
      }
      
   public employee(int e, String n, double s){
      employeeNumber=e;
      name=n;
      jobTitle="no job";
      salary=s;
      }
      
   public employee(int e, String n, double s, String j){
      employeeNumber=e;
      name=n;
      jobTitle=j;
      salary=s;
      }
      
         
   public int getEmployeeNumber(){
      return employeeNumber;
      }
      
   public String getName(){
      return name;
      }
      
   public String getJobTitle(){
      return jobTitle;
      }
      
   public double getSalary(){
      return salary;
      }
   
   public void setEmployeeNumber(int e){
      employeeNumber=e;
      }
   public void setName(String n){
      name=n;
      }
   public void setJobTitle(String j){
      jobTitle=j;
      }
   public void setSalary(double s){
      salary=s;
      }
   public void raiseSalary(double s){
      salary+=s;
      }
   public void reduceSalary(double s){
      salary-=s;
      }
   public double getMonthlyWage(){
      return salary/12;
      }
   public double getBonus(double p){
      return salary*p/100;
      }
   public String viewDetails(){
      return "The employee "+name+" has number "+employeeNumber+" is emplyed as "+jobTitle+" and makes "+salary+" euros.";
      }
   }   