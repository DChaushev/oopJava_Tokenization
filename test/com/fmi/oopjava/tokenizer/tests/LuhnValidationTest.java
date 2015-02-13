/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.tokenizer.tests;

import static com.fmi.oopjava.clientSide.CardNumberValidator.isValid;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dimitar
 */
public class LuhnValidationTest {

    private static String number1True;
    private static String number1False;
    private static String number2True;
    private static String number2False;

    private static String nullString;
    private static String emptyString;

    @BeforeClass
    public static void setUpClass() {
        number1True = "4844712268411461";
        number1False = "1234567812345678";
        number2True = "4754091041477562";
        number2False = "4444333322221110";
        nullString = null;
        emptyString = new String();
    }

    @Test
    public void testLuhnValidationTrue() {
        assertTrue(isValid(number1True));
        assertTrue(isValid(number2True));
    }

    @Test
    public void testLuhnValidationFalse() {
        assertFalse(isValid(number1False));
        assertFalse(isValid(number2False));
        assertFalse(isValid(nullString));
        assertFalse(isValid(emptyString));
    }

}
