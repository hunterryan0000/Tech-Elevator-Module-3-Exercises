package com.techelevator;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		// Instance methods, need a specific or instance
		// of the class to call these methods.
		String name = "Ryan";
		int indexOfR = name.indexOf("y");


		// Add array of values to a collection!
		Integer[] numbers = {23, 47, 89, 38, 23, 8, 89};
		String[] food = {"apples", "yogurt", "pizza", "ice-cream",
				"Pizza", "yogurt"};


		//Both Arrays & collections classes have static helper methods
		// you call them on the class itself not an instance.

		//Arrays.asList is great to convert an array to a List,
		// Can't add, nor remove
		List<Integer> numberList = Arrays.asList(numbers);
		//numberList.add(26);
		//numberList.remove(0);
		System.out.println("These are the numbers: " + numberList);

		//Collections.addAll lets us be more specific about the type
		//of collection we want to put the values into
		List<Integer> numberArrayList = new ArrayList<>();
		Collections.addAll(numberArrayList, numbers);

		// now I should have all numbers in numberArrayList
		// AND NOW I can add/remove
		numberArrayList.add(26);
		numberArrayList.remove(0); // removes first item (23)
		System.out.println("Number Array List is: " + numberArrayList);

		// What if I put it into a Set instead? (random order)
		Set<Integer> numberHashSet = new HashSet<>();
		Collections.addAll(numberHashSet, numbers);
		System.out.println("Number Hash Set is: " + numberHashSet);

		//Tree sets to natural order (chronological)
		Set<Integer> numberTreeSet = new TreeSet<>();
		Collections.addAll(numberTreeSet, numbers);
		System.out.println("Numer Tree Set List: " + numberTreeSet);

		// Let's do the same thing with a String Array
		// Note capitalization matters both for pulling dups and sorting
		Set<String> foodSet = new TreeSet<>();
		Collections.addAll(foodSet, food);
		System.out.println("Food Set is: " + foodSet);

		// Maps! Woot!
		//-----------------------------------------------------------

		Map<String, Boolean> starWars = new HashMap<>();
		starWars.put("Luke", true);
		starWars.put("Yoda", true);
		starWars.put("Leia", true);
		System.out.println("Star Wars Map: " + starWars);

		//Remove based on just key
		System.out.println("Remove Yoda by key....");
		starWars.remove("Yoda");
		System.out.println("Star Wars Map: " + starWars);

		//Tighter remove? Use key and value
		System.out.println("Remove Luke if jediStatus (value) is false...");
		starWars.remove("Luke", false);
		System.out.println("Star Wars Map: " + starWars);

		System.out.println("Remove Luke if jediStatus (value) is true...");
		starWars.remove("Luke", true);
		System.out.println("Star Wars Map: " + starWars);

		// Can we have dups? Only of values, not keys
		System.out.println("Adding Luke with status of false...");
		starWars.put("Luke", false);
		System.out.println("Star Wars Map: " + starWars);
		System.out.println("Adding Luke with status of true...");
		starWars.put("Luke", true);
		System.out.println("Star Wars Map: " + starWars);
		//Note that adding the same key again just updates the value

		//Review: for-each over a list
		for (String foodItem : food) {
			System.out.println("The food is: " + foodItem);
		}

		//Loop over the map and print the people and status
		starWars.put("R2D2", false);
		starWars.put("Han", false);
		starWars.put("Yoda", true);
		starWars.put("C3p0", false);
		System.out.println("Printing out Star Wars people using entry set:");
		for (Map.Entry<String, Boolean> entry : starWars.entrySet()) {
			System.out.format("%s has a jedi status of %b. \n",
					entry.getKey(), entry.getValue());
		}



		// Let's say I only care about peopleNOT jedi
		//Remove everyone else -- NOT ALLOWED can't modify in for each
//		for (Map.Entry<String, Boolean> entry :starWars.entrySet()) {
//			starWars.remove(entry.getKey(), true); }
		Map<String, Boolean> nonJedi = new HashMap<>();

		//Let's do that the "right way"
		// Generally a better practice to instead create a new collection
		// of only things we want to keep
		List<String> nonJediNames = new ArrayList<>();
		for (Map.Entry<String, Boolean> entry : starWars.entrySet()) {
				if (entry.getValue() == false) {
					nonJedi.put(entry.getKey(), entry.getValue());
					nonJediNames.add(entry.getKey());
				}
		}
		System.out.println("Non jedi: " + nonJedi);
		System.out.println("Non jedi Names: " + nonJediNames);
		System.out.println("All Star Wars: " + starWars);


		// given an array of Strings. Tell me how many strings start with each letter.
		// [pizza, puddle, apple, cat, dog, aria] -> p=2 a=2 c=1 d=1

		String[] stuff = {"pizza", "puddle", "apple", "cat", "dog", "aria"};

		//Could just make an int count for each letter of the alphabet...
//		int countA, countB, countC = 0; plus more for the rest of the letters

//		The map lets use only create these counts as we need them...

		// Let's use a TreeMap so they come out in alphabetical order!
		Map<String, Integer> letterCount = new TreeMap<>();

		for (String item : stuff) {
			String firstLetter = "" + item.charAt(0);
			if (letterCount.get(firstLetter) == null) {
				// Note key is a string, so make a string from char firstLetter
				letterCount.put(firstLetter, 1);
			} else {
				int currentValue = letterCount.get(firstLetter);
				letterCount.put(firstLetter, currentValue+1);
			}
		}
		System.out.println("Stuff is: " + Arrays.asList(stuff));
		System.out.println("Results are: " + letterCount);

	}

}

