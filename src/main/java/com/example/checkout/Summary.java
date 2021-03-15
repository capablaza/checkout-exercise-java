package com.example.checkout;

import java.util.List;

public class Summary {

    public static int balance(List<Product> products){

        int productBalance = products.stream().mapToInt(value -> value.getAmount()).sum();

        return productBalance;
    }
}
