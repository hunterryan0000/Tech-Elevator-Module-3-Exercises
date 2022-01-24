package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

<<<<<<< HEAD
        // When you create a new scanner, you need to close it - Do that at the end
=======
        // When you create a Scanner, you need to close it - Do that at the end of the program
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd
        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double, but for 15%, they should enter 15
        System.out.print("Enter the discount amount (w/out percentage): ");
<<<<<<< HEAD
        double discount = Double.parseDouble(scanner.nextLine());
=======
        double discount = Double.parseDouble( scanner.nextLine() );
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd
        //System.out.println("You entered " + discount);


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String pricesString = scanner.nextLine();
<<<<<<< HEAD
       // System.out.println("You entered " + pricesString);

        //Take the input String, split it on the space characters into an array of separate string
        String[] pricesArray = pricesString.split(" ");

        for (int i = 0; i < pricesArray.length; i++) {
            //System.out.println(pricesArray[i]);

            // Turn my price into a double so i can do Math
            // note we really shouldn't use doubles for $ amounts
            // - we don't know how to solve this yet
            double originalPrice = Double.parseDouble(pricesArray[i]);

            // use the discount percent to find the discount amount
            // need to convert the discount from a whole number to a decimal - i.e 10 to .10
            double discountAmount = originalPrice * (discount/100);

            //use the original price - the discount amount to get the sale price
            double salePrice = originalPrice - discountAmount;

            System.out.println("OriginalPrice was " + originalPrice);
            System.out.println("Discount price is " + salePrice);
            System.out.println();  // create a space between Loops

        }
=======
        //System.out.println("You entered " + pricesString);
        System.out.println();

        // Take the input string, split it on the space characters into an array of separate string
        String[] pricesArray = pricesString.split(" ");

        // Goal is to print out for each price entered, the original price & the "sale" price
        // "sale" price is the price after subtracting the discount amount
        for (int i = 0; i < pricesArray.length; i++) {
            //System.out.println(pricesArray[i] + " ");

            // Turn my price into a double so I can do math
            // Note we really shouldn't use doubles for $ amounts
            // - we don't know how to solve this yet...
            double originalPrice = Double.parseDouble(pricesArray[i]);
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd

            // use the discount percent to find the discount amount
            // need to covert the discount from a whole number to decimal - ie 10 becomes .10
            double discountAmount = originalPrice * (discount /100);

<<<<<<< HEAD
        // Close the scanner
        scanner.close();
=======
            // use the original price - the discount amount to get the sale price
            double salePrice = originalPrice - discountAmount;
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd

            System.out.println("Original Price was " + originalPrice);
            System.out.println("Sale Price is " + salePrice);
            System.out.println();
        }

        // Close the Scanner when its not needed anymore
        scanner.close();
    }

}
