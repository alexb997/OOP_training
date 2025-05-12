Online Food Delivery Platform

Problem Statement
Design an extensible Online Food Delivery System that supports:

Restaurants registering themselves

Customers placing and tracking orders

Multiple payment and delivery strategies

Real-time order updates (like notifications)

Promotions & discounts

✅ Functional Requirements
📦 Restaurants
Can register dishes (name, price, type: veg/non-veg)

Can update availability of items

👤 Customers
Can browse restaurants

Add dishes to a cart

Choose delivery method (standard, express)

Choose payment method (cash, credit, UPI)

Apply available promotions

Place and track their orders

🚚 Delivery
Strategy pattern to allow different delivery options (standard vs express)

💳 Payment
Strategy pattern for various payment methods

🔔 Notifications
Observer pattern: customers receive updates when their order status changes

🛠️ Promotions
Factory or Strategy pattern to create/apply different types of promotions

CLI Interaction Sample:
Welcome to QuickEats!

1. Register Restaurant
2. Add Dish
3. Register Customer
4. Browse Menu
5. Add to Cart
6. Apply Promotion
7. Choose Payment & Delivery
8. Place Order
9. Track Order