# Flower Shop - Part 2

We've got new work again from our Flower Shop owners! They want us to get a full user interface working 
to support their order and delivery process. They also need a report of all the sales for a particular location.


## Delivery

Currently all orders must be picked up in store. The owner has started working with delivery services 
to allow for delivery to a single address per order.
> Note: If a customer wants delivery to multiple locations, they must place multiple orders.

For a delivery order, the customer must provide the recipient's name and delivery address, in addition 
to the other required order information, when the order is placed.

There is a base delivery fee of $5.00 with an additional $1 charge per item if there are more than 2 items.

## Sales Reporting

When payment is collected for an order, that order should be logged to a sales report. The log entry should include:
- the order number
- whether it was a pickup or delivery order
- the delivery zipcode (or for pickup, store zipcode)
- the total item count
- the amount of tax collected for the order
- the total sale amount (including tax)

## Feature Priority

> Note: Initially each store location will operate entirely independently, taking their 
> own orders and managing the pickups and deliveries. At a future time, we would like 
> to centralize orders for all locations for more efficient processing.

- Collecting orders for a single location
- Viewing all orders for a single location
- Generating the Sales log
- Viewing all delivery orders
- Viewing all pickup orders



