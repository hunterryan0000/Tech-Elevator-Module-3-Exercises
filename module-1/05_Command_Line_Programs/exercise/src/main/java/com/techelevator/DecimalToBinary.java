package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


		System.out.print("Please enter in a series of decimal values (separated by spaces): ");

		System.out.println();

		String decimalValuesEntered = scanner.nextLine();
		String[] decimalValuesSeparated = decimalValuesEntered.split(" ");


		for(int i = 0;  i < decimalValuesSeparated.length ; i++) {
			int inputNumber = Integer.parseInt(decimalValuesSeparated[i]);
			System.out.print(inputNumber + " in binary is ");

			decimalToBinary(inputNumber);
			System.out.println(" ");
		}

	}
	public static void decimalToBinary(int inputNumber){

		int binaryNumber[] = new int[900];
		int index = 0;

		while (inputNumber >0){

			binaryNumber[index ++] = inputNumber % 2 ;
			inputNumber = inputNumber / 2;
		}
		for(int i = index-1;i >= 0;i--) {
			System.out.print(binaryNumber[i]);


		}


	}


}
