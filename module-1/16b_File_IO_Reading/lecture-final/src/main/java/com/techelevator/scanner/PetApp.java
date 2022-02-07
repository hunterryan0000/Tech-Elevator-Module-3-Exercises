package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PetApp {
    public static void main(String[] args) {

//        System.out.println("Processing CSV file (pets.csv) - expecting commas to separate data");
//        File inputFile = getInputFileFromUser();
//
//        try(Scanner scanner = new Scanner(inputFile)){
//
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                // Read the line and print it out as is - great starting point!
//                //System.out.println(line);
//
//                // Turn the line into a Cat object
//                Cat cat = new Cat();
//                String[] lineParts = line.split(", ");
//                // should get something like ["Abby", "14", "brown"]
//                cat.setName(lineParts[0]);
//                cat.setAge(Integer.parseInt(lineParts[1]));
//                cat.setColor(lineParts[2]);
//                System.out.println(cat);
//            }
//
//        } catch (FileNotFoundException e){
//            System.out.println("Sorry that file could not be found.");
//        }

        System.out.println("Processing pipe separated file (pets.txt)");
        File inputFile = getInputFileFromUser();

        try(Scanner scanner = new Scanner(inputFile)){

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // Read the line and print it out as is - great starting point!
                //System.out.println(line);

                // Turn the line into a Cat object
                Cat cat = new Cat();
                // split works on a regex - | is a special character in a regex,
                // so we need to escape is BUT we do that with \ and \ is also a special character in a regex
                // SO we also need to escape that with \
                String[] lineParts = line.split("\\|");
                // should get something like ["Abby", "14", "brown"]
                cat.setName(lineParts[0]);
                cat.setAge(Integer.parseInt(lineParts[1]));
                cat.setColor(lineParts[2]);
                System.out.println(cat);
            }

        } catch (FileNotFoundException e){
            System.out.println("Sorry that file could not be found.");
        }


    }

    private static File getInputFileFromUser() {
        Scanner userInput = new Scanner(System.in);


        File inputFile = null;
        boolean isValidFile = false;

        // while loops work on a boolean condition - something that evaluates to true/false
        // loops while the condition is true...
//		while (isValidFile == false) {
        while(!isValidFile) {
//		while(inputFile != null)

            // Prompt for a new file path
            System.out.print("Please enter path to input file >>> ");
            String path = userInput.nextLine();
            inputFile = new File(path);

            if (inputFile.exists() == false) { // checks for the existence of a file
                System.out.println(path + " does not exist");
//				inputFile = null; // bad file, set to null
//				System.exit(1); // Ends the program
            } else if (inputFile.isFile() == false) {
                System.out.println(path + " is not a file");
//				inputFile = null; // bad file, set to null
//				System.exit(1); // Ends the program
            } else {
                // Passed both checks so end loop
                isValidFile = true;
            }
        }

        return inputFile;
    }
}
