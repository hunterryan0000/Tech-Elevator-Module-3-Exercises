package com.techelevator;

import java.sql.SQLOutput;

public class Notes {

    public static void main(String[] args) {


        // Review - variables
        // Variable declaration - making a variable for the first time
        String name; // Don't have to give value
        int age = 26;  // but you can give value if you want
        boolean isCool = true;

        // Assigning / reassigning a variable w/ =
        name = "Ryan";  //
        age = 27; // reassigned age by changing the value. I turn 27.
        System.out.println("The name is " + name);

        // Cast to change types - can be dangerous try not to do this
        long threeBillion = 3_000_000_000L;  // the L at the end declares the long on the right side
        int tooSmall = (int) threeBillion;
        System.out.println("Too small should be 3 billion + " + tooSmall);

        long hundred = 100;
        int thisFits = (int) hundred;
        System.out.println("This fits should be 100 " + thisFits);

        int sum = 23 + 56 + 43 - 2; // The part ob the right of the = is an expression, it's a thing you can evaluate to a value

        //TODO - talk about conditionals

        isCool = false; // reassign the value of isCool to false
        if (isCool == true) { // THe part in () is an expression, specifically a boolean expression
            System.out.println("We are super cool!!!"); // This will not run if isCool is false
        }

        if (isCool) {
            System.out.println("We are super cool!!!");
        }

        boolean isFunky = true;  // isFunky is true
        if ((isCool && !isFunky) == false) {  // if isCool which is false AND not isFunky which is false
            System.out.println("We are lame");
        }

        System.out.println("Age is " + age);
        if ( 30 < age && age < 40 ) {
            System.out.println("Age is between 30 and 40");
        } else {
            System.out.println("Age is NOT between 30 and 40");
        }

    }

}
