package com.techelevator;

import java.io.*;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("What is your destination file?");
		String destinationFilePath = scanner.nextLine();
		File destinationFile = new File(destinationFilePath);
		boolean doesExist = true;


		try (PrintWriter printWriter = new PrintWriter( new FileOutputStream(destinationFile, true) )) {
				boolean fizzBuzz = true;
				while (fizzBuzz)
					for (int i = 1; i <= 300; i++) {
						if (i % 3 == 0 && i % 5 == 0) {
							printWriter.println("FizzBuzz");
						} else if (i % 3 == 0) {
							printWriter.println("Fizz");
						} else if (i % 5 == 0) {
							printWriter.println("Buzz");
						} else {
							printWriter.println(Integer.toString(i));
						} fizzBuzz = false;
					}
			} catch (FileNotFoundException e) {
				System.out.println("Can't open the file");
			}

		scanner.close();

	}
}
