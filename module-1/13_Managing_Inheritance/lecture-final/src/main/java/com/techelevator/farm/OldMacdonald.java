package com.techelevator.farm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {

	/**
	 * This starts running the Old MacDonald farm application.
	 * @param args no args are expected
	 */
	public static void main(String[] args) {

		// Make an instance of our OldMacdonald application class, so we don't have
		//  to only have static methods.
		OldMacdonald app = new OldMacdonald();

		// Old MacDonald want the song to play first everytime this program starts
		// (He's so cute!)
		//List<Singable> singableList = getSingables();
		//singSong(singableList);
		app.singSong();

		// Then we can get down to business and deal with the money & stuff
		// Let's see how much money they make today...
		List<Sellable> itemsToSell = getItemsToSell();
		BigDecimal totalSales = getTotalSales(itemsToSell);
		System.out.println("Items to sell today total: " + totalSales.toPlainString());

		// Just some notes, no need to run this now, but
		// wanted to keep for your reference later...
		//notes();

		// I should NOT be able to make a FarmAnimal...
		// I should only be able to make Cows & Chickens & Pigs, etc
		// By making FarmAnimal abstract we can't create instances of it
		//FarmAnimal whatAmI = new FarmAnimal("??", "??");

		// However we can still make instances of classes that extend the abstract class.

		// Make a LittleDog
		LittleDog fluffy = new LittleDog();

	}

	private static BigDecimal getTotalSales(List<Sellable> itemsToSell) {
		BigDecimal totalSales = new BigDecimal("0");
		for ( Sellable item : itemsToSell) {
			totalSales = totalSales.add(item.getPrice());
		}
		return totalSales;
	}

	private static List<Sellable> getItemsToSell() {
		List<Sellable> itemsToSell = new ArrayList<>();
		itemsToSell.add(new Egg());
		itemsToSell.add(new Pig());
		itemsToSell.add(new Egg());
		return itemsToSell;
	}

	/**
	 * This will get a list with one of each type of thing Old MacDonald has on his farm.
	 * This is used to sing about all the farm stuff.
	 * @return the list of things to sing about
	 */
	private List<Singable> getSingables() {
		List<Singable> singableList = new ArrayList<>();
		singableList.add(new Cow());
		singableList.add(new Chicken());
		singableList.add(new Tractor());
		singableList.add(new Pig());
		singableList.add(new Dog());
		singableList.add(new LittleDog());
		return singableList;
	}

//	private void singSong(List<Singable> singableList) {
	private void singSong() {
		List<Singable> singableList = getSingables();
		for (Singable singable : singableList) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}
	}

	private static void notes() {
		// Just some extra stuff...
		List<FarmAnimal> farmAnimalList = new ArrayList<>();

		Cow betsy = new Cow();
		Cow josey = new Cow();
		// Name for the Cow is really it's type, works for the OldMacDonald song, but might not
		// work for other games or programs. That's OK. Code for the current purpose and features.
		System.out.format("Betsy the %s says %s.", betsy.getName(), betsy.getSound());

		// Add to farm animals
//		farmAnimalList.add(betsy);
//		farmAnimalList.add(josey);

		Chicken flower = new Chicken();
		Chicken lynn = new Chicken();
		System.out.printf("Flower the %s says %s.", flower.getName(), flower.getSound());
		System.out.printf("Flower lays an egg...");
		flower.layEgg();

		List<Chicken> myChickens = new ArrayList<>();
		myChickens.add(flower);
		myChickens.add(lynn);
		farmAnimalList.addAll(myChickens);

		// Can loop over chickens and have them lay eggs...
		for (Chicken chicken : myChickens){
			chicken.layEgg();
		}

		// Can't loop over the farm animals and have them lay eggs,
		// even if I don't add the cows to the list.
		for (FarmAnimal animal : farmAnimalList) {
			//animal.lay
		}
	}


}
