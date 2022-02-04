package com.techelevator.purple;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderTest {

    @Test
    public void getTotalPrice_OneBasicBalloon_TenPercentTax() {
        Balloon basicBalloon = new Balloon("Purple", false);
        Order newOrder = new Order(0.10);
        newOrder.addProduct(basicBalloon);

        // Basic Balloon is 2.99, tax amount 0.30, total cost 3.29

        // Changed from BigDecimal return to formatted currency string
//        Assert.assertEquals("Price check on basic balloon w/ 10% tax",
//                new BigDecimal("3.29"), newOrder.getTotalPrice());

        Assert.assertEquals("Price check on basic balloon w/ 10% tax",
                "$3.29", newOrder.getTotalPrice());
    }
}
