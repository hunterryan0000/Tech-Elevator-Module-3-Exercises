package com.techelevator;

import java.util.Scanner;

public class ShelterApp {

    private Shelter mainShelter;
    private Scanner scanner;





    private ShelterApp(){


        this.mainShelter = new Shelter("TE Pet Shelter");
        this.scanner = new Scanner(System.in);


    }

    public static void main(String[] args) {
        //Use the default constructor
        //to create an instance/object that we can use to call non-static methods
        ShelterApp app = new ShelterApp();
        app.run();


    }

    //This will do all the things we want our application to do
  //  This is not static, so we can have and use other object/instance properties & methods
    //This is a common Java APP practice.
    private void run() {
        System.out.printf("Welcome to the TE Shelter application!\n");
        System.out.println();

        // Get user input


        //Want it use the scanner in other method,
        // so made it an object/instance property

        System.out.printf("Main Menu: \n");
        System.out.printf("1 - Enter a new pet\n");
        System.out.printf("2 - View all pets\n");
        System.out.println();

        //General rule of interface design, don't let your users feel stupid
        //Make it really clear what they need to do and what happened

        System.out.printf("What would you like to do?" + "(Enter the number for the option listed above):   ");
        String optionString = scanner.nextLine();


        if (optionString.equals("1")){
            // Enter a new pet
            doAddNewPet();
        } else if (optionString.equals("2")){
            //View all pets
            doViewAllPets();
        } else{
            //This is not a valid option
            System.out.println("Sorry that's not a valid option, please try again!");
        }




        scanner.close();

    }


    private void doAddNewPet() {
        System.out.println("Adding a new pet...");

        // Need to get some values from the user to create the Pet
        System.out.printf("Enter the pet's name: ");
        String name = scanner.nextLine();

        System.out.printf("Is this a cat or dog: ");
        String type = scanner.nextLine();

        Pet newPet = new Pet (name, type);
        System.out.println("Adding  " + newPet);

        mainShelter.addPet(newPet);
    }

    private void doViewAllPets(){
        System.out.println("Viewing all pets...");
    }


}
