package com.techelevator.purple.products;

import com.techelevator.purple.products.Bouquet;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BouquetTest {

    @Test
    public void getPrice_BouquetNoExtraRose(){
        Bouquet bouquet = new Bouquet("Basic Bouquet", 0);
        Assert.assertEquals("Single bouquet no extra roses",
                new BigDecimal("19.99"), bouquet.getPrice());
    }

    @Test
    public void getPrice_BouquetOneExtraRose(){
        Bouquet bouquet = new Bouquet("Extra Rose Bouquet", 1);
        Assert.assertEquals("Single bouquet 1 extra rose",
                new BigDecimal("22.98"), bouquet.getPrice());
    }

    @Test
    public void getPrice_BouquetThreeExtraRoses(){
        Bouquet bouquet = new Bouquet("Extra Rose Bouquet", 3);
        Assert.assertEquals("Single bouquet 3 extra roses",
                new BigDecimal("28.96"), bouquet.getPrice());
    }
}
