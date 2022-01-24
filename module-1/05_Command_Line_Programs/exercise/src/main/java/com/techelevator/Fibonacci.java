package com.techelevator;

import java.util.Scanner;

public class Fibonacci {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int fib2=1;
		int fibonacci=1;
		int fib1;

		System.out.print("Please enter a number: ");
		int NUMBER = scanner.nextInt();

		System.out.println();

		System.out.println("The Fibonacci numbers leading up to " + NUMBER + " are: ");

		 if(NUMBER>1) {
			 System.out.print("0 1 1 ");

			for(fib1=1; fib1+fib2 < NUMBER;) {
				fibonacci = fib1 + fib2;
				fib1 = fib2;
				fib2 = fibonacci;
				System.out.print(fibonacci + " ");
			}

		}

			scanner.close();
	}

}
