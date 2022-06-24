/*
Ability to save the Total Wage for Each Company -
Note: You can Create EmpWageBuilder for each Company
- Use Instance Variable instead of function parameters
*/
package com.employeeWageBuilder;
import java.util.Random; //importing Random function

public class EmpWageBuilder {
    //Declaring instance variables
    private final String comp;
    private final int EMP_RATE_PER_HOUR;
    private final int workingDaysPerMonth;
    private final int maxWorkingHours;
    private int totalEmpWage;
    //Constructor for the class EmpWageBuilder
    public EmpWageBuilder(String comp, int EMP_RATE_PER_HOUR, int workingDaysPerMonth, int maxWorkingHours){
        this.comp = comp;
        this.EMP_RATE_PER_HOUR = EMP_RATE_PER_HOUR;
        this.workingDaysPerMonth = workingDaysPerMonth;
        this.maxWorkingHours = maxWorkingHours;
    }
    //Computation of company wage
    public void companyWage(){
        System.out.printf("%s Employee Wage details: ", comp).println();
        //local variables
        int empWage = 0, totalWage=0, workingHours = 0, empHours = 0;
        Random random = new Random();
        //Calculating the total wage per month using loops
        for (int day = 1; day<=workingDaysPerMonth && workingHours<maxWorkingHours; day++) {
            //Max Working hours should be 100.
            int empCheck = random.nextInt(3);
            switch (empCheck) {
                case 1:
                    System.out.printf("Day %d: Employee is Present for full day.", day).println();
                    empHours = 8;
                    break;
                case 2:
                    System.out.printf("Day %d: Employee worked for half day.", day).println();
                    empHours = 4;
                    break;
                default:
                    System.out.printf("Day %d: Employee is Absent.", day).println();
                    empHours = 0;
                    break;
            }
            empWage = empHours * EMP_RATE_PER_HOUR;
            System.out.printf("Worked: %d hours, Earned: $%d", empHours, empWage).println("\n");
            totalWage += empWage;
            workingHours += empHours; //Max Working Hours is 100, loop terminates if it is above 100.
        }
        totalEmpWage = workingHours*EMP_RATE_PER_HOUR;
        System.out.printf("The Total wage earned by %s for this month: " + "$ " + totalWage, comp).println();
        System.out.printf("Total hours worked for %s: " + workingHours, comp).println();
        System.out.println();
    }
    //overriding the toString() method
    public String toString(){
        return "Total wage earned for the Company " + comp + " is: " + totalEmpWage;
    }
    //Starting of main method.
    public static void main(String args[]) {
        //Welcome message
        System.out.println("Welcome to Employee Wage Builder. \n");
        EmpWageBuilder bridgelabz = new EmpWageBuilder("Bridgelabz", 20, 20, 100);
        bridgelabz.companyWage();
        EmpWageBuilder toyota = new EmpWageBuilder("Toyota", 30, 25, 120);
        toyota.companyWage();
        System.out.println(bridgelabz);
        System.out.println(toyota);
    }
}
