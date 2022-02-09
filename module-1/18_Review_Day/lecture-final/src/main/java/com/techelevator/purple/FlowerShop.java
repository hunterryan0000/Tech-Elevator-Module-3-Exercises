package com.techelevator.purple;

import com.techelevator.purple.order.Order;
import com.techelevator.purple.reports.SalesReporter;

import java.util.ArrayList;
import java.util.List;

public class FlowerShop {

    private String name;
    private List<Order> orderList;
    private SalesReporter salesReporter;

    public FlowerShop(String name){
        this.name = name;
        this.orderList = new ArrayList<>();
        this.salesReporter = new SalesReporter();
    }

    public String getName() {
        return name;
    }

    public void addOrder(Order newOrder){
        orderList.add(newOrder);
        salesReporter.writeOrderToReport(newOrder);
    }

    public Order[] getAllOrders(){
        return orderList.toArray(new Order[0]);
    }

}
