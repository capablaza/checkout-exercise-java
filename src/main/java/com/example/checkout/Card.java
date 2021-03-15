package com.example.checkout;

public abstract class Card {
    private float tax;

    public Card(float tax){
        this.tax = tax;
    }
    float taxes(float balance){
        return (balance * tax);
    }
}
