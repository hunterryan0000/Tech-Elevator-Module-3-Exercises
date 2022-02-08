package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 *
		 * Windows ex:
		 * C:\Users\Student\workspace\other\nlr6-jan22-java-purple\module-1\17_File_IO_Writing\lecture-final
		 *
		 * Mac ex:
		 * /usr/Student/workspace
		 */

		Scanner userScanner = new Scanner(System.in);
		System.out.println("Enter a file or directory path: "); // this just shows a message (tells user what to enter)
		String path = userScanner.nextLine();                   // this is the part that reads the user input

		System.out.println("You entered: " + path);

		// Does the file path the user entered exist
		// Let's find out...
		File file = new File(path);

		if(file.exists()) {
			System.out.println(file.getName() + " exists");
			System.out.println("The absolute path is " + file.getAbsolutePath());
			if(file.isDirectory()) {
				System.out.println("This represents a directory.");
			} else if (file.isFile()) {
				System.out.println("This represents a file.");
			}
			System.out.println("The size is " + file.length());
		} else {
			System.out.println(file.getName() + " does not exist yet");
		}

		System.out.println("Let's make a new directory! Enter the path: ");
		String newDirectoryPath = userScanner.nextLine();
		File newDirectory = new File(newDirectoryPath);

		if (newDirectory.exists()) {
			System.out.printf("%s already exists.\n", newDirectory.getAbsolutePath());
		} else {
			System.out.printf("Creating directory at %s\n", newDirectory.getAbsolutePath());
			if (newDirectory.mkdirs()){ // mkdirs will create multiple directories, mkdir only 1
				System.out.printf("Created the new directory.\n");
			} else {
				System.out.printf("Could not create the new directory.\n");
			}
		}

		System.out.println("Let's make a new file! Woot!");
		System.out.println("Enter the file name: ");
		String newFilePath = userScanner.nextLine();
		File newFile = new File(newFilePath);

		if(newFile.exists()) {
			System.out.printf("%s already exists.\n", newFile.getAbsolutePath());
		} else {
			System.out.println("Making new file...");
			if(newFile.createNewFile()){
				System.out.printf("Made new file at %s\n", newFile.getAbsolutePath());
			} else {
				System.out.println("Sorry could not create the file.");
			}
		}

		System.out.println("We are going to write to test.txt file");
		File outputFile = new File("test.txt");



		// Can do this without the try, BUT you MUST manage your resource cleanup
//		PrintWriter printWriter = new PrintWriter(outputFile);
//		printWriter.write(textToWrite);
//		printWriter.close();

		// Using the try w/ resources is the BETTER pattern

		// This method will overwrite anything currently in the file.
		//try(PrintWriter printWriter = new PrintWriter(outputFile)){

		// This method allows you to append contents to the existing file data.
		try (PrintWriter printWriter = new PrintWriter( new FileOutputStream(outputFile, true) )) {
			boolean continueWriting = true;
			while(continueWriting) {
				System.out.println("Enter some text to write to the file: ");
				String textToWrite = userScanner.nextLine();
				printWriter.write(textToWrite + "\n");
				System.out.println("Would you like to write more stuff? Enter Q to stop.");
				String response = userScanner.nextLine();
				if (response.equalsIgnoreCase("Q")){
					continueWriting = false; //STOP the loop
				}
			}
		} // closes our resources, in this case the printWriter, which flushes our buffer, writing to the file.

		System.out.println("This is writing to the out output");
		System.err.println("This is writing the the err output");


		// Close the scanner for user input
		userScanner.close();

	}

}
