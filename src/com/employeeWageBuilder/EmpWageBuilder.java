/*
Refactor the Code to write a Class Method to Compute Employee Wage.
Using Class Method and Class Variables.
*/
package com.employeeWageBuilder;
import java.util.Random; //importing Random function

public class EmpWageBuilder {
    //declaring variables
    public static int empHours = 0;
    //Full TIme Employee Method
    public static void fullTimeEmployee(int day){
        System.out.printf("Day %d: Employee is Present for full day.", day).println();
        empHours = 8;
    }
    //Part Time Employee Method
    public static void partTimeEmployee(int day){
        System.out.printf("Day %d: Employee worked for half day.", day).println();
        empHours = 4;
    }
    //Absent Employee Method
    public static void absentEmployee(int day){
        System.out.printf("Day %d: Employee is Absent.", day).println();
        empHours = 0;
    }
    public static void companyWage(String comp, int EMP_RATE_PER_HOUR, int workingDaysPerMonth, int maxWorkingHours ){
        int empWage = 0, totalWage=0, workingHours = 0;
        Random random = new Random();
        //Calculating the total wage per month using loops
        for (int day = 1; day<=workingDaysPerMonth && workingHours<maxWorkingHours; day++) {
            //Max Working hours should be 100.
            int empCheck = random.nextInt(3);
            switch (empCheck) {
                case 1:
                    fullTimeEmployee(day); //invoking full time employee method
                    break;
                case 2:
                    partTimeEmployee(day); //invoking part time
                    break;
                default:
                    absentEmployee(day); //invoking absent
                    break;
            }
            empWage = empHours * EMP_RATE_PER_HOUR;
            System.out.printf("Worked: %d hours, Earned: $%d", empHours, empWage).println("\n");
            totalWage += empWage;
            workingHours += empHours; //Max Working Hours is 100, loop terminates if it is above 100.
        }
        totalWage(comp, totalWage); //invoking total wage
        maxWorkingHours(comp, workingHours);//invoking max hours worked in a month.
        System.out.println();
    }
    //Calculation of employee wage and working hours method
    public static void totalWage(String comp, int wage){
        System.out.printf("The Total wage earned by %s for this month: " + "$ " + wage, comp).println();
    }
    public static void maxWorkingHours(String comp, int workingHours){
        System.out.printf("Total hours worked for %s: " + workingHours, comp).println();
    }
    //Starting of main method
    public static void main(String args[]) {
        //Welcome message
        System.out.println("Welcome to Bridgelabz Employee Wage Builder. \n");
        System.out.println("Employee Wage Builder for Company(BridgeLabz): \n");
        companyWage("BridgeLabz",20,20,100);
        System.out.println("Employee Wage Builder for Company(Toyota): \n");
        companyWage("Toyota",30,25,120);
    }
}
