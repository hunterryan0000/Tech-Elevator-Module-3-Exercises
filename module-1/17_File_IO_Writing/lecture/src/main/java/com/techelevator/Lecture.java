package com.techelevator;

import java.io.File;
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
		 */

		Scanner userScanner = new Scanner(System.in);
//		System.out.println("Enter a file or directory path: "); // this just shows a message (tells user what to enter)
//		String path = userScanner.nextLine();                    // this is the part that reads the user input
//
//		System.out.println("You entered: " + path);
//
//		//Does the file path the user entered exist
//		//Let's find out...
//		File file = new File(path);
//
//		if (file.exists()) {
//			System.out.println(file.getName() + " exists");
//			System.out.println("The absolute path is " + file.getAbsolutePath());
//		if (file.isDirectory()) {
//			System.out.println("This represents a directory. ");
//		} else if (file.isFile()) {
//			System.out.println("This represents a file. ");
//		}
//		System.out.println("The size is " + file.length());
//		} else {
//			System.out.println(file.getName() + " does not exists yet");
//		}

////		System.out.println("Lets make a new directory! Enter the path: ");
////		String newDirectoryPath = userScanner.nextLine();
////		File newDirectory = new File(newDirectoryPath);
////
////		if (newDirectory.exists()) {
////			System.out.printf("\n %s already exists. ", newDirectory.getAbsolutePath());
////		} else {
////			System.out.printf("\n Creating directory at %s", newDirectory.getAbsolutePath());
////			if (newDirectory.mkdirs()) { // mkdirs creates multiple directories, mkdir just 1 (main folder)
////				System.out.println("\n Created the new directory. ");
////			} else{
////				System.out.println("\n Could not create the new directory.");
////			}
//		}

		System.out.println("Lets make a new file! Woot!");
		String newFilePAth = userScanner.nextLine();
		File newFile = new File(newFilePAth);

		if (newFile.exists()) {
			System.out.printf("%s already exists. ", newFile.getAbsolutePath());
		} else {
			System.out.println("Making a new file");
			if (newFile.createNewFile()) {
				System.out.printf("Made a new file %s", newFile.getAbsolutePath());
			} else {
				System.out.println("Sorry could not create the new file");
			}
		}

		// CLose the scanner for user input
		userScanner.close();

	}

}
