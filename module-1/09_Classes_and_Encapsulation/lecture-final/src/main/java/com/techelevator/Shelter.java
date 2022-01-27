package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    // final makes a constant that we can't change after declaration
    // Because this is static, it also means ALL shelters have the same capacity
    public static final int MAX_CAPACITY = 10;

    private String name;
    private String phone;
    private String address;
    private List<Pet> petList;
    //TODO - add the people later

    // Constructor with name set initially
    public Shelter(String name){
        this.name = name;
        // make a new list that we can add pets into later on
        this.petList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // If we want to make sure that the name can't change later
    // (from outside of the class) we can NOT provide a setter.
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Be careful giving back a direct reference to your data
    // Often will see a getter like this return a copy in an array
    public Pet[] getPets() {
        return petList.toArray(new Pet[0]);
    }

    // Be careful about setting your data as a refernce that you take in,
    // they may still have a remote control to change it
    // Again making a copy to store can help, addElement method instead of setList
//    public void setPetList(List<Pet> petList) {
//        this.petList = petList;
//    }
    public void addPet(Pet newPet){
        this.petList.add(newPet);
    }
}
