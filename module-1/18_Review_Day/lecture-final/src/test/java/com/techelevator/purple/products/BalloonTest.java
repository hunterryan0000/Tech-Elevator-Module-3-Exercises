package com.techelevator.purple.products;

import com.techelevator.purple.products.Balloon;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BalloonTest {

    @Test
    public void getPrice_BasicBalloon(){
        Balloon basicBalloon = new Balloon("Red Balloon", false);
        Assert.assertEquals("Single basic balloon price check",
                new BigDecimal("2.99"), basicBalloon.getPrice());
    }

    @Test
    public void getPrice_DeluxeBalloon(){
        Balloon deluxeBalloon = new Balloon("Kitty Balloon", true);
        Assert.assertEquals("Single deluxe balloon price check",
                new BigDecimal("5.99"), deluxeBalloon.getPrice());
    }


}
