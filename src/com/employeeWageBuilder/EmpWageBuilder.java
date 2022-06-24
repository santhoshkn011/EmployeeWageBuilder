/*
Ability to manage Employee Wage of multiple companies - Note: Refactor to have one EmpWageBuilder to manage for Wage for multiple Company
- Create CompanyEmpWage class and let EmpWageBuilder has array of many CompanyEmpWage Object.

If we want to represent an object of a class as a String, then we can use the toString() method which returns a textual representation of the object.

An Interface in Java programming language is defined as an abstract type used to specify the behavior of a class.
An interface in Java is a blueprint of a class. A Java interface contains static constants and abstract methods. The interface in Java is a mechanism to achieve abstraction.

Data abstraction is the process of hiding certain details and showing only essential information to the user.
*/
package com.employeeWageBuilder;
import java.util.Random; //importing Random function
//implementing interface
interface IEmpWageBuilder {
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);
    public void companyWage();
}

class EmpWageBuilder implements IEmpWageBuilder{
    // instance variables
    int noOfCompanies, index;
    CompanyEmpWage[] companies; //declaring array

    //Constructor for the class EmpWageBuilder
    public EmpWageBuilder(int noOfCompanies) {
        this.noOfCompanies = noOfCompanies;
        companies = new CompanyEmpWage[noOfCompanies];
        index = 0;
    }
    //Assigning to the array
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        companies[index++] = new CompanyEmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
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
        EmpWageBuilder emp = new EmpWageBuilder(3); //creating an object and declaring number of companies = 3
        emp.addCompany("Bridgeabz", 20, 20, 100);
        emp.addCompany("Toyota", 30, 22, 120);
        emp.addCompany("TCS", 25, 25, 115);
        emp.companyWage();
    }
}


