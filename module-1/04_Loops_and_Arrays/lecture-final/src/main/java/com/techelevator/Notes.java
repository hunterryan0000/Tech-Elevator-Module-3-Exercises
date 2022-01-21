package com.techelevator;

import java.sql.SQLOutput;

/*
 Generally I only use multi-line comments for documenting / describing what happens
 in a class or method...
 */
public class Notes {
    public static void main(String[] args) {

        int age = 31;

        // Starting this as false, because I want the conditional to set it.
        boolean over21 = false;

        // Basic if/else
        if (age >= 21) {
            System.out.println("Woot! You're over 21!");
            over21 = true;
        } else {
            System.out.println("Woot! You're a youngster.");
            // Don't *have* to do this cuz it is the default, but it's more clear
            // continue long lines on a new line after about 80 characters
            over21 = false;
        }

        // Ternary operator equivalent
        over21 = (age >= 21) ? true : false;

        String message = (age >= 21) ? "Woot! You're over 21" : "Woot! You're a youngster";

        Notes instanceOfNotes = new Notes();
        int result = instanceOfNotes.loneSum(1, 2, 3);
        System.out.println("Result of loneSum is (should be 6)" + result);

        result = instanceOfNotes.loneSum(3, 2, 3);
        System.out.println("Result of loneSum is  (should be 2)" + result);

        result = instanceOfNotes.loneSum(3, 3, 3);
        System.out.println("Result of loneSum is  (should be 0)" + result);

        result = instanceOfNotes.loneSum(3, 3, 2);
        System.out.println("Result of loneSum is  (should be 2)" + result);

        result = instanceOfNotes.loneSum(3, 2, 2);
        System.out.println("Result of loneSum is (should be 3)" + result);
    }

    /*
     34. Given 3 int values, a b c, return their sum.
     However, if one of the values is the same as another
     of the values, it does not count towards the sum.
     loneSum(1, 2, 3) → 6
     loneSum(3, 2, 3) → 2
     loneSum(3, 3, 3) → 0
     */

    // 1st take on this problem...
//    public int loneSum(int a, int b, int c) {
//        System.out.println("Hello PURPLE!!!");
//
//        if (a == b) {
//            if (a == c) {
//                return 0; // covers all 3 same
//            } else {      // covers a / b same
//                return c;
//            }
//        }
//        // Here i know a != b - they are not the same
//        if ( b == c ) { // a different, b/c same
//            return a;
//        } else {
//            if (a == c) {
//                return b;       // b different, a/c same
//            } else {
//                return a + b + c;  // all 3 must be different
//            }
//        }
//    }

    public int loneSum(int a, int b, int c) {
        System.out.println("Hello PURPLE!!!");

        if ((a == b) && (a == c)) {
            return 0; // covers all 3 same
        }
        if ((a==b) && (a != c)) {      // covers a / b same
            return c;
        }
        // Here i know a != b - they are not the same
        if ((b == c) && (a != c)) { // a different, b/c same
            return a;
        }
        if ((b != c) && (a==c)) {
            return b;       // b different, a/c same
        }
        if ((b != c) && (a!=c)) {
            return a + b + c;  // all 3 must be different
        }
        return 0;
    }

}

