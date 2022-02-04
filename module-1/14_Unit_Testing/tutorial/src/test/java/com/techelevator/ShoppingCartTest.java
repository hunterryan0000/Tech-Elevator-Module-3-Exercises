package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ShoppingCartTest {
    @Test
    public void subtotal_should_equal_sum_of_all_items() {
        ShoppingCart shoppingCart = new ShoppingCart(.25);

        shoppingCart.add( new Book("Dynamics of Software Development", "Jim McCarthy", 10.00));
        // Taxable $20 plus $2 tax
        shoppingCart.add( new Movie("Free Guy", "PG-13", 115, 20.00));
        // Not taxable $10
        shoppingCart.add( new Coffee("Jumbo", "Bold", new String[]{"cream"}, 10.00));

        // Act - get the subtotal
        double subtotal = shoppingCart.getSubtotalPrice();

        // Assert - Make sure value is correct
        Assert.assertEquals(40.00, subtotal, 0.00);
    }
}
