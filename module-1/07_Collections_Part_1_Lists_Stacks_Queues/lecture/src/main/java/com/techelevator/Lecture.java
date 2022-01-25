package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {

		String name = "Ryan";
		//int i = name.indexOf("z");
		//System.out.println("Pos of z in name is: " + i);

		// value is not "set" to a meaningful value
		// It is set to null generally because we don't know what
		// it should be yet. It will be changed later when we
		// get that info (maybe by having the user enter it)
		// can have at most 1 null
		String homeTown = null;

		// 'int age = null;' // Cannot use null for a primitive type


		//ArrayLists - Collection class, specifically a List

		List<String> catsLists = new ArrayList<>();
		catsLists.add("Commander Wisdom");
		catsLists.add("Fred");
		catsLists.add("Kyo");
		catsLists.add("Abby");

		System.out.printf("Cat names are: %s", catsLists);

		//How many cats?

		System.out.println("\nWe have " + catsLists.size() + " cats!");

		//cool formatted strings - can do instead of concatenation
		System.out.format("We have %s cats!", catsLists.size());

		System.out.printf("\nFirst cat is %s and the last is %s",
				catsLists.get(0), catsLists.get(catsLists.size() - 1));

		// remove something
		String abby = catsLists.remove(3);
		boolean foundAbby = catsLists.remove("Abby");
		boolean foundFred = catsLists.remove("Fred");

		System.out.printf("\nRemoved Abby and got %s", abby);
		System.out.printf("\nDid we find abby now? %b", foundAbby); // not in list so got false
		System.out.printf("\nDid we find fred? %b", foundFred);

		// contrast w/ an array
		String[] dogs = new String[5];
		dogs[0] = "Professor Trouble";
		dogs[1] = "Loki";
		dogs[2] = "Skadi";

		String Loki = dogs[1];
		dogs[1] = null;
		System.out.println();

		System.out.println("\nLoop over dogs array with for-i");
		// for loop or for-i
		//Use this if you need to know the index/position of items
		for (int i = 0; i < dogs.length; i++) {
			System.out.println("Array item " + dogs[i]);
		}
		System.out.println();
		System.out.println("Loop over dogs array with for-each");
		//for-each
		// this is short to write, so use if you don't care about index
		//Great for reading the array, but not for updating it
		for (String foo :  dogs) {
			System.out.println("Array item " + foo);
		}

		int[] numbers = {1, 3 ,4 , 6};
		for (int num : numbers) {
			System.out.print((num * 2) + " ");
		}

			//Programming has to interface
			// Stack class has special methods...
			Stack<String> stringStack = new Stack<>();
			stringStack.push("Item 1");
			stringStack.push("Item 2");
			stringStack.push("Item 3");
			stringStack.push("Item 4");
			stringStack.add("Item 5 using add");
			System.out.format("\nMy stack has: %s", stringStack);

			stringStack.pop();
			System.out.format("\nMy stack has: %s", stringStack);


			//Programmming to an interface would b=mean using gthe interface on the left
			//this allows you to change the 'implementing class', the one on the right
			Stack<String> stringStack = new Stack<>();
			// can

		}

	}

