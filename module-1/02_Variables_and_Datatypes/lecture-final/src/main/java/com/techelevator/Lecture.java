package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		System.out.println("Hello Java Purple!!!");

		int totalNumberOfItems = 23;
		int salesMultipler = 2;

		double result = (double) totalNumberOfItems / salesMultipler;
		System.out.println("Result is " + result);

		//       65 - 60 = 5
		//       23 +    42   - 60
		//             21 * 2       60
		result = totalNumberOfItems + ((43 / 2) * salesMultipler) - (30 * 2);
		System.out.println("Result is now... " + result);

		int billion = 1000000000;
//		long billion = 1_000_000_000;
		int threeBillion = billion * 3;
		System.out.println("billion? " + billion);
		System.out.println("Three billion? " + threeBillion);

		// result here is 2.0 - it does integer division (dropping the remainder part) first
		//   THEN it puts it into the double.
		result	 = 5 / 2;
		System.out.println("Result is " + result);

		// modulus operator - remainder from integer division
		result	 = 5 % 2;
		System.out.println("Result is " + result);

		// result here is 2.5 - because something on the right is a decimal type.
		result	 = 5 / 2.0;
		System.out.println("Result is " + result);

		double myDouble = 2.5;
		int two = (int) myDouble;
		System.out.println("two is " + two);
	}

}
