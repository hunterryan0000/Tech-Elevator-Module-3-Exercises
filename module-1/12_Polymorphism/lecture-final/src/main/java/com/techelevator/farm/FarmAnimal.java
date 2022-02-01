package com.techelevator.farm;

// Adding in the Singable interface - FarmAnimals have the required getName() & getSound() methods
public class FarmAnimal implements Singable {

	// Remember to keep your object properties private
	// This is the "state" of your object, and you want to
	// control visibility and how that state is changed
	private String name;
	private String sound;

	// Constructor - what allows you to create an instance of a FarmAnimal
	// The only way we can set the name and sound is here when we first make
	// an object or instance.
	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	// Getter methods only, no setter methods
	// We can't change this stuff after it is made, so this class is immutable

	public String getName() {
		return name;
	}

	public String getSound() {
		return sound;
	}

}
