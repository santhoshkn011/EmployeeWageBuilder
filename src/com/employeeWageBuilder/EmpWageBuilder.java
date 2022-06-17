package com.employeeWageBuilder;
import java.util.Random; //importing Random function

public class EmpWageBuilder {
    public static void main(String args[]) {

        System.out.println("Welcome to Bridgelabz Employee Wage Builder.");

        int IS_FUll_TIME = 1;
        int EMP_RATE_PER_HOUR = 20;
        int empHours = 0;
        int empWage = 0;
        Random random = new Random();
        int empCheck = random.nextInt(2);

        if(empCheck == IS_FUll_TIME) {
            System.out.println("Employee is Present.");
            empHours = 8;
        }
        else {
            System.out.println("Employee is Absent.");
        }
        empWage = empHours*EMP_RATE_PER_HOUR;
        System.out.println("The daily wage is " + empWage);
    }
}
