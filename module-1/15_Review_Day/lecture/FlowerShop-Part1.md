# Flower Shop - Part 1

Our new customer has asked us to build an application to support their nationwide flower shops. We'll build this application in a few small sprints...

For this first sprint, we'll focus on building the objects to manage their product catalog and order process. 

## Products

The store sells a variety of bouquets, with each store location having different names for various bouquet types based on the flowers available to them from local growers. Regardless of the bouquet type, each bouquet has a base cost of $19.99. An additional charge of $2.99 is added on top of that for each rose in the bouquet. 

The store also sells a variety of types of balloons and gift boxes of chocolates. Balloons start at $2.99 for a basic solid colored balloon. Deluxe balloons are of a variety of types and have an additional charge of $3. 

Chocolates start at $3.99 for a single gourmet chocolate, with an additional cost of $1.99 for each additional chocolate.  

## Orders

Currently all orders must be placed ahead of time by phone or in store. (In the future, they may consider a web site for taking online orders.) 

When a customer places an order, they must provide their name and phone number, as well as the date for pickup. The order must be placed at least 1 day in advance. Orders with less than 3 days notice should be charged a rush fee of $4.99. 

> Note: Initially it's ok if we rely on the clerk to verify the time frame when entering the order. However they would eventually like the system to prevent placing an order without sufficient notice & automatically add the rush fee when required.

A single pickup order may contain multiple bouquets and cards.

Tax must be collected for each order as well. This amount varies based on location. While we would eventually like this to be automatically calculated, for now the clerk can enter the percent tax manually when creating each order.

The date the order is placed must be recorded. All orders are given an order number for tracking. 

> Note: Ideally the number should be unique across all orders, but for now just make sure it gets a number different than other open orders for that location.



