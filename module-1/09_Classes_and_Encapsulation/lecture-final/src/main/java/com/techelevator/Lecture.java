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

        //Can access public properties directly from outside the class
        // Generally this is only done for constants.
        System.out.println("Shelter capacity is " + Shelter.MAX_CAPACITY);
        // Can access from an instance/object BUT it is not a good practice so DON'T DO IT!
        System.out.println(purpleShelter.MAX_CAPACITY);

        // I can't change it by setting the property directly
        //kyo.name = "Can't do this";
        // I can change the private name through the setter
        kyo.setName("Kyo is Awesome");

        // The ShelterApp constructor is private, I SHOULD NOT do this.
        // (It won't compile unless you change the access modifier.)
        //ShelterApp test = new ShelterApp();
    }
}
