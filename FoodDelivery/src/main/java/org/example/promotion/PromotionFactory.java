package org.example.promotion;

public class PromotionFactory {
    public static Promotion createPercentageDiscount(String name, double percentage) {
        return new PercentageDiscount(name, percentage);
    }

    public static Promotion createBOGODiscount(String name, String appliesToDish) {
        return new BOGODiscount(name, appliesToDish);
    }
}