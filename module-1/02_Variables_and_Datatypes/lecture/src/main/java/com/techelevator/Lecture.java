package com.techelevator;

public class Lecture {

	public static void main(String[] args) {
		
		System.out.println("Hello Java Purple!!!");

		int totalNumberOfItems = 23;
		int salesMultiplier = 2;

		double result = (double) totalNumberOfItems / salesMultiplier;
		System.out.println("Result is " + result);

//					65		-	60	=	5
//				23 +	42		_	60
//					21 * 2			60
		result = totalNumberOfItems + 43 / 2 * salesMultiplier - 30 *2;
		System.out.println("Result is now " + result);

		int billion = 1000000000;
//		long billion = 1_000_000_000;
		int threeBillion = billion * 3;
		System.out.println("billion? " + billion);
		System.out.println("Three billion? " + threeBillion);

//		result is 2.0 because of it does interger division
		// then it is put in a double (result)
		result = 5 / 2;
		System.out.println("Result is " + result);

		// result is 1.0 because it is the remainder from integer division
		// Then it is put in a double because result is double
		result= 5 % 2;
		System.out.println("Result is " + result);

		// result is 2.5 because double is added to int 5
		result = (double) 5 / 2;
		System.out.println("Result is " + result);
	}

}
