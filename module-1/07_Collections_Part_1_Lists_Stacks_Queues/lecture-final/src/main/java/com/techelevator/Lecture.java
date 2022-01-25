package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Lecture {

	public static void main(String[] args) {

		String name = "Mary";
		int index = name.indexOf("z");
		System.out.println("Pos of z in name is:" + index);

		// value is not "set" to a meaningful value
		// It is set to null generally because we don't know what
		//   it should be yet. It will be changed later when we get
		//   that information (ie maybe by having the user enter it.)
		String homeTown = null;
		// int age = null; // Cannot use null for a primitive type


		// ArrayLists - Collection class, specifically a List
		// When using ArrayList, you should *always* use List as the variable type
		// This is an example of programming to an interface (more at the bottom)
		List<String> catsList = new ArrayList<>();

		// Add puts things at the end
		catsList.add("Commander Wisdom");
		catsList.add("Fred");
		//catsList.add("Kyo");
		catsList.add("Abby");

		// Unless you tell it otherwise
		catsList.add(2,"Kyo");

		// Can we just output the whole arraylist
		System.out.format("Our cats are: %s\n", catsList);

		// How many cats?
		System.out.println("We have " + catsList.size() + " cats!");

		// Cool formatted strings - can do instead of concatenation
		System.out.format("We have %s cats!\n", catsList.size());

		// Use get to "get" the item/element WITHOUT removing it
		String cat0 = catsList.get(0);
		System.out.printf("First cat is %s and last is %s.\n",
				cat0, catsList.get(catsList.size()-1));

		// Remove something
		// Remove by index can get the thing returned back
		String abby = catsList.remove(3);

		//Remove by value, we get a true/false indicating it was removed
		boolean foundAbby = catsList.remove("Abby");
		boolean foundFred = catsList.remove("Fred");

		System.out.printf("Removed Abby and got %s\n", abby);
		System.out.printf("Did we find Abby now? %b\n", foundAbby);
		System.out.printf("Did we find Fred? %b\n", foundFred);

		// Contrast w/ and array
		String[] dogs = new String[5];
		dogs[0] = "Professor Trouble";
		dogs[1] = "Loki";
		dogs[2] = "Skadi";

		String loki = dogs[1];
		dogs[1] = null;

		System.out.println("Loop over dogs array with for-i");
		// for loop or for-i
		// Use this is you need to know the index/position of items
		for (int i = 0; i < dogs.length; i++) {
			System.out.println("Array item " + dogs[i]);
		}

		// A for loop does NOT have to use an array
		// Maybe I just wanna do something x number of times
		int numberOfWoots = 3;
		for (int i = 0; i < numberOfWoots; i++) {
			System.out.println("Woot!");
		}

		// Just used to do something a given number of times
		// OFTEN this is to go over an array, but doesn't need to be


		System.out.println();
		System.out.println("Loop over dogs array with for-each");
		// for-each
		// This is shorter to write, so use if you don't care about index
		// Great for reading out of the array, but not updating it
		// This loop (unlike for-i) must use an "iterable" or an array/collection
		for (String foo : dogs) {
			System.out.println("Array item " + foo);
		}

		int[] numbers = { 1, 3, 4, 6};
		for (int num : numbers) {
			// can do things to the items BUT
			// can't update the item in the array
			System.out.println("Item * 2: " + (num * 2) );
		}

		// Programming to the interface...

		// Stack class has special methods...
		// If I declare the variable as a Stack I can use those
		// This IS NOT programming to an interface!
		Stack<String> stringStack = new Stack<>();
		stringStack.push("Item 1");
		stringStack.push("Item 2");
		stringStack.push("Item 3");
		stringStack.push("Item 4");
		stringStack.add("Item 5 using add");
		System.out.format("My stack has: %s\n", stringStack);

		stringStack.pop();
		System.out.format("My stack has: %s\n", stringStack);

		// Programming to an interface would mean using the Interface on the left
		// This allows you to change the "implementing class" the one on the right
		List<String> stringList = new Stack<>();
		// Can't use Stack methods like push/pop
		//stringList.push("Item 1"); // push is not on List Interface

		// Must use List methods
		stringList.add("Item 1");
	}
}
