/*
Refactor to use ArrayList instead of array.

The ArrayList class is a resizable array, which can be found in the java. util package.
The difference between a built-in array and an ArrayList in Java, is that the size of an array cannot be modified (if you want to add or remove elements to/from an array, you have to create a new one).

An Interface in Java programming language is defined as an abstract type used to specify the behavior of a class.
An interface in Java is a blueprint of a class. A Java interface contains static constants and abstract methods. The interface in Java is a mechanism to achieve abstraction.

Data abstraction is the process of hiding certain details and showing only essential information to the user.
*/
package com.employeeWageBuilder;
import java.util.Random; //importing Random function
import java.util.ArrayList; //importing ArrayList class
//implementing interface
interface IEmpWageBuilder {
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);
    public void companyWage();
}

class EmpWageBuilder implements IEmpWageBuilder{
    // instance variables
    int noOfCompanies, index;
    ArrayList<CompanyEmpWage> companies; //ArrayList declaration
    //Constructor for the class EmpWageBuilder
    public EmpWageBuilder() {
        companies = new ArrayList<>();
    }
    //Assigning to the array
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        CompanyEmpWage company = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
        companies.add(company);
    }
    //Computation of company wage
    int companyWage(CompanyEmpWage companyEmpWage) {
        System.out.println("Computation of total wage of " + companyEmpWage.COMPANY_NAME + " employee:");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%1s   %5s   %5s   %5s\n", "Day", "Work_hrs", "Total_Wage", "Total_working_hrs");
        System.out.println("------------------------------------------------------------");

        int workingHrs, totalWage = 0;
        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.MAX_WORKING_DAYS
                && totalWorkingHrs <= companyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {
            int empType = generateEmployeeType(); //random value(0,1,2)
            workingHrs = getWorkingHrs(empType); //Full time, Part time or Absent
            int wage = workingHrs * companyEmpWage.WAGE_PER_HR;
            totalWage += wage;
            System.out.printf("%2d   %5d   %9d   %12d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
        }
        return totalWage;
    }
    int generateEmployeeType() {
        Random random = new Random();
        return random.nextInt(3);
    }
    int getWorkingHrs(int empType) {
        switch (empType) {
            case 1:
                return 8; //Full time
            case 2:
                return 4; //Part time
            default:
                return 0; //Absent
        }
    }
    public void companyWage() {
        for (CompanyEmpWage company : companies) //for-each loop
        {
            int totalWage = companyWage(company);
            company.setTotalEmployeeWage(totalWage);
            System.out.println(company); //overriding the toString() method
        }
    }
    //Starting of main method.
    public static void main(String args[]) {
        //Welcome message
        System.out.println("Welcome to Employee Wage Builder. \n");
        EmpWageBuilder emp = new EmpWageBuilder(); //creating an object and declaring number of companies = 3
        emp.addCompany("Bridgeabz", 20, 20, 100);
        emp.addCompany("Toyota", 30, 22, 120);
        emp.addCompany("TCS", 25, 25, 115);
        emp.companyWage();
    }
}