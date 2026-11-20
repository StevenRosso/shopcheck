package com.example.shop;

import java.math.BigDecimal;

public class DeliveryCalculator {

    public static BigDecimal charge(BigDecimal subtotal, String method) {
        if ("express".equals(method)) {
            return new BigDecimal("9.00");
        }
        return subtotal.compareTo(new BigDecimal("50.00")) >= 0
            ? BigDecimal.ZERO
            : new BigDecimal("4.00");
    }
}
