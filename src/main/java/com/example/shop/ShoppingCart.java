package com.example.shop;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<String, Integer> quantities = new LinkedHashMap<>();
    private final Map<String, BigDecimal> prices = new LinkedHashMap<>();

    public void add(String product, BigDecimal price, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        quantities.merge(product, quantity, Integer::sum);
        prices.put(product, price);
    }

    public void remove(String product) {
        quantities.remove(product);
        prices.remove(product);
    }

    public int itemCount() {
        return quantities.values().stream().mapToInt(Integer::intValue).sum();
    }

    public int lineCount() {
        return quantities.size();
    }

    public boolean isEmpty() {
        return quantities.isEmpty();
    }

    public BigDecimal total() {
        BigDecimal total = BigDecimal.ZERO;
        for (Map.Entry<String, Integer> line : quantities.entrySet()) {
            BigDecimal price = prices.get(line.getKey());
            total = total.add(price.multiply(BigDecimal.valueOf(line.getValue())));
        }
        return total;
    }
}
