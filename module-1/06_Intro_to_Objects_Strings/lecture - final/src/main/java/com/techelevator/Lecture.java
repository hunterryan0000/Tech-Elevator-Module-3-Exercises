package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		// Strings are objects! Woot!
		//System.out.println("Woot! Today we're working with String objects!");

		String className = "Java Purple";
		//int[] numbers = new int[5];
		String[] students = {"Kris", "Brian", "Elizabeth"};
		int classSize = students.length;
		double bigger = classSize;
		int tooSmall = (int)bigger;

		className = "Java Green";
//		className = " A " + "Wonderful" + "Classname!" + "Woot!";


		// How long is the string className
		System.out.println("Classname is: " + className + ". It's length is "
				+ className.length() + " chacters.");

		// Get part of a string
		System.out.println("First part is: " + className.substring(0, 4));
		//System.out.println("Last part is: " + className.substring(5, className.length()));
		System.out.println("Last part is: " + className.substring(5));

		// Replace, get rid of spaces
		System.out.println("No spaces: " + className.replace(" ", ""));

		// Is there a z in my string?
		System.out.println("Is there a z in className? " + className.contains("z") );
		int zPos = className.indexOf('z');
		if (zPos < 0) {
			System.out.println("There is no z in className.");
		} else {
			System.out.println("There is a z in className at position " + zPos);
		}

		int rPos = className.indexOf('r');
		if (rPos < 0) {
			System.out.println("There is no r in className.");
		} else {
			System.out.println("There is a r in className at position " + rPos);
		}

		// Equality - Don't use == with objects, use .equals()

		// new makes a new object on the Heap
		// == with objects asks if they are the same exact object on the heap
		// do the references (remote controls) point to the same object
		if (className == new String("Java Green") ) {
			System.out.println("They are the same string.");
		} else {
			System.out.println("They are not the same string.");
		}

		// For objects .equals() will use custom defined rules for equality
		// this is defined in the class used to create the objects (will look more later)
		// For right now, just remember ALWAYS use .equals with reference types AKA objects
		if (className.equals(new String("Java Green") ) ) {
			System.out.println("They are equivalent strings.");
		} else {
			System.out.println("They are not equivalent strings.");
		}
	}

	public boolean isPalindrome(String input) {
		// Assume it is until proven otherwise
		boolean result = true;

		int backPos = input.length() - 1;
		int frontPos = 0;
		while( frontPos < backPos)  {
			System.out.println(input);
			System.out.println(frontPos +", "  + backPos);
			char front = input.charAt(frontPos);
			char back = input.charAt(backPos);

			if (front != back) {
				result = false;
				break;
			}
			backPos--;
			frontPos++;
		}
		return result;
	}
	
}
