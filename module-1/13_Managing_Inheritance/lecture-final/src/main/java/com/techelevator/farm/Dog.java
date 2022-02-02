package com.techelevator.farm;

public class Dog extends FarmAnimal {

    // Constructors are not inherited
    // Child class constructors can have different inputs from the parent
    // They MUST call a super/parent class constructor (if the parent class has a
    //   no argument constructor, this may be done for you by "magic")
    public Dog(String sound){
        super("Dog", sound);
    }

    // Overloaded Dog constructor
    public Dog() {
        super("Dog", "Woof");
        System.out.println("in Dog no arg constructor");
    }

    @Override
    public boolean eat() {
        return true;
    }

    // getSound is final in FarmAnimal, so we can't override it in Dog (or any other child class)
//    @Override
//    public String getSound() {
//        return "hahahahahhaha";
//    }
}
