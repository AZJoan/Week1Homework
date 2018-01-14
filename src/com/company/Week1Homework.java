package com.company;
//    Create a calculator! One that can add, subtract, multiply, and divide.
//    First ask the user to enter a number.
//    Then ask them what operator they want to use ("+", "-", "*", or "/").
//    Finally, ask them to enter a second number.
//    Display the corresponding calculation to the screen.
//
//    Feel free to take the calculator above and beyond, here are some ideas:
//   Ask the user if they would like to do another calculation,
//  Look into 'try/catch' to handle entries that were unexpected,
//  Carry the calculation over after an original calculation was done.
//   For example, 2 + 2 = 4, then prompt the user to use another operator (+, -, *, or /).
//    Then take the previous answer, with the new operator, and a new number for a new calculation.
//  With the above scenario, add a 'clear' entry option that starts the application over.


import java.util.Scanner;
//import javafx.util.StringConverter;

public class Week1Homework {

    public static void main(String[] args) {

        String firstNumber = " ";  // kept getting error variable not initialized so added = blank & it worked?
        String secondNumber;
        String operator;
        String saveResult = " ";  // kept getting error variable not initialized so added = blank & it worked?
        Boolean invalidOp;

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Calculator Application");

        Boolean cont1 = true;
        while (cont1) {

            System.out.println("Would you like to do a calculation?");
            String answer1 = sc.nextLine();
            Boolean firstIn = true;

            if (answer1.equalsIgnoreCase("yes") || answer1.equalsIgnoreCase("y")) {
                cont1 = true;

                // after user has entered a first calculation ask if user wants to continue calculating on result
                Boolean cont2 = true;
                while (cont2) {

                    // check if on first calculation or continuing with previous calculation
                    if (firstIn.equals(true))  {
                        firstIn = false;
                        System.out.println("Input First Number:");
                        firstNumber = sc.nextLine();

                    } else {
                        System.out.println("Would you like to continue calculations on your previous result?");
                        String answer2 = sc.nextLine();

                        // continuing with previous-keep looping-turn off first time in-use saved previous result
                        if (answer2.equalsIgnoreCase("yes") || answer2.equalsIgnoreCase("y")) {
                            cont2 = true;
                            firstIn = false;
                            firstNumber = saveResult;

                        } else { // user wants to start new calculation
                            cont2 = false;
                            firstIn= true;
                        }
                    }
                    // continuing with calculation request
                    if (cont2) {
                        System.out.println("Input one of the following valid operators: +, -, *, / :");
                        operator = sc.nextLine();

                        System.out.println("Input Second Number:");
                        secondNumber = sc.nextLine();

                        // variables for calculations
                        int intResult = 0;
                        int intFirst = 0;
                        int intSecond = 0;

                        //  Catch code errors
                        try {
                            intFirst = Integer.parseInt(firstNumber);
                            intSecond = Integer.parseInt(secondNumber);

                            // check if valid operator entered
                            invalidOp = false;
                            if (operator.equals("+")) {
                                intResult = (intFirst + intSecond);
                            } else if (operator.equals("-")) {
                                intResult = (intFirst - intSecond);
                            } else if (operator.equals("*")) {
                                intResult = (intFirst * intSecond);
                            } else if (operator.equals("/")) {
                                intResult = (intFirst) / (intSecond);
                            } else {
                                invalidOp = true;
                            }

                            // Tell user if invalid operator used and to redo calculation
                            if (invalidOp) {
                                System.out.println("Warning: Invalid Operator used. Please try again.");
                                cont2 = false;
                                firstIn= true;
                            } else {

                                // Display calculation results to the user
                                System.out.println("This is your result: "
                                    + intFirst + " " + operator + " " + intSecond + " = " + intResult);
                                saveResult = Integer.toString(intResult);
                                System.out.println();
                            }
                        // Display warning error message to user
                        } catch (ArithmeticException e) {
                            System.out.println("Warning: Arithmetic Error occurred. Please try again.");
                        } catch (Exception e) {
                            System.out.println("Warning: Please enter a valid number.");
                        } // try - catch

                    }  // if cont2 = true
                }  // while cont2 = true

             } else{ // user does not want to do a calculation
                cont1 = false;
            } // if answer1 = yes
        } // while cont1 = true
    }  // public static
} // public class


