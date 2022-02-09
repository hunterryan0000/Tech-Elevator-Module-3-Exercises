package com.techelevator.purple.products;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ChocolatesTest {

    @Test
    public void getPrice_BoxOneChocolate(){
        Chocolates box = new Chocolates(1);
        Assert.assertEquals("Box of 1 chocolate",
                new BigDecimal("5.98"), box.getPrice());
    }

    @Test
    public void getPrice_BoxThreeChocolates(){
        Chocolates box = new Chocolates(3);
        Assert.assertEquals("Box of 3 chocolates",
                new BigDecimal("9.96"), box.getPrice());
    }
}
