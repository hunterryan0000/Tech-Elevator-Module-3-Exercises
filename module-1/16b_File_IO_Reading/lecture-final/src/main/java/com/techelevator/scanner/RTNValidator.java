package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RTNValidator {
	
	private static final int[] CHECKSUM_WEIGHTS = new int[] { 3, 7, 1, 3, 7, 1, 3, 7, 1 };

	public static void main(String[] args) {

		printApplicationBanner();
		
		File inputFile = getInputFileFromUser();
		try(Scanner fileScanner = new Scanner(inputFile)) {

			System.out.println("Invalid checksums: ");
			// while the file has a next line
			while(fileScanner.hasNextLine()) {
				// grab the next line of text from the file
				String line = fileScanner.nextLine();
				String rtn = line.substring(0, 9);


				if(checksumIsValid(rtn) == false) {
					System.out.println(line);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, we could not locate that file...");
		}

	}

	private static void printApplicationBanner() {
		System.out.println("******************");
		System.out.println("RTN Validator 9000");
		System.out.println("******************");
		System.out.println();
	}

	@SuppressWarnings("resource")
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

	private static boolean checksumIsValid(String routingNumber) {
		int checksum = 0;
		for(int i = 0; i < 9; i++) {
			int digit = Integer.parseInt(routingNumber.substring(i, i+1));
			checksum += digit * CHECKSUM_WEIGHTS[i];
		}
		return checksum % 10 == 0;
	}
}
