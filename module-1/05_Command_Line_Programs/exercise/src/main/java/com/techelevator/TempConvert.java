package com.techelevator;

import java.util.Objects;
import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);


			System.out.println("Please enter the temperature: ");
			double temp = scanner.nextDouble();

			System.out.println("");

			System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit? ");
			String whichIsIt = scanner.next();

			System.out.println("");


		double tempC = (temp - 32) / 1.8;
		double tempF = temp * 1.8 + 32;


		if (whichIsIt.equals("F")) {
				System.out.println(temp + whichIsIt + " is " + tempC + "C");
			} 	else if (whichIsIt.equals("C")) {
				System.out.println(temp + whichIsIt + " is " + tempF + "F");
			}
		System.out.println("\n \nYay for conversions! Woooo!!!!");


			scanner.close();
		}

	}

