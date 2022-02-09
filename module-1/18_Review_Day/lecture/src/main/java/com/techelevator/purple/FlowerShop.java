package com.techelevator.purple;

import java.util.ArrayList;
import java.util.List;

public class FlowerShop {

    private String name;
    private List<Order> orderList;

    public FlowerShop(String name){
        this.name = name;
        this.orderList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addOrder(Order newOrder){
        orderList.add(newOrder);
    }

    public Order[] getAllOrders(){
        return orderList.toArray(new Order[0]);
    }

}
