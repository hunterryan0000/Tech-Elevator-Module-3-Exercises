package com.techelevator.purple.products;

import java.math.BigDecimal;

public class Bouquet extends Product {

    private static final BigDecimal BASE_COST = new BigDecimal("19.99");
    private static final BigDecimal PER_ROSE_SURCHARGE = new BigDecimal("2.99");

    private int numberOfRoses;

    public Bouquet(String type, int roseCount){
        super(type);
        this.numberOfRoses = roseCount;
    }


    public int getNumberOfRoses() {
        return this.numberOfRoses;
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal total = BigDecimal.ZERO;
        total = total.add(BASE_COST);
        BigDecimal costOfRoses = PER_ROSE_SURCHARGE.multiply(BigDecimal.valueOf(numberOfRoses));
        total = total.add(costOfRoses);
        return total;
    }

}
