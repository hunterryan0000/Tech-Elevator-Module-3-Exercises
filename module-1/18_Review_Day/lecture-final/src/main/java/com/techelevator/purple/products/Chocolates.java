package com.techelevator.purple.products;

import java.math.BigDecimal;

public class Chocolates extends Product {

    private static final BigDecimal BASE_COST = new BigDecimal("3.99");
    private static final BigDecimal PER_CHOCOLATE_CHARGE = new BigDecimal("1.99");

    private int numberOfChocolates;

    public Chocolates(int chocolateCount) {
        super(chocolateCount > 1 ?
                String.format("Box of %d Chocolates", chocolateCount) :
                "Single Chocolate");
        this.numberOfChocolates = chocolateCount;
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal total = BigDecimal.ZERO;
        total = total.add(BASE_COST);
        BigDecimal costAdditionalChocolates = PER_CHOCOLATE_CHARGE.multiply(BigDecimal.valueOf(numberOfChocolates));
        total = total.add(costAdditionalChocolates);
        return total;
    }
}

