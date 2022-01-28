package com.techelevator;

import java.util.Scanner;

public class ShelterApp {

    // OK to have properties inside of same class as main, but also not super common
    private Shelter mainShelter;

    // Getting input in multiple methods, so declared it up here
    private Scanner scanner;

    // OK to have private constructors, but not something you see a lot
    private ShelterApp() {
        // initialize instance variables
        this.mainShelter = new Shelter("TE Pet Shelter");
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        // Use the default constructor (provided cuz I didn't write one)
        // to create an instance/object that we can use to call non-static methods.
        ShelterApp app = new ShelterApp();
        app.run();

        //Close the scanner here is a possiblity too...
        //app.scanner.close();
    }

    // This will do all the things we want our application to actually do
    // This is not static, so we can have and use other object/instance properties & methods
    // This is a common Java Application practice.
    private void run() {
        System.out.printf("Welcome to the TE Shelter application!\n");
        System.out.println();

        // Create the scanner to get user input - close at end of program
        // Scanner scanner = new Scanner(System.in);
        // Want to use the scanner in other method,
        // so made it a object/instance property

        System.out.printf("Main Menu:\n");
        System.out.printf("1 - Enter a new pet\n");
        System.out.printf("2 - View all pets\n");
        System.out.println();

        // General rule on user interface design, don't let your users feel stupid
        // Make it really clear to them what they need to do, and what happened
        System.out.printf("What would you like to do? " +
                "(Enter the number for the option listed above): ");
        String optionString = scanner.nextLine();

        // TODO - Probably good to continue prompting until we get a good value
        //    (Just get it working with the happy path first!!!)

        // Based on option entered, let's do the appropriate thing...
        if ( optionString.equals("1") ) {
            // Enter a new pet
            // TODO - make a method to handle this to keep this code cleaner
            //this.doAddNewPet(); // can use this, but most people don't
            doAddNewPet();
        } else if ( optionString.equals("2") ) {
            // View all pets
            // TODO - make a method to handle this...
            doViewAllPets();
        } else {
            // This is not a valid option
            System.out.println("Sorry that's not a valid option. Try again.");
        }

        // Done, so close scanner
        scanner.close();
    }

    private void doAddNewPet() {
        System.out.println("Adding a new pet...");

        // Need to get some values from the user to create the Pet
        System.out.printf("Enter the pet's name: ");
        String name = scanner.nextLine();

        System.out.printf("Is this a cat or a dog: ");
        String type = scanner.nextLine();

        // Got the values, create the pet
        // Constructor sets the name & type
        Pet newPet = new Pet(name, type);

        // Add an age for our pet
        System.out.printf("What is the pet's age: ");
        String stringAge = scanner.nextLine();
        int intAge = Integer.parseInt(stringAge);
        // Use the age setter to update the newPet
        newPet.setAge(intAge);

        // Code below uses the toString method in Pet class
        // (by default) to print the Pet object
        System.out.println("Adding " + newPet + ". Pet's age is " + newPet.getAge());


        // Add the pet to the shelter
        mainShelter.addPet(newPet);
    }

    private void doViewAllPets() {
        System.out.println("Viewing all pets...");
    }
}
