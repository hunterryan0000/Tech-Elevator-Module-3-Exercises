package com.techelevator.purple;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {

        // Could test here in main, but unit tests allow you to know quickly if it is
        // correct or incorrect, by seeing a summary of how many tests pass fail.
        // If you test here in main, you need to manually do that verification
        Balloon basicBalloon = new Balloon("Red Balloon", false);
        System.out.println("Single basic balloon price check should be 2.99 "
                + basicBalloon.getPrice());

    }
}
