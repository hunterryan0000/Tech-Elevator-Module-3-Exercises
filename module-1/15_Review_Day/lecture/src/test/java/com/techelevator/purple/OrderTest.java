package com.techelevator.purple;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderTest {
    @Test

    public void get_total_price_one_basic_balloon_tenpercent_tax(){
        Balloon basicBalloon = new Balloon("Purple", false);
        Order newOrder = new Order(0.10);
        newOrder.addProduct(basicBalloon);
        //basic balloon is 2.99, .299 tax, cost 3.29
        Assert.assertEquals("Price check on basic balloon with 10% tax",
                ("$3.29"), newOrder.getTotalPrice());
    }
}
