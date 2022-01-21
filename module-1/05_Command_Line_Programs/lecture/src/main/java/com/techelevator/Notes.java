package com.techelevator;

public class Notes {
    // Remember that for a class file to be runnable it MUST have a main method.
    // (If you look at exercise files & can't run those, maybe there is no main...
    //  if there is no main, you probably run them some other way Tests
    //  or through another file with a main.)
    public static void main(String[] args) {

        // Array review - at least 3 different ways to make an array
        int[] numberOfParts = {23, 4, 51, 36, 0, 42, 24, 31, 1, 2};

        int[] studentCount = new int[] {15, 18, 21, 19};

        int[] gameCount = new int[5];
        gameCount[0] = 4;
        gameCount[1] = 29;
        gameCount[2] = 348;
        gameCount[3] = 211;
        gameCount[4] = 35;
        // Can't do this... will get ArrayIndexOutOfBoundsException
        //gameCount[5] = 92;


        // Do some loops on those arrays...

        // Use numberOfParts array... give me back an array with the index positions that hold a even number
        // For this I want any zero values thrown out.
        // I expect back {1, 3, 5, 6, 9}

        // pattern, make a new array for the things you want to keep from another array
        // I don't know how many even numbers there will be, BUT it can't be more than the size of the array
        int[] evenPartIndexes = new int[numberOfParts.length];
        int evenPartPosition = 0;

        for (int i = 0; i < numberOfParts.length; i++) {
            if (numberOfParts[i] != 0 && numberOfParts[i] % 2 == 0) {
                // no remainder when dividing by two so value is even
                evenPartIndexes[evenPartPosition] = i;
                evenPartPosition++;
            }
        }

        // Did I get the right results?
        printArray(evenPartIndexes);
        System.out.println("How many *real* values are in my array? " + evenPartPosition );

        // Using the studentCount array which has a values for the number of students in each room
        // Give me the total number of students overall.
        // Another pattern - create a variable (accumulator) outside the loop to add onto while iterating/looping
        int totalStudentCount = 0;
        for (int i = 0; i < studentCount.length; i++) {
            //totalStudentCount = totalStudentCount + studentCount[i];
            totalStudentCount += studentCount[i];
        }
        System.out.println("Total number of students is " + totalStudentCount);

        // Using the gameCount array to determine the average number of games
        // This is similar to the above pattern, but with a little tweak to it
        int numberOfPeopleWithGames = gameCount.length;
        int totalNumberOfGames = 0;
        for (int i = 0; i < gameCount.length; i++) {
            totalNumberOfGames += gameCount[i];
        }
        double averageNumberOfGames = (totalNumberOfGames / (double) numberOfPeopleWithGames);
        System.out.println("Average number of games:" + averageNumberOfGames);
    }

    // Make a new method to print out an array
    public static void printArray(int[] values) {
        System.out.println("Values in the array are: ");
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }
    }
}
