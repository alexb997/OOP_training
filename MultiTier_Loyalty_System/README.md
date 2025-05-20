# 🛍️ Multi-Tier Loyalty & Membership Shop

A Java-based shop system that manages customer purchases, loyalty points, and membership tiers. The system supports various customer types, point earning/redemption, automatic discounts, and transaction tracking — all built using core OOP principles.

---

## 🚀 Features

- **Customer Membership Tiers**:
    - `Standard`, `Silver`, `Gold`, `Platinum`
    - Each tier earns points at different rates and gets different checkout discounts

- **Loyalty System**:
    - Earn points based on purchases
    - Points expire after a certain number of orders (configurable)
    - Redeem points for real-time discounts during checkout

- **Shopping Cart & Order System**:
    - Add and remove products
    - Calculate total price with discounts
    - Generate an `Order` and store it in the customer's transaction history

- **Transaction History**:
    - View all past purchases
    - Track total spent, points earned, points redeemed

- **Extensible Discount System**:
    - Tier-based discounts
    - Optional promotion code system

---

## 🧠 Concepts & Patterns Used

- **Object-Oriented Design (OOP)**:
    - Inheritance, Encapsulation, Composition, Polymorphism

- **Design Patterns**:
    - Strategy Pattern for discount policies
    - Factory Pattern (optional) for promotion/discount strategies

- **Testability**:
    - Designed for easy extension and testing

---

## 📦 Project Structure

<pre lang="text">
src/
└── main/
└── java/
└── org/
└── example/
├── Main.java
├── model/
│ ├── Customer.java
│ ├── Product.java
│ ├── Order.java
│ ├── Transaction.java
│ └── MembershipTier.java
├── loyalty/
│ ├── LoyaltyPointsManager.java
│ ├── RedemptionPolicy.java
│ └── ExpiryPolicy.java
├── service/
│ ├── ShopService.java
│ └── CustomerRegistry.java
├── discount/
│ ├── DiscountStrategy.java
│ ├── TierDiscountStrategy.java
│ └── PromotionCodeStrategy.java
</pre>