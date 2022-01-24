package com.techelevator;

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
        int[] numberOfParts = {23, 4, 51, 36, 0, 42, 24, 31, 1, 2};

        int[] studentCount = new int[] {15, 18, 21, 19};

        int[] gameCount = new int[5];
        gameCount[0] = 4;
        gameCount[1] = 29;
        gameCount[2] = 328;
        gameCount[3] = 211;
        gameCount[4] = 35;



        // Do some loops on those arrays...

        // EXAMPLE::: Use numberOfParts array... give me back an array with the index positions that hold an even number
        // For this I want any zero values thrown out.
        //I expect back {1, 3, 5, 6, 9}

        // pattern, make a new array for the things you want to keep from another array
        int[] evenPartIndexes = new int[numberOfParts.length]; // I don't know how many even numbers
        int evenPartPosition = 0;

        for (int i = 0; i < numberOfParts.length; i++) {
            if (numberOfParts[i] != 0 && numberOfParts[i] % 2 == 0) {
                //no remainder when dividing by two so value is even
                evenPartIndexes[evenPartPosition] = i;
                evenPartPosition++;
            }
        }
                // did I get it right?  --- 1, 3, 5, 6, 9
            printArray(evenPartIndexes);
        System.out.println("How many *real* values are in my array? " +  evenPartPosition);


        int totalStudentCount = 0;
        for (int i = 0; i < studentCount.length; i++) {
            //totalStudentCount = totalStudentCount + studentCount[i];
            totalStudentCount += studentCount[i];
        }
        System.out.println("Total Student Count is " + totalStudentCount);



        int totalNumberOfGames = 0;
        for (int i = 0; i < gameCount.length; i++) {
            totalNumberOfGames += gameCount[i];
        }
        double averageNumberOfGames = ((double) totalNumberOfGames/gameCount.length);
        System.out.println("Average number of games:" + averageNumberOfGames);


        }

        //New method to print out array --- 5
        public static void printArray(int[] values) {
        System.out.println("values in the array are: ");
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }


}
