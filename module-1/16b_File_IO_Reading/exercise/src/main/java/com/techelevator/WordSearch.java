package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int lineCount = 0;
		boolean caseSensitivity = false;
		String foundIt = "";

		//Prompt the user for a filesystem path
		System.out.println("Enter a file name to be searched: ");
		//filePath is created from user's input
		String filePath = scanner.nextLine();
		//Prompt user to search for word
		System.out.println("What word would you like to search for?");
		//Saves user input
		String wordToBeSearched = scanner.nextLine();

		System.out.println("Should the search be case sensitive? (Y/N)");

		String isItSensitive = scanner.nextLine();

		if (isItSensitive.equals("Y")) {
			caseSensitivity = true;
		} else if (isItSensitive.equals("N")) {
			caseSensitivity = false;
		} else {
			System.out.println("Invalid Input");
		}
		//File object created
		File searchedFile = new File(filePath);
		//Open the file
		try (Scanner fileInput = new Scanner((searchedFile))) {
			if (caseSensitivity)
				//Loop until the end of the file is reached
				while (fileInput.hasNextLine()) {
					//Read/Copy text in file into 'wonderlandText'
					String wonderlandText = fileInput.nextLine();
					//count each line as wonderlandText loops
					lineCount++;
					// if dog is in Alice...
					if (wonderlandText.contains(wordToBeSearched)) {
						System.out.println(lineCount + ") " + wonderlandText);
					}
				}
				// if case-insensitive
			else if (!caseSensitivity) {
				//Loop until the end of the file is reached
				while (fileInput.hasNextLine()) {
					// count each line
					lineCount++;
					//Ready/copy files into wonderland
					String wonderlandText = fileInput.nextLine();
					// turns to lowercase
					String toLowerCase = wonderlandText.toLowerCase();
					if (toLowerCase.contains(wordToBeSearched)) {
						System.out.println(lineCount + ") " + wonderlandText);
					}

				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("The entered name is not a file: " + searchedFile.getAbsolutePath());
		}
		scanner.close();
	}
}
