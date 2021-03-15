package com.example.checkout;

public class ApiPaymentValidationStub implements ApiPayment {

    private int code;

    public ApiPaymentValidationStub(int code) {
        this.code = code;
    }

    @Override
    public ApiResponse transfer(float amountToPay, Card card) {
        return new ApiResponse(this.code,"");
    }
}
