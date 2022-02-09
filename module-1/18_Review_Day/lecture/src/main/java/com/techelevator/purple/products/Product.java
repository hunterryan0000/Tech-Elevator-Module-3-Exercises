package com.techelevator.purple.products;

import java.math.BigDecimal;

public abstract class Product {

    private String type;

    public Product(String type) {
        this.type = type;
    }

    public abstract BigDecimal getPrice();
}
