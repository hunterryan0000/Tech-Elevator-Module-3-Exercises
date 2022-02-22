package com.techelevator;

import javax.print.DocFlavor;
import java.util.Scanner;

public class Fibonacci {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int fib2 = 0;
		int fibonacci = 1;
		int fib1;

		System.out.print("Please enter a number: ");
		int NUMBER = scanner.nextInt();

		System.out.println();

		System.out.println("The Fibonacci numbers are: ");



		for (fib1 = 1; fib2 <= NUMBER; fib1++) {
			fib1 = fib2;
			fib2 = fibonacci;
			fibonacci = fib1 + fib2;
			System.out.print(fib1 + " ");
		} if (NUMBER == 0) {
			System.out.print("1");
		}


		scanner.close();
	}
}


