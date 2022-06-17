package com.employeeWageBuilder;
import java.util.Random; //importing Random function

public class EmpWageBuilder {
    public static void main(String args[]) {

        //Welcome message
        System.out.println("Welcome to Bridgelabz Employee Wage Builder.");

        //Declaring variables
        int EMP_RATE_PER_HOUR = 20;
        int empHours = 0;
        int empWage = 0;
        Random random = new Random();
        int empCheck = random.nextInt(3);

        //Using switch and case.
        switch (empCheck) {
            case 1:
                System.out.println("Employee is Present.");
                empHours = 8;
                break;
            case 2:
                System.out.println("Employee worked for half day.");
                empHours = 4;
                break;
            default:
                System.out.println("Employee is Absent.");
                break;
        }

        empWage = empHours*EMP_RATE_PER_HOUR;
        System.out.println("The daily wage is " + empWage);
    }
}
