package com.example.checkout;

public class CheckoutResponse {

    private int code;
    private String message;

    public CheckoutResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code() {
        return this.code;
    }

}
