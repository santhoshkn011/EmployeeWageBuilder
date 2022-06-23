/*
Refactor the Code to write a Class Method to Compute Employee Wage.
Using Class Method and Class Variables.
*/
package com.employeeWageBuilder;
import java.util.Random; //importing Random function

public class EmpWageBuilder {
    //declaring variables
    public static int empHours = 0, EMP_RATE_PER_HOUR = 20,empWage = 0, totalWage = 0, workingDaysPerMonth = 20, maxWorkingHours = 0;
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
    //Calculation of employee wage and working hours method
    public static void empWageAndWorkingHours(){
        empWage = empHours * EMP_RATE_PER_HOUR;
        System.out.printf("Worked: %d hours, Earned: $%d", empHours, empWage).println("\n");
        totalWage += empWage;
        maxWorkingHours += empHours; //Max Working Hours is 100, loop terminates if it is above 100.
    }
    public static void totalWage(){
        System.out.println("The Total wage earned for this month is " + "$" +totalWage);
    }
    public static void maxWorkingHours(){
        System.out.println("Total hours worked: " + maxWorkingHours);
    }
    public static void main(String args[]) {
        //Welcome message
        System.out.println("Welcome to Bridgelabz Employee Wage Builder. \n");
        Random random = new Random();
        //Calculating the total wage per month using loops
            for (int day = 1; day<=workingDaysPerMonth && maxWorkingHours<100; day++) {
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
                empWageAndWorkingHours(); //Iterating total wage and max working hours method
            }
            totalWage(); //invoking total wage
            maxWorkingHours(); //invoking max hours worked in a month.
    }
}
