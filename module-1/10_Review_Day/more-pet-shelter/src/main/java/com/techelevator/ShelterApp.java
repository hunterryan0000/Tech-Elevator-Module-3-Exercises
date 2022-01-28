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

        // Loop until the user chooses to exit the program
        // This will keep the program running so we can make multiple selections.
        boolean runProgram = true;
        while (runProgram) {

            // Made a method to show menu and get a valid menu option
            int mainMenuOption = getMainMenuSelection();

            // Based on option entered, let's do the appropriate thing...
            if (mainMenuOption == 0) {
                // Quit
                runProgram = false;
            } else if (mainMenuOption == 1) {
                // Enter a new pet
                // Made a method to handle the details to keep this code cleaner
                doAddNewPet();
            } else if (mainMenuOption == 2) {
                // View all pets
                doViewAllPets();
            } else {
                // This shouldn't happen, but just in case...
                System.out.println("That option is not available. Try again.");
            }
        }

        // Done, so close scanner
        scanner.close();
    }

    private int getMainMenuSelection() {

        final int MAX_OPTION = 2;
        // Display the menu
        System.out.println();
        System.out.println("Main Menu:");
        System.out.println("0 - Exit the program");
        System.out.println("1 - Enter a new pet");
        System.out.println("2 - View all pets");
        System.out.println();

        // General rule on user interface design, don't let your users feel stupid
        // Make it really clear to them what they need to do, and what happened
        System.out.printf("What would you like to do? " +
                "(Enter the number for the option listed above): ");

        // Get the user input...
        String optionString = scanner.nextLine();
        int option = Integer.parseInt(optionString); // convert to int for easy validation

        // Continue prompting for input until we get a valid selection
        while (option < 0 || option > MAX_OPTION) {
            System.out.println("Sorry that is not a valid option. Please try again.");
            System.out.printf("What would you like to do? " +
                    "(Enter the number for the option listed above): ");
            optionString = scanner.nextLine();
            option = Integer.parseInt(optionString);
        }

        // We have a valid option, so return it
        return option;
    }

    private void doAddNewPet() {
        System.out.println();
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

        // TODO - prompt for other values

        // Add the pet, then tell the user it worked
        mainShelter.addPet(newPet);

        // Could use a custom formatted string
        System.out.printf("Added %s with name %s.\n", newPet.getType(), newPet.getName());

        // OR let it call the toString method
        //System.out.println("Adding " + newPet + " to our shelter.");
    }

    private void doViewAllPets() {
        System.out.println();
        System.out.println("Viewing all pets...");

        // If there are no pets, don't let it "look" wrong, say so
        if (mainShelter.getPets().length == 0){
            System.out.println("We have no pets at this time.");
        }

        //Loop over the list of pets from the shelter and print out each one
        for (Pet pet : mainShelter.getPets() ) {
            System.out.println(pet);
        }
    }
}
