package com.example.checkout;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SummaryTest {

    @Test
    public void givenTwoProductsWhenBothAvail500ThenBalanceIs1000(){

        List<Product> products = new ArrayList<>();

        products.add(new Product("LK89232", 500));
        products.add(new Product("LK89233", 500));

        int expected = 1000;

        int balance = Summary.balance(products);
        assertEquals(expected, balance);

    }

    @Test
    public void shouldReturnZeroWhenListProductIsEmpty(){
        List<Product> products = new ArrayList<>();
        int expected = 0;
        int balance = Summary.balance(products);

        assertTrue(products.isEmpty());
        assertEquals(expected, balance);
    }

    @Test
    public void shouldReturnZeroWhenBothsProductsHaveValueIdenticalButOpposite(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("LK89232", -500));
        products.add(new Product("LK89233", 500));

        int expected = 0;
        int balance = Summary.balance(products);
        assertEquals(expected, balance);
    }

    @Test
    public void givenProductValueIs500WhenProductValueIsNegativeThenReturnBalanceNegative(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("LK89232", -1500));
        products.add(new Product("LK89233", 500));

        int expected = -1000;
        int balance = Summary.balance(products);
        assertEquals(expected, balance);
    }

}
