/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.tokenizer.tests;

import com.fmi.oopjava.tokenGenerator.TokenGenerator;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dimitar
 */
public class TokenGeneratorTest {

    private static String cardNumber1;
    private static String cardNumber2;
    private static String cardNumber3;
    private static char[] allowedFirstDigits;

    @BeforeClass
    public static void setUpClass() {
        cardNumber1 = "4563960122019991";
        cardNumber2 = "1234567891011123";
        cardNumber3 = "1111222333449992";
        allowedFirstDigits = new char[]{'1', '2', '7', '8', '9'};
    }

    @Test
    public void testTokenGenerator() {
        assertTrue(checkToken(cardNumber1, TokenGenerator.generateToken(cardNumber1)));
        assertTrue(checkToken(cardNumber2, TokenGenerator.generateToken(cardNumber2)));
        assertTrue(checkToken(cardNumber3, TokenGenerator.generateToken(cardNumber3)));
    }

    private boolean checkToken(String cardNumber, String token) {
        if (cardNumber.length() != token.length()) {
            return false;
        }

        boolean check = false;
        for (int i = 0; i < allowedFirstDigits.length; i++) {
            if (token.charAt(0) == allowedFirstDigits[i]) {
                check = true;
            }
        }
        if (!check) {
            return false;
        }

        for (int i = cardNumber.length() - 4; i < cardNumber.length(); i++) {
            if (cardNumber.charAt(i) != token.charAt(i)) {
                return false;
            }
        }

        for (int i = 1; i < cardNumber.length() - 4; i++) {
            if (cardNumber.charAt(i) == token.charAt(i)) {
                return false;
            }
        }

        int sum = 0;
        for (int i = 0; i < token.length(); i++) {
            sum += token.charAt(i) - (int) '0';
        }
        if (sum % 10 == 0) {
            return false;
        }

        return true;
    }
}
