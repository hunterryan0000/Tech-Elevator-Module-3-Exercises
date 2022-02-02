package com.techelevator.farm;

import java.math.BigDecimal;

public class Pig extends FarmAnimal implements Sellable {
    // I inherit properties for name & sound, so I should NOT recreate them here!
    // private String name;

    // This is a new property not needed for ALL FarmAnimals.
    // But it is needed to be Sellable. (Not all FarmAnimals are Sellable, but Pigs are.)
    private BigDecimal price;

    public Pig() {
        super("Pig", "oink");
        this.price = new BigDecimal("300.00");
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public boolean eat() {
        System.out.println("The pig is eating...");
        return true;
    }
}
