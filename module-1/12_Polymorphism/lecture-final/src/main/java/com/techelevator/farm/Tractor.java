package com.techelevator.farm;

// A class can implement as many interfaces as needed...
public class Tractor implements Singable, Maintainable {

    @Override
    public String getName() {
        return "Tractor";
    }

    @Override
    public String getSound() {
        return "vroom";
    }
}
