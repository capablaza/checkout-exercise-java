package com.example.checkout;

public class ApiPaymentStub implements ApiPayment{

    @Override
    public ApiResponse transfer(float amountToPay, Card card) {
        if(amountToPay <= 0 ){
            return new ApiResponse(ApiPayment.AMOUNT_INVALID, "The amount is not valid");
        }
        return new ApiResponse(ApiPayment.SUCCESS, "the payment was success");
    }
}
