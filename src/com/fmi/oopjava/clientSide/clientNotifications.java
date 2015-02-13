/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.clientSide;

/**
 *
 * @author Dimitar
 */
public enum clientNotifications {

    NO_CONNECTION_TO_SERVER("No connection to the server! Please try again later!"),
    INVALID_USERNAME_FORMAT("Invalid username format!"),
    INVALID_PASSWORD_FORMAT("Invalid password format!"),
    INVALID_CREDENTIALS("Invalida username or password!"),
    INVALID_CARD_NUMBER("Invalid Card Number!"),
    TOKENIZATION_SUCCESSFULL("Tokenization successful!"),
    CARD_FOUND("Card Number found!"),
    NO_TOKEN("No such token!");

    private final String message;

    private clientNotifications(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}
