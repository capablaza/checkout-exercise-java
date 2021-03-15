package com.example.checkout;

import java.util.List;

public class CheckoutService {

    public CheckoutResponse checkout(List products, Card card, ApiPayment api) {

        int balance = Summary.balance(products);

        float taxes = card.taxes(balance);

        float amountToPay = balance + taxes;

        ApiResponse response = api.transfer(amountToPay, card);

        if (response.code() == ApiPayment.CARD_NOT_VALID) {
            return new CheckoutResponse(ApiPayment.CARD_NOT_VALID, response.message());
        } else if (response.code() == ApiPayment.OUT_OF_MONEY) {
            return new CheckoutResponse(ApiPayment.OUT_OF_MONEY, response.message());
        } else if (response.code() == ApiPayment.AMOUNT_INVALID) {
            return new CheckoutResponse(ApiPayment.AMOUNT_INVALID, response.message());
        }

        return new CheckoutResponse(ApiPayment.SUCCESS, "payment process successfully");
    }

}
