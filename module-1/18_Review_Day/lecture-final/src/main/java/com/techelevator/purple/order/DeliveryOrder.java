package com.techelevator.purple.order;

import com.techelevator.purple.Address;

import java.math.BigDecimal;

public class DeliveryOrder extends Order {

    public static final BigDecimal DELIVERY_FEE = new BigDecimal("5.00");
    public static final int ITEM_COUNT_BEFORE_ADDITIONAL_FEE = 2;
    public static final BigDecimal ADDIONAL_ITEM_CHARGE = new BigDecimal("1.00");

    private String recipientName;
    private Address address;

    public DeliveryOrder(String recipientName, Address deliveryAddress, double percentTax) {
        super(percentTax);
        this.recipientName = recipientName;
        this.address = deliveryAddress;
    }

    public Address getAddress() {
        return this.address;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    private BigDecimal getDeliveryFee() {
        BigDecimal totalFee = DELIVERY_FEE;
        double itemsForAdditionalCharge = getProducts().length - ITEM_COUNT_BEFORE_ADDITIONAL_FEE;
        if (itemsForAdditionalCharge > 0){
            BigDecimal additionItemFee = ADDIONAL_ITEM_CHARGE.multiply(BigDecimal.valueOf(itemsForAdditionalCharge));
            totalFee = totalFee.add(additionItemFee);
        }
        return totalFee;
    }

    @Override
    public BigDecimal getTotalPrice() {
        // TODO - should be charging tax on the entire cost w/ delivery fee
        BigDecimal orderTotal = super.getTotalPrice();
        return orderTotal.add(getDeliveryFee());
    }
}
