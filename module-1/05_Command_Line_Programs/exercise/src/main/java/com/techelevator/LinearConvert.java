package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter the length: ");
		double measurement = scanner.nextDouble();
		System.out.println();

		System.out.print("Is the measurement in (m)eter or (f)eet?");
		String mOrF = scanner.next();
		System.out.println();


		double m = measurement * 0.3048;
		double f = measurement * 3.2808399;


		if (mOrF.equals("f")) {
			System.out.println(measurement + mOrF + " is " + m + "m");
		} else if (mOrF.equals("m")) {
			System.out.println(measurement + mOrF + " is " + f + "f");
		}


		scanner.close();

	}

}
