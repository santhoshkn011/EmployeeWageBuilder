package com.employeeWageBuilder;
import java.util.Random; //importing Random function

public class EmpWageBuilder {
    public static void main(String args[]) {

        //Welcome message
        System.out.println("Welcome to Bridgelabz Employee Wage Builder.");

        //Declaring variables
        int EMP_RATE_PER_HOUR = 20;
        int empHours;
        int empWage;
        int totalWage = 0;
        int workingDaysPerMonth = 20; //Working days per month is 20 days
        Random random = new Random();


        //Calculating the total wage per month using for loop.

        for(int day=1; day<=workingDaysPerMonth; day++) {

            int empCheck = random.nextInt(3);

            switch (empCheck) {
                case 1:
                    System.out.printf("Day %d: Employee is Present.", day).println();
                    empHours = 8;
                    break;
                case 2:
                    System.out.printf("Day %d: Employee worked for half day.", day).println();
                    empHours = 4;
                    break;
                default:
                    System.out.printf("Day %d: Employee is Absent.", day).println();
                    empHours=0;
                    break;
            }
            empWage = empHours*EMP_RATE_PER_HOUR;
            System.out.println("Earned: $" + empWage + "\n");
            totalWage += empWage;
        }

        System.out.println("The Total wage earned for this month is " + "$" +totalWage);
    }
}
