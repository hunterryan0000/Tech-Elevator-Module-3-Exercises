package com.techelevator.purple;

import java.math.BigDecimal;

public class Balloon extends Product {

    private static final BigDecimal Basic_Price = new BigDecimal("2.99");
    private static final BigDecimal Deluxe_Charge = new BigDecimal("3.00");

    private boolean isDeluxe;

    public Balloon(String type, boolean isDeluxe) {
        super(type);
        this.isDeluxe = isDeluxe;
        //Saves whatever they type
    }


    @Override
    public BigDecimal getPrice (){
        if (isDeluxe){
            return Balloon.Basic_Price.add(Deluxe_Charge);
        }
        return Balloon.Basic_Price;
    }
}
