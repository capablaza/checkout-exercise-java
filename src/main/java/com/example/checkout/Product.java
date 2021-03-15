package com.example.checkout;

public class Product {

    private String sku;
    private int amount;

    public Product(String sku, int amount) {
        this.sku = sku;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
