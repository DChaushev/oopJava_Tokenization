/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.tokenGenerator;

import java.util.Random;

/**
 *
 * @author Dimitar
 */
public class TokenGenerator {

    private static final Random random = new Random();

    public static String generateToken(String cardNumber) {

        int digit;
        int firstDigitPos; // will be used if the sum % 10 == 0. Then we'll set 
        // as first digit the next one from the allowedFirstDigits.
        int[] allowedFirstDigits = {1, 2, 7, 8, 9};
        int[] result = new int[cardNumber.length()];
        int sum = 0;

        firstDigitPos = random.nextInt(allowedFirstDigits.length);
        // set the first digit
        result[0] = allowedFirstDigits[firstDigitPos];
        sum += allowedFirstDigits[firstDigitPos];

        // set the next n-4 digits
        for (int i = 1; i < cardNumber.length() - 4; i++) {

            do {
                digit = random.nextInt(10);
            } while (digit == cardNumber.charAt(i) - (int) '0');
            result[i] = digit;
            sum += digit;
        }
        // set the last 4 digits (they must be the same as the card's
        for (int i = cardNumber.length() - 4; i < cardNumber.length(); i++) {
            result[i] = cardNumber.charAt(i) - (int) '0';
            sum += cardNumber.charAt(i) - (int) '0';
        }
        // if the sum is divisable by 10, we change the first digit
        if (sum % 10 == 0) {
            result[0] = allowedFirstDigits[(firstDigitPos + 1) % allowedFirstDigits.length];
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            res.append(result[i]);
        }

        return res.toString();
    }
}
