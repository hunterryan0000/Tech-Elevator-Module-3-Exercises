package com.techelevator.purple;

import com.techelevator.purple.order.Order;
import com.techelevator.purple.products.Balloon;
import com.techelevator.purple.products.Bouquet;
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
        Assert.assertEquals("Price check on basic balloon w/ 10% tax",
                new BigDecimal("3.29"), newOrder.getTotalPrice());
    }

    @Test
    public void getTotalPrice_OneBalloon_OneBouquetWithExtraRose_TenPercentTax() {
        Balloon basicBalloon = new Balloon("Purple", false);
        Bouquet bouquetExtraRose = new Bouquet("Sunshine", 1);
        Order newOrder = new Order(0.10);
        newOrder.addProduct(bouquetExtraRose);
        newOrder.addProduct(basicBalloon);

        // Basic Balloon is 2.99
        // Bouquet with extra rose is $22.98
        // tax amount 2.597, total cost $28.57
        Assert.assertEquals("Price check on basic balloon, bouquet w/ extra rose & 10% tax",
                new BigDecimal("28.57"), newOrder.getTotalPrice());
    }

    @Test
    public void constructor_initialization() {
        double tax = 0.10;
        Order newOrder = new Order(tax);

        // Order number, order date, and products should not be null
        Assert.assertNotNull(newOrder.getOrderDate());
        Assert.assertNotNull(newOrder.getOrderNumber());
        Assert.assertNotNull(newOrder.getProducts());

        // tax multiplier should be set
        Assert.assertEquals("comparing tax value", tax, newOrder.getTaxMuliplier(), 0.001);
    }
}
