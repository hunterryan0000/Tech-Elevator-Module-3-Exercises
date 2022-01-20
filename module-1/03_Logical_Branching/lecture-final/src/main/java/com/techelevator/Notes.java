package com.techelevator;

public class Notes {

    public static void main(String[] args) {

        // Review - variables
        // Variable declaration - making a variable for the first time
        String name;  // don't have to give a value
        int age = 0; // but you can give a value if you want
        boolean isCool = true;

        // Assigning / reassigning a variable w/ =
        name = "Mary";
        //age = 47; // changing value  or reassigning a value
        System.out.println("The name is " + name);

        // Conditionally assign a variable
        if (name == "Mary") {
            age = 42;
        } else {
            age = 21;
        }
        System.out.println("Age is " + age);

        // Cast to change type - it can be dangerous, try not to do it :-)
        long threeBillion = 3_000_000_000L;
        int tooSmall = (int) threeBillion;
        System.out.println("Too small should be 3 billion + " + tooSmall);

        long hundred = 100;
        int thisFits = (int) hundred;
        System.out.println("This fits should be 100 " + thisFits);

        int sum = 23 + 56 + 43 - 2; // The part on the right is an expression, it's a thing you can evaluate to a value

    // TODO - Talk about conditionals

        isCool = false; // reassign the value of isCool to false
        if (isCool == true) { // The part in () is an expression, specifically a boolean expression (it evaluates to true/false)
            System.out.println("We are super cool!!!");  // This will not run
        }

        if (isCool) {
            System.out.println("We are super cool!!!");
        }

        boolean isFunky = true;
        if (isCool && isFunky==false) {
            System.out.println("We are cool but not funky");
        }

        // Check is age between 30 and 40
        System.out.println("Age is " + age);
        if ( 30 < age && age < 40){
            System.out.println("Age is between 30 and 40");
        } else {
            System.out.println("Age is NOT between 30 and 40");
        }
    }

}
