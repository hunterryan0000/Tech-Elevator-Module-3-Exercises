package com.techelevator.purple;

import com.techelevator.purple.order.Order;
import com.techelevator.purple.products.Balloon;
import com.techelevator.purple.products.Bouquet;

import java.util.Scanner;

public class App {
    private static final double TAX_MULTIPLIER = 0.10;

    private Scanner userInput;
    private FlowerShop flowerShop;

    public App() {
        this.userInput = new Scanner(System.in);
        flowerShop = new FlowerShop("Purple Flowers");
    }

    public static void main(String[] args) {
        // Create an instance of the class and run it
        App app = new App();
        app.run();
    }

    public void run() {
        displayWelcomeMessage(flowerShop);

        // Testing our sales report... Make an order & write it out... 2 items, total cost $28.57
        Balloon basicBalloon = new Balloon("Purple", false);
        Bouquet bouquetExtraRose = new Bouquet("Sunshine", 1);
        Order newOrder = new Order(0.10);
        newOrder.addProduct(bouquetExtraRose);
        newOrder.addProduct(basicBalloon);

        flowerShop.addOrder(newOrder);

        // TODO - Add main menu to enter an order

        boolean continueRunning = true;
        while (continueRunning) {
            displayMainMenu();
            System.out.println("Please enter an option: ");
            // strip will remove leading/trailing whitespace
            String userChoice = userInput.nextLine().strip();

            if (userChoice.equals("1")) {
                addNewOrder();
            } else if (userChoice.equals("2")) {
                displayAllOrders();
            } else if (userChoice.equalsIgnoreCase("Q")) {
                // stop the loop
                continueRunning = false;
            } else {
                System.out.println("That's not a valid option. Please try again.");
            }
        }

        this.userInput.close();
    }

    public void displayWelcomeMessage(FlowerShop shop){
        System.out.println("*************************************************************");
        System.out.printf("Welcome to the %s flower shop application.\n", shop.getName());
        System.out.println("*************************************************************");
        System.out.println("");
    }

    public void displayMainMenu(){
        System.out.println();
        System.out.println("Main menu:");
        System.out.println("1 - Add new order");
        System.out.println("2 - View all orders");
        System.out.println("Q - Quit");
        // TODO - add more options later...
    }

    public void addNewOrder(){
        System.out.println("Creating the new order...");
        // Make a new order object...
        Order newOrder = new Order(TAX_MULTIPLIER);
        System.out.println("Enter the customer's first name: ");
        String firstName = userInput.nextLine();
        System.out.println("Enter the customer's last name: ");
        String lastName = userInput.nextLine();
        System.out.println("Enter the customer's phone number: ");
        String phone = userInput.nextLine();
        Customer newCustomer = new Customer(firstName, lastName, phone);
        newOrder.setCustomer(newCustomer);

        // ToDo - finish collecting info for the order...

        System.out.println("Adding the new order.");
        flowerShop.addOrder(newOrder);
    }

    public void displayAllOrders(){
        System.out.println("Displaying all orders...");
    }

}
