package com.techelevator;
 /*
 This is how you use multi-line comments
  */
public class Notes {
    public static void main(String[] args) {

        int age = 26;

        // Starting this as false, because I want the conditional to set it
        boolean over21 = false;

        // Basic if/else
        if (age >= 21) {
            System.out.println("Woot! You're over 21!");
            over21 = true;
        } else {
            System.out.println("Woot! You're a youngster.");
            over21 = false; //  Don't have to do this cuz it is defaulted
        }

        // Ternary operator equivalent
        over21 = (age >= 21) ? true : false;

        String message = (age >= 21) ? "Woot! You're over 21" : "Woot! You're a youngster";
    }


}
