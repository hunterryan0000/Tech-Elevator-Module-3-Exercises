package com.techelevator.purple;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BalloonTest {

    @Test
    public void get_price_basic_balloon() {
        Balloon basicBalloon = new Balloon("Red Balloon", false);
        Assert.assertEquals("Single basic balloon price",
                new BigDecimal("2.99"), basicBalloon.getPrice());

    }

    @Test
    public void get_price_deluxe_balloon() {
        Balloon deluxeBalloon = new Balloon("Kitty Balloon", true);
        Assert.assertEquals("Single kitty balloon price",
                new BigDecimal("5.99"), deluxeBalloon.getPrice());
    }

}
