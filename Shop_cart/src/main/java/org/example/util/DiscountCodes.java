package org.example.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DiscountCodes {

    private static final Map<String, Double> DISCOUNT_CODE_MAP = new HashMap<>();

    static {
        DISCOUNT_CODE_MAP.put("SUMMER10", 0.10);
        DISCOUNT_CODE_MAP.put("WELCOME15", 0.15);
        DISCOUNT_CODE_MAP.put("FESTIVE20", 0.20);
    }

    public static Map<String, Double> getAllDiscounts() {
        return Collections.unmodifiableMap(DISCOUNT_CODE_MAP);
    }

    public static Double getDiscountValue(String code) {
        return DISCOUNT_CODE_MAP.get(code.toUpperCase());
    }

    public static boolean isValidCode(String code) {
        return DISCOUNT_CODE_MAP.containsKey(code.toUpperCase());
    }
}
