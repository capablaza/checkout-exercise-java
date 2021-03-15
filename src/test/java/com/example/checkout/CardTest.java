package com.example.checkout;

import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void shouldReturn30WhenIsCreditCardAndAmountIs1000() {
        Card card = new CreditCard(0.03f);
        float amount = 1000;
        float expected = 30;
        float taxes = card.taxes(amount);
        assertEquals(expected, taxes, 0.0);
    }

    @Test
    public void shouldReturnZeroWithCreditCardAndAmountIsZero() {
        Card card = new CreditCard(0.03f);
        float amount = 0;
        float expected = 0;
        float taxes = card.taxes(amount);
        assertEquals(expected, taxes, 0.0);
    }

    @Test
    public void shouldReturnZeroWhenCreditCardTaxIsZero() {
        Card card = new CreditCard(0);
        float amount = 1000;
        float expected = 0;
        float taxes = card.taxes(amount);
        assertEquals(expected, taxes, 0.0);
    }


    @Test
    public void shouldReturn30WhenIsDebitCardAndAmountIs1000() {
        Card card = new DebitCard(0.015f);
        float amount = 1000;
        float expected = 15;
        float taxes = card.taxes(amount);
        assertEquals(expected, taxes, 0.0);
    }

    @Test
    public void shouldReturnZeroWithDebitCardAndAmountIsZero() {
        Card card = new DebitCard(0.015f);
        float amount = 0;
        float expected = 0;
        float taxes = card.taxes(amount);
        assertEquals(expected, taxes, 0.0);
    }

    @Test
    public void shouldReturnZeroWhenDebitCardTaxIsZero() {
        Card card = new DebitCard(0);
        float amount = 1000;
        float expected = 0;
        float taxes = card.taxes(amount);
        assertEquals(expected, taxes, 0.0);
    }

}
