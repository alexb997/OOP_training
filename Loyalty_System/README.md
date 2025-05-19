# 🛒 Loyalty Rewards System Overhaul - Java OOP Challenge

## 🎯 Objective

Refactor and enhance an existing shopping cart system to introduce a **pluggable loyalty point calculation algorithm** that dynamically adjusts points based on the **discount applied** and **product price**.

This challenge focuses on applying **Object-Oriented Programming principles** (abstraction, encapsulation, inheritance, and polymorphism) and designing a **flexible architecture** for discount and reward logic.

---

## 📋 Requirements

### 1. Refactor Existing Logic

- Remove all hardcoded conditions like `if productCode startsWith "DIS_10"` from the `ShoppingCart` class.
- Introduce **Discount types** (e.g., 10%, 15%, etc.) using a clean and extensible structure (e.g., interfaces, strategies, or factory pattern).

### 2. Design a Loyalty Point Algorithm

Create a loyalty points algorithm where the **reward decreases** as the **discount increases**.

- Example idea:
    - No discount → 1 point per $5
    - 10% discount → 1 point per $10
    - 15% discount → 1 point per $15

> ⚠️ This is just an example — you are encouraged to come up with your own formula that balances discount vs. reward fairly.

### 3. Add New Components

- `Discount` interface/class: Encapsulates how the discount is calculated.
- `LoyaltyPointStrategy` interface/class: Encapsulates how loyalty points are calculated.
- Associate each product with a discount and a loyalty strategy.

### 4. Cart Behavior

On checkout:
- Correct discounts should be applied to each product.
- Loyalty points should be calculated based on the selected strategy.
- Display a summary with:
    - Final total price
    - Total loyalty points earned

### 5. 🔧 Bonus Task (Optional)

- Add a **Buy 2 Get 1 Free** discount type.
- Loyalty points should only be awarded for **paid items**, not the free one.

---

## ✅ Constraints

- Use **Java** for your implementation.
- Apply **OOP principles**:
    - Abstraction
    - Encapsulation
    - Inheritance
    - Polymorphism
- Avoid using conditionals like `if-else` or `switch-case` to determine discount types.
- Your code should follow the **Open-Closed Principle**: open for extension, closed for modification.

---

## 📦 Deliverables

- Complete Java source code including:
    - Product
    - Customer
    - ShoppingCart
    - Order
    - Discount implementations
    - Loyalty point calculation strategy
- A `Main` class that:
    - Creates sample products with various discounts
    - Adds them to the cart
    - Checks out and prints a detailed summary (total price and loyalty points)

---

## 💡 Tips

- Consider using the **Strategy Pattern** to encapsulate both discounts and loyalty point calculations.
- A **Factory Pattern** can help map discount codes to their corresponding discount types.
- Aim for **code reusability**, **testability**, and **separation of concerns**.
