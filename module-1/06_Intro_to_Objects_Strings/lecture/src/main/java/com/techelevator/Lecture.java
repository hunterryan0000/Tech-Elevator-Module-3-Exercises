package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		// Strings are objects! Woot!
		System.out.println("Woot! Today we're working with String objects!");

		String className = "Java Purple";
		String[] students = {"Kris", "Brian", "Elizabeth"};
		int classSize = students.length;


		System.out.println("Classname is: " + className+ ". It's length is " +
				+ className.length() + " characters.");

		// Get part of a string

		System.out.println("First part is: " + className.substring(0, 4));
		System.out.println("Last part is: " + className.substring(1, className.length() - 1));

		// Replace, get rid of spaces
		System.out.println("No Spaces: " + className.replace(" ", ""));

		// Is there a z in my string?
		System.out.println("Is there a z in the class name? " + className.contains("z"));
		int zPos = className.indexOf('z');
		if (zPos < 0) {
			System.out.println("There is no z in the className.");

		} else {
			System.out.println("There is a z in the class name at position " + zPos);
		}

		// Equality - Don't use == with objects, use .equals()

		// new makes a new object on the Heap
		// == with objects asks if they are the same on the Heap
		// do the references (remote controls) point to the same object
		if (className == new String ("Java Green")) {
			System.out.println("They are the same string.");
		} else {
			System.out.println("They are not the same string.");
		}

		// FOr objects, .equals() will use custom defined rules for equality
		if (className.equals(new String ("Java Green"))) {
			System.out.println("They are equivalent strings.");
		} else{
			System.out.println("They are not equivalent strings.");
		}

	}

	public boolean isPalindrome(String input) {
		//Assume true until proven otherwise
		boolean result = true;


		int backPos = input.length() -1;
		int frontPos = 0;
		while (frontPos < backPos) {


			char front = input.charAt(frontPos);
			char back = input.charAt(backPos);

			if (front != back) {
				return false;
			}
			backPos--;
			frontPos++;
		}
		return result;
	}
	
}
