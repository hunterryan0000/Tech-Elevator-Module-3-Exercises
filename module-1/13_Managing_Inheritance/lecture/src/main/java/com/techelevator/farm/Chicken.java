package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	// This is inheriting all the properties and methods of the FarmAnimal...
	public Chicken() {
		super("Chicken", "cluck!");
	}

	// BUT our Chickens can also lay eggs.
	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

}
