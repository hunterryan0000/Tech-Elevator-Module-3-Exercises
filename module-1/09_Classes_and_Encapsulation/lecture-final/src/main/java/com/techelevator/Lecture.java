package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Lecture {
    public static void main(String[] args) {
        System.out.println("Woot!");

        // Create some Pet objects or instances of Pet
        // we do this by calling a Constructor

        // If we don't have add a constructor, we can use the default & set
        // all our properties through the setter methods.
//        Pet pet1 = new Pet();
//        pet1.setName("Fluffy");
//        pet1.setType("dog");
//        System.out.format("We have a pet %s that is a %s.\n",
//                pet1.getName(), pet1.getType());


        Pet pet2 = new Pet("Fluffy", "dog");
        pet2.setColor("black and white");
        System.out.format("We have a pet %s that is a %s.\n",
                pet2.getName(), pet2.getType());

        Pet bruno = new Pet("Bruno", "cat", 3, "Tabby", "brown");
        System.out.format("We have a pet %s that is a %s.\n",
                bruno.getName(), bruno.getType());

        // This would create a pet with a type of orange! We need to know what those
        // String inputs represent
        Pet kyo = new Pet("Kyo", "orange");
        kyo.setAdopted(true);
        System.out.format("We have a pet %s that is a %s.\n",
                kyo.getName(), kyo.getType());

        // Create our shelter
        Shelter purpleShelter = new Shelter("Purple Shelter");
        //purpleShelter.setName("Green Shelter");
        System.out.printf("The shelter is called %s.\n", purpleShelter.getName());

        System.out.println("Max shelter capacity is " + Shelter.MAX_CAPACITY);

//        List<Pet> ourPets = new ArrayList<>();
//        ourPets.add(pet2);
//        ourPets.add(bruno);
//        ourPets.add(kyo);
//        purpleShelter.setPetList(ourPets);
        purpleShelter.addPet(pet2);
        purpleShelter.addPet(bruno);
        purpleShelter.addPet(kyo);

        Pet[] shelterPets = purpleShelter.getPets();
        for (Pet pet : shelterPets) {
            System.out.println(pet.getName());
        }
    }
}
