package com.techelevator;

import java.util.List;

public class Shelter {
    private String name;
    private String phone;
    private String address;
    private List<Pet> petList;
    //TODO - add the people later

    public Shelter(String name) {
        this.name = name;
        //make a new list that we can add to later if need to
        <
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
    //Will Often see a getter like this return a copy in Array
    public Pet[] getPets() {
        return petList.toArray(new Pet[0]);
    }


    //Be careful about setting your data as a reference that you take in,
    //they may still have a remote control to change it
    //Again making a copy to store can help, addElement method instead of setList
//    public void setPetList(List<Pet> petList) {
//        this.petList = petList;
//    }
    public void addPetLsit
}
