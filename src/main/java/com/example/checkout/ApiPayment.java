package com.example.checkout;

public interface ApiPayment {
    int SUCCESS = 200;
    int CARD_NOT_VALID = 502;
    int OUT_OF_MONEY = 503;
    int AMOUNT_INVALID = 504;

    public ApiResponse transfer(float amountToPay, Card card);
}
