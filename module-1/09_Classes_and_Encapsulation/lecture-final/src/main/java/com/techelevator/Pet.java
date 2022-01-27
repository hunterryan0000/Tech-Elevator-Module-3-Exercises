package com.techelevator;

public class Pet {

    // Encapsulation - make properties private
    // controls how they are accessed and potentially changed
    private String name;
    // TODO - Consider tracking DoB in version 2.0
    private int age;
    private String type;
    private String breed;
    private String color;
    private double weight;
    // TODO - Consider owner instead, null if not adopted
    private boolean isAdopted;
    private String sex;
    private String notes;

    // If we don't code a constructor, Java adds a default constructor for us
    // it looks like this:
//    public Pet(){
//        super(); // will call a parent constructor, here that parent is Object
//        // it doesn't initialize any of the Pet properties
//    }

    // When we add our own constructor, Java no longer adds a default constructor too
    public Pet(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // We can't add another constructor (overloading) with the same input types (ie String)
    // as above, even though we want them to be different properties
//    public Pet(String name, String color){
//
//    }

    // We can overload constructors!
    public Pet(String name, String type, int age, String breed, String color){
        this.name = name;
        this.type = type;
        this.age = age;
        this.breed = breed;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isAdopted() {
        return isAdopted;
    }

    public void setAdopted(boolean adopted) {
        isAdopted = adopted;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
