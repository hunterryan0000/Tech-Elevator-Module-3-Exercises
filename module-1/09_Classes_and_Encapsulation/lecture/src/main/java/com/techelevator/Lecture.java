package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleFunction;

public class Lecture {
    public static void main(String[] args) {

        System.out.println("Woot!");

//        //Create some Pet Objects or instances of Pet
//        //For default Constructor
//        Pet pet1 = new Pet();
//        pet1.setName("Fluffy");
//        pet1.setType("dog");
//
//        System.out.format("We have a pet %s that is a %s\n", pet1.getName(), pet1.getType());


        Pet pet2 = new Pet ("Fluffy", "dog");
        pet2.setAdopted(true);
        System.out.format("We have a pet %s that is a %s\n", pet2.getName(), pet2.getType());

        Pet Bruno = new Pet("Bruno", "cat", 3, "Tabby", "brown");
        System.out.format("We have a pet %s that is a %s bred %s\n",
                Bruno.getName(), Bruno.getType(), Bruno.getBreed());

        Shelter Green = new Shelter("Green Shelter");
        System.out.format("The shelter is called %s!\n", Green.getName());

        List<Pet> ourPets = new ArrayList<>();
        ourPets.add(pet2);
        ourPets.add(Bruno);

    }
}
