package com.techelevator.farm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		// Old MacDonald want the song to play first everytime this program starts
		// (He's so cute!)
		List<Singable> singableList = new ArrayList<>();
		singableList.add(new Cow());
		singableList.add(new Chicken());
		singableList.add(new Tractor());
		singableList.add(new Pig());

		singSong(singableList);

		// Then we can get down to business and deal with the money & stuff
		List<Sellable> itemsToSell = new ArrayList<>();
		itemsToSell.add(new Egg());
		itemsToSell.add(new Pig());
		itemsToSell.add(new Egg());

		// Let's see how much money they make today...

		// Don't use double for money amounts use BigDecimal.
		BigDecimal totalSales = new BigDecimal("0");
		for ( Sellable item : itemsToSell) {
			totalSales = totalSales.add(item.getPrice());
		}
		System.out.println("Items to sell today total: " + totalSales.toPlainString());

		// Just some notes, no need to run this now, but
		// wanted to keep for your reference later...
		//notes();
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

	private static void singSong(List<Singable> singableList) {
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
}
