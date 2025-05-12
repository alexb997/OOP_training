package org.example.promotion;

public class PromotionFactory {
    public static Promotion getPromotion(String code) {
        // TODO: Return correct Promotion implementation
        return switch (code) {
            case "SAVE10" -> new PercentageDiscount(10);
            case "BOGO" -> new BOGODiscount();
            default -> null;
        };
    }
}
