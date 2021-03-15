package com.example.checkout;


import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckoutTest {

    @Test
    public void givenProductListWhenThisIsEmptyThenResponseIs504() {

        CheckoutService service = new CheckoutService();

        List<Product> products = new ArrayList<>();

        ApiPayment api = new ApiPaymentStub();

        CheckoutResponse response = service.checkout(products, new CreditCard(0.03f), api);

        assertEquals(ApiPayment.AMOUNT_INVALID, response.code());
    }

    @Test
    public void givenProductListWhenCreditCardTaxIsZeroThenResponseIs504() {

        CheckoutService service = new CheckoutService();

        List<Product> products = new ArrayList<>();

        ApiPayment api = new ApiPaymentStub();

        CheckoutResponse response = service.checkout(products, new CreditCard(0), api);

        assertEquals(ApiPayment.AMOUNT_INVALID, response.code());
    }

    @Test
    public void givenProductListWhenThisIsCorrectButOutOfMoneyThenResponseIs503() {

        CheckoutService service = new CheckoutService();

        List<Product> products = new ArrayList<>();

        ApiPayment api = new ApiPaymentValidationStub(ApiPayment.OUT_OF_MONEY);

        CheckoutResponse response = service.checkout(products, new CreditCard(0.03f), api);

        assertEquals(ApiPayment.OUT_OF_MONEY, response.code());
    }

    @Test
    public void givenProductListWhenThisIsCorrectButCardNotValidThenResponseIs502() {

        CheckoutService service = new CheckoutService();

        List<Product> products = new ArrayList<>();

        ApiPayment api = new ApiPaymentValidationStub(ApiPayment.CARD_NOT_VALID);

        CheckoutResponse response = service.checkout(products, new CreditCard(0.03f), api);

        assertEquals(ApiPayment.CARD_NOT_VALID, response.code());
    }


   @Test
   public void shouldReturnSuccessWhenCheckoutIsOk(){

       CheckoutService service = new CheckoutService();

       List<Product> products = new ArrayList<>();
       products.add(new Product("LK89232", 500));
       products.add(new Product("LK89233", 500));

       ApiPayment api = new ApiPaymentStub();

       CheckoutResponse response = service.checkout(products, new CreditCard(0.03f), api);

       assertEquals(ApiPayment.SUCCESS, response.code());
   }

}

