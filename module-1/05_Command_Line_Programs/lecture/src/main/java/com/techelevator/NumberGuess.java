package com.techelevator;

import java.util.Scanner;

/*
This game will get a random number between 1 - 100. Then the user can guess a number
(enter on command line). We celebrate if that number is correct, but if not we tell them guess higher
or lower.

TODO - future ideas

    - Later maybe v2, we can:
    - prompt for a max number to limit this.
    -maybe have a max number of guesses
    -ask do you want to play again
 */

class NumberGuess {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to number guess!");

        //TODO - get a random number to guess.. Look up on the web?
        int numberToGuess = 42;
        // Loop for guessing and checking the answer
        // This can't be a for loop... we don't know how many times to loop...
        // This is a good use of a while loop
        boolean guessIsCorrect = false;
        while (!guessIsCorrect) {

            // Prompt the user to guess a number
            System.out.println("Guess a number");
            int guess = Integer.parseInt(scanner.nextLine());
            System.out.println("You guessed " + guess);
            // Check to see if it is right...
            if (guess == numberToGuess) {
                // if so, done. Print Victory message and end
                System.out.println("Victory, that's correct!!!");
                // end the loop
                guessIsCorrect = true; // stops loop
            }
            // if not, we need to decide ift it's too high or low and print that message
            else if (guess < numberToGuess) {
                System.out.println("Your guess is to low...");
            } else if (guess > 100) {
                System.out.println("Guess out of range...");
            } else {
                System.out.println("Your guess is to high...");
            }

        }



        // Close the scanner
        scanner.close();

    }

    }


