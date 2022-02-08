package com.techelevator.purple;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static long Order_Number_Count = 1;
    private static final BigDecimal Rush_Fee = new BigDecimal("4.99");

    private boolean isPhoneOrder;
    private long orderNumber;
    private Date orderDate;
    private Date pickupDate;
    //Should be decimal value not a percentage
    private double taxMultiplier;
    private List<Product> productList;
    private Customer customer;

    public Order(double taxMultiplier){
        this.orderNumber = Order_Number_Count++;
        // auto generate numbers starting at 1 incr by 1
        // ex: 1,2,3,4,...
        this.taxMultiplier = taxMultiplier;
        this.productList = new ArrayList<>();

    }
    public void addProduct(Product product) {
        productList.add(product);
    }

    public String getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        //get total item price...
        for (Product item: productList) {
            total = total.add(item.getPrice());
        }
        //Add tax to the item total...
        BigDecimal taxAmount = total.multiply(BigDecimal.valueOf(taxMultiplier));
        total = total.add(taxAmount);
        return NumberFormat.getCurrencyInstance().format(total);
    }

}
