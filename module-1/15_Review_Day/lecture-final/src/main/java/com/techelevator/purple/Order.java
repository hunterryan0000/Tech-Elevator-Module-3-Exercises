package com.techelevator.purple;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static long ORDER_NUMBER_COUNT = 1;
    private static final BigDecimal RUSH_FEE = new BigDecimal("4.99");

    private boolean isPhoneOrder;
    private long orderNumber;
    private Date orderDate;
    private Date pickupDate;

    // This should be a decimal value not a percentage
    private double taxMuliplier;

    private List<Product> productList;
    private Customer customer;

    public Order(double taxMuliplier){
        this.orderNumber = ORDER_NUMBER_COUNT++;
        this.taxMuliplier = taxMuliplier;
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public String getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        // Get total item price...
        for( Product item : productList ) {
            total = total.add(item.getPrice());
        }
        // Add tax to the item total...
        BigDecimal taxAmount = total.multiply(BigDecimal.valueOf(taxMuliplier));
        total = total.add(taxAmount);
        // Format for currency
        return NumberFormat.getCurrencyInstance().format(total);
    }

}
