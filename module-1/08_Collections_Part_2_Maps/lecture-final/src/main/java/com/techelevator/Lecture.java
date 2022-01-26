package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		// Instance methods,
		// need a specific object or instance of the class to call these methods.
		String name = "Mary";
		int indexOfR = name.indexOf("r");


		// Add array of values to a collection!
		Integer[] numbers = {23, 47, 89, 38, 23, 8, 89};
		String[] foods = {"apples", "yogurt", "pizza", "ice-cream",
				"Pizza", "yogurt"};

		// Both Arrays & Collections classes have static helper methods
		// you call them on the class itself not an instance.

		// Arrays.asList is great to convert an array to a List,
		// Opps apparently we can't add/remove
		List<Integer> numberList = Arrays.asList(numbers);
		//numberList.add(42);
		//numberList.remove(0);
		System.out.println("List is: " + numberList);

		// Collections.addAll let's us be more specific about the type of
		// collection we want to put the values into
		List<Integer> numberArrayList = new ArrayList<>();
		Collections.addAll( numberArrayList, numbers);

		// now I should have all the numbers in numberArrayList
		// AND I can add/remove
		numberArrayList.add(42);
		numberArrayList.remove(0); // remove first item
		System.out.println("Number Array List is " + numberArrayList);

		// What if I put it into a Set instead... use HashSet
		Set<Integer> numberHashSet = new HashSet<>();
		Collections.addAll(numberHashSet, numbers);
		System.out.println("Number Hash Set is " + numberHashSet);

		// What if I put it into a Set instead... use TreeSet (which is ordered!)
		Set<Integer> numberTreeSet = new TreeSet<>();
		Collections.addAll(numberTreeSet, numbers);
		System.out.println("Number Tree Set is " + numberTreeSet);

		// Let's do the same thing w/ our string array
		// Note capitalization matters both for pulling dups and sorting
		Set<String> foodSet = new TreeSet<>();
		Collections.addAll(foodSet, foods);
		System.out.println("Food Set is " + foodSet);

		// Maps! Woot!
		// ----------------------------------------------

		Map<String, Boolean> starWarsPeople = new HashMap<>();
		starWarsPeople.put("Luke", true);
		starWarsPeople.put("Yoda", true);
		starWarsPeople.put("Leia", true);
		System.out.println("Star Wars Map: " + starWarsPeople);

		// Remove based on just the key
		System.out.println("Remove Yoda by key...");
		starWarsPeople.remove("Yoda");
		System.out.println("Star Wars Map: " + starWarsPeople);

		// Tighter remove? Use key and value
		System.out.println("Remove Luke if jediStatus (value) is false...");
		starWarsPeople.remove("Luke", false);
		System.out.println("Star Wars Map: " + starWarsPeople);

		System.out.println("Remove Luke if jediStatus (value) is true...");
		starWarsPeople.remove("Luke", true);
		System.out.println("Star Wars Map: " + starWarsPeople);

		// Can we have dups? Only of values, not keys
		System.out.println("Adding Luke with status of false...");
		starWarsPeople.put("Luke", false);
		System.out.println("Star Wars Map: " + starWarsPeople);
		System.out.println("Adding Luke AGAIN with status of true...");
		starWarsPeople.put("Luke", true);
		System.out.println("Star Wars Map: " + starWarsPeople);
		// Note that adding the same key again just updates the value

		// Review - for-each over a array (also works similar w/ List)
		System.out.println("Printing out foods with for-each:");
		for (String foodItem : foods){
			System.out.println("The food is " + foodItem);
		}

		// Loop over the map and print the people and status
		starWarsPeople.put("R2D2", false);
		starWarsPeople.put("Han", false);
		starWarsPeople.put("Yoda", true);
		starWarsPeople.put("C3P0", false);
		System.out.println("Printing out Star wars people using entry set:");
		for(Map.Entry<String, Boolean> entry : starWarsPeople.entrySet()){
			System.out.format("%s has a jedi status of %b.\n",
					entry.getKey(), entry.getValue());
		}

		System.out.println("Only care about non jedi... I want a Map of only those people.");
		// Let's say I only care about people who are NOT jedi...
		// Remove everyone else - THIS IS NOT ALLOWED can't modify in for-each
//		for(Map.Entry<String, Boolean> entry : starWarsPeople.entrySet()){
//			// Remove based on key ONLY IF status is true
//			starWarsPeople.remove(entry.getKey(), true);
//		}
//		System.out.println("Star Wars Map only non-Jedi: " + starWarsPeople);

		// Let's do that the "right" way
		// Generally a better practice to instead create a new collection
		// of only the things to keep - flip your thinking on this
		Map<String, Boolean> nonJediPeople = new HashMap<>();

		//If only care about the names of non-Jedi, could use a List...
		List<String> nonJediNamesOnly = new ArrayList<>();
		for(Map.Entry<String, Boolean> entry : starWarsPeople.entrySet()){
			if(entry.getValue() == false){
				nonJediPeople.put(entry.getKey(), entry.getValue());
				nonJediNamesOnly.add(entry.getKey());
				System.out.println(entry.getKey() + " is not a Jedi.");
			}
		}
		System.out.println("Non-Jedi People Map:" + nonJediPeople);
		System.out.println("Non-Jedi names only: " + nonJediNamesOnly);
		System.out.println("All Star Wars People" + starWarsPeople);

		// Given an array of Strings. Tell me how many strings start with each letter.
		// [pizza, puddle, apple, cat, dog, aria] -> p=2, a=2, c=1, d=1

		String[] stuff = {"pizza", "puddle", "apple", "cat", "dog", "aria"};

		// Could just make an int count for each letter of the alphabet...
		//int countA, countB, countC = 0; // plus more for the rest of the letters

		// The Map lets use only create these counts as we need them...
		// Let's use a TreeMap so they come out in alphabetical order!
		Map<String, Integer> letterMap = new TreeMap<>();

		for (String item : stuff) {
			// Note key is a string, so make a string from char firstLetter
			String firstLetter = "" + item.charAt(0);
			if (letterMap.get(firstLetter) == null){
				// This is first time we get this letter, add it with value 1
				letterMap.put(firstLetter, 1);
			} else {
				// This is not the first time, so let's add 1 to the current value
				// Because the key is already in the Map, put updates the value, doesn't add another key
				int currentValue = letterMap.get(firstLetter);
				letterMap.put(firstLetter, currentValue+1);
			}
		}
		System.out.println("Stuff is: " + Arrays.asList(stuff));
		System.out.println("Results are:" + letterMap);
	}

}
