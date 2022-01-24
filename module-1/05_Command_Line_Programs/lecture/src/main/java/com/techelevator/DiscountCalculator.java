package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        // When you create a new scanner, you need to close it - Do that at the end
        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double, but for 15%, they should enter 15
        System.out.print("Enter the discount amount (w/out percentage): ");
        double discount = Double.parseDouble(scanner.nextLine());
        //System.out.println("You entered " + discount);


        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");
        String pricesString = scanner.nextLine();
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


        // Close the scanner
        scanner.close();


    }

}
