Design a Simple E-commerce Shopping Cart System

Problem Statement:
Create a simple shopping cart system for an e-commerce platform that allows customers to:

Add Items to the cart.

Remove Items from the cart.

View the Items in the cart (with quantities and prices).

Calculate the Total Price of the cart.

Apply Discounts based on a discount code (10% off for a code like "SUMMER10").

Entities:
Item

Represents a product in the store.

Attributes: name, price, quantity

Methods: getName(), getPrice(), getQuantity(), setQuantity(int newQuantity)

Cart

Holds the list of items and manages operations like add/remove.

Attributes: items (list of Item objects)

Methods: addItem(Item item), removeItem(String itemName), getTotal(), viewItems(), applyDiscount(String code)

DiscountService (Optional but useful for OOP)

Handles applying discount codes.

Attributes: discountCodes (map of discount codes and their values)

Methods: applyDiscount(String code, double totalPrice)

Main Class (Driver)

The class you will use to simulate user interaction (could be a simple CLI).

Methods: main(String[] args) to drive the shopping cart system.