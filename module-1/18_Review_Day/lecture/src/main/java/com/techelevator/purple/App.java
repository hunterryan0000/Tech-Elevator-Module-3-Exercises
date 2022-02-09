package com.techelevator.purple;

import com.techelevator.purple.products.Balloon;

public class App {

    public static void main(String[] args) {
        // Create an instance of the class and run it
        App app = new App();
        app.run();
    }

    public void run() {
        FlowerShop flowerShop = new FlowerShop("Purple Flowers");
        displayWelcomeMessage(flowerShop);

        // TODO - Add main menu to enter an order
    }

    public void displayWelcomeMessage(FlowerShop shop){
        System.out.println("*************************************************************");
        System.out.printf("Welcome to the %s flower shop application.\n", shop.getName());
        System.out.println("*************************************************************");
        System.out.println("");
    }
}
