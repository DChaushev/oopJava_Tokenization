package com.fmi.oopjava.cardValidator;

/**
 * We are using Luhn's algorithm to validate the card numbers given.
 * The algorithm states that one card is valid if:
 *      - it starts with 3, 4, 5 or 6
 *      - We reverse the digits...
 *         - ...and take the first, third and every other odd digit,
 *           sum them to form s1.
 *         - ...then for every second digit, we..
 *              - multiply the digit by 2 and sum the digit if the answer is greater than 9
 *                to form partial sums for the even digits
 *              - sum the partial sums of the even digits to form s2
 *         - If s1 + s2 ends in zero, then the original number is a valid bank
 *           card number!
 * 
 * Example:
 *  card number: 49927398716
 *  reverse it:  61789372994
 *  Sum the odd digits:
 *      6 + 7 + 9 + 7 + 9 + 4 = 42 = s1
 *  Then for the even ones:
 *      1,  8,  3,  2,  9
 *  Two times each even digit:
 *      2, 16,  6,  4, 18
 *  Sum the digits of each multiplication:
 *      2,  7,  6,  4,  9
 *  Sum the last:
 *       2 + 7 + 6 + 4 + 9 = 28 = s2
 * 
 *  s1 + s2 = 70 which ends in zero which means that 49927398716 passes the Luhn's test
 * 
 * @author Dimitar
 */
public class CardNumberValidator {

    private static final char[] validStartingDigits = {'3', '4', '5', '6'};

    public static boolean isValid(String cardNumber) {

        if (cardNumber == null || cardNumber.equals("") || cardNumber.length() != 16 || !isValidFirstDigit(cardNumber)) {
            return false;
        }

        int s1 = 0, s2 = 0;
        String reverse = new StringBuilder(cardNumber).reverse().toString();
        for (int i = 0; i < reverse.length(); i++) {
            int digit = Character.digit(reverse.charAt(i), 10);
            if (i % 2 == 0) {
                s1 += digit;
            } else {
                s2 += 2 * digit;
                if (digit >= 5) {
                    s2 -= 9;
                }
            }
        }
        return (s1 + s2) % 10 == 0;
    }

    private static boolean isValidFirstDigit(String cardNumber) {
        for (int i = 0; i < validStartingDigits.length; i++) {
            if (cardNumber.charAt(0) == validStartingDigits[i]) {
                return true;
            }
        }
        return false;
    }

}
