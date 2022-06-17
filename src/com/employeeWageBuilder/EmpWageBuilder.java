package com.employeeWageBuilder;
import java.util.Random; //importing Random function

public class EmpWageBuilder {
    public static void main(String args[]) {

        //Welcome message
        System.out.println("Welcome to Bridgelabz Employee Wage Builder. \n");

        //Declaring variables
        int EMP_RATE_PER_HOUR = 20;
        int empHours = 0;
        int empWage = 0;
        int totalWage = 0;
        int workingDaysPerMonth = 20; //Working days per month is 20 days
        int maxWorkingHours = 0;
        Random random = new Random();


        //Calculating the total wage per month using loops
        //Max Working hours should be 100.

            for (int day = 1; day<=workingDaysPerMonth && maxWorkingHours<100; day++) {

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
                System.out.printf("Worked: %d hours, Earned: %d", empHours, empWage).println("\n");
                totalWage += empWage;
                maxWorkingHours += empHours; //Max Working Hours is 100, loop terminates if it is above 100.
            }
        System.out.println("The Total wage earned for this month is " + "$" +totalWage);
        System.out.println("Total hours worked: " + maxWorkingHours);

    }
}
