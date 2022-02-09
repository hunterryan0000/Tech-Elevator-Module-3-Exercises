package com.techelevator.purple.order;

import com.techelevator.purple.Customer;
import com.techelevator.purple.products.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static long LAST_ORDER_NUMBER = 1;
    private static final BigDecimal RUSH_FEE = new BigDecimal("4.99");

    private long orderNumber;
    private Date orderDate;
    private Date pickupDate;

    // This should be a decimal value not a percentage
    private double taxMuliplier;

    private List<Product> productList;
    private Customer customer;

    public Order(double taxMuliplier){
        // Automatically add next order number
        this.orderNumber = LAST_ORDER_NUMBER++;

        // Automatically set the order date to the current date
        this.orderDate = new Date();

        // Setup empty array list to add products into
        this.productList = new ArrayList<>();

        this.taxMuliplier = taxMuliplier;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product[] getProducts() {
        return productList.toArray(new Product[0]);
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public long getOrderNumber() {
        return orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public double getTaxMuliplier() {
        return taxMuliplier;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal total = BigDecimal.ZERO;
        // Get total item price...
        for( Product item : productList ) {
            total = total.add(item.getPrice());
        }
        // Add tax to the item total...
        BigDecimal taxAmount = total.multiply(BigDecimal.valueOf(taxMuliplier));
        total = total.add(taxAmount);
        // Set to have 2 decimal places, rounding up
        return total.setScale(2, RoundingMode.HALF_UP);
    }

}
