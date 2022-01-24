package com.techelevator;

<<<<<<< HEAD
import org.w3c.dom.ls.LSOutput;

import javax.sql.rowset.serial.SQLOutputImpl;
import java.sql.SQLOutput;

public class Notes {
    // Remember that for a class file to be runnable it MUST have a main method.
    // (If you look at exercise files & can't run those, maybe there is no main...
    // if there is no main, you probably run them some other way Tests
    // or through another file with a main.)
    public static void main(String[] args) {

        // Array review - AT LEAST 3 diff ways to make an array
=======
public class Notes {
    // Remember that for a class file to be runnable it MUST have a main method.
    // (If you look at exercise files & can't run those, maybe there is no main...
    //  if there is no main, you probably run them some other way Tests
    //  or through another file with a main.)
    public static void main(String[] args) {

        // Array review - at least 3 different ways to make an array
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd
        int[] numberOfParts = {23, 4, 51, 36, 0, 42, 24, 31, 1, 2};

        int[] studentCount = new int[] {15, 18, 21, 19};

        int[] gameCount = new int[5];
        gameCount[0] = 4;
        gameCount[1] = 29;
<<<<<<< HEAD
        gameCount[2] = 328;
        gameCount[3] = 211;
        gameCount[4] = 35;

=======
        gameCount[2] = 348;
        gameCount[3] = 211;
        gameCount[4] = 35;
        // Can't do this... will get ArrayIndexOutOfBoundsException
        //gameCount[5] = 92;
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd


        // Do some loops on those arrays...

<<<<<<< HEAD
        // EXAMPLE::: Use numberOfParts array... give me back an array with the index positions that hold an even number
        // For this I want any zero values thrown out.
        //I expect back {1, 3, 5, 6, 9}

        // pattern, make a new array for the things you want to keep from another array
        int[] evenPartIndexes = new int[numberOfParts.length]; // I don't know how many even numbers
=======
        // Use numberOfParts array... give me back an array with the index positions that hold a even number
        // For this I want any zero values thrown out.
        // I expect back {1, 3, 5, 6, 9}

        // pattern, make a new array for the things you want to keep from another array
        // I don't know how many even numbers there will be, BUT it can't be more than the size of the array
        int[] evenPartIndexes = new int[numberOfParts.length];
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd
        int evenPartPosition = 0;

        for (int i = 0; i < numberOfParts.length; i++) {
            if (numberOfParts[i] != 0 && numberOfParts[i] % 2 == 0) {
<<<<<<< HEAD
                //no remainder when dividing by two so value is even
=======
                // no remainder when dividing by two so value is even
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd
                evenPartIndexes[evenPartPosition] = i;
                evenPartPosition++;
            }
        }
<<<<<<< HEAD
                // did I get it right?  --- 1, 3, 5, 6, 9
            printArray(evenPartIndexes);
        System.out.println("How many *real* values are in my array? " +  evenPartPosition);


=======

        // Did I get the right results?
        printArray(evenPartIndexes);
        System.out.println("How many *real* values are in my array? " + evenPartPosition );

        // Using the studentCount array which has a values for the number of students in each room
        // Give me the total number of students overall.
        // Another pattern - create a variable (accumulator) outside the loop to add onto while iterating/looping
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd
        int totalStudentCount = 0;
        for (int i = 0; i < studentCount.length; i++) {
            //totalStudentCount = totalStudentCount + studentCount[i];
            totalStudentCount += studentCount[i];
        }
<<<<<<< HEAD
        System.out.println("Total Student Count is " + totalStudentCount);



=======
        System.out.println("Total number of students is " + totalStudentCount);

        // Using the gameCount array to determine the average number of games
        // This is similar to the above pattern, but with a little tweak to it
        int numberOfPeopleWithGames = gameCount.length;
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd
        int totalNumberOfGames = 0;
        for (int i = 0; i < gameCount.length; i++) {
            totalNumberOfGames += gameCount[i];
        }
<<<<<<< HEAD
        double averageNumberOfGames = ((double) totalNumberOfGames/gameCount.length);
        System.out.println("Average number of games:" + averageNumberOfGames);


        }

        //New method to print out array --- 5
        public static void printArray(int[] values) {
        System.out.println("values in the array are: ");
=======
        double averageNumberOfGames = (totalNumberOfGames / (double) numberOfPeopleWithGames);
        System.out.println("Average number of games:" + averageNumberOfGames);
    }

    // Make a new method to print out an array
    public static void printArray(int[] values) {
        System.out.println("Values in the array are: ");
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
<<<<<<< HEAD


=======
>>>>>>> 6e5f71f939f0a0ae8d4e086bfb120c38de92c1bd
}
