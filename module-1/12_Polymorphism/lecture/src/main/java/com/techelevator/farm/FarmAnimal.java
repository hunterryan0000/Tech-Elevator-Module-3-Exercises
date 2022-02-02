package com.techelevator.farm;

public class FarmAnimal {

	// Remember to keep your object properties private
	//This is the "stat" of your object, and you want to
	//control visibility and how that state is changed
	private String name;
	private String sound;


	// Constructor - what allows you to create an instance of a FarmAnimal
	//The only way we can set the name and sound is here when we first make
	//an object or instance
	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	//Getter methods only, no setter methods
	//We can't change this stuff after it is made, so this class is immutable!!!

	public String getName() {
		return name;
	}

	public String getSound() {
		return sound;
	}

}
