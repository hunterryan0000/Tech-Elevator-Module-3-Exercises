package com.techelevator.purple.products;

import java.math.BigDecimal;

public class Balloon extends Product {

    private static final BigDecimal BASIC_PRICE = new BigDecimal("2.99");
    private static final BigDecimal DELUXE_CHARGE = new BigDecimal("3.00");

    private boolean isDeluxe;

    public Balloon(String type, boolean isDeluxe) {
        super(type);
        this.isDeluxe = isDeluxe;
    }


    @Override
    public BigDecimal getPrice() {
        if (isDeluxe) {
            return BASIC_PRICE.add(DELUXE_CHARGE);
        }
        return Balloon.BASIC_PRICE;
    }
}
