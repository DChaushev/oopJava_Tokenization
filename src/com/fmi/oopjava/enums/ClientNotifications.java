package com.fmi.oopjava.enums;

/**
 *
 * @author Dimitar
 */
public enum ClientNotifications {

    NO_CONNECTION_TO_SERVER("No connection to the server! Please try again later!"),
    INVALID_USERNAME_FORMAT("Invalid username format!"),
    INVALID_PASSWORD_FORMAT("Invalid password format!"),
    INVALID_CREDENTIALS("Invalida username or password!"),
    INVALID_CARD_NUMBER("Invalid Card Number!"),
    INVALID_TOKEN_FORMAT("Invalid token!"),
    TOKENIZATION_SUCCESSFULL("Tokenization successful!"),
    CARD_FOUND("Card Number found!"),
    NO_TOKEN("No such token!"),
    ALREADY_LOGGED("You are already logged!"),
    FOREIGN_CARD("This is not your card!"),
    CONNECTION_LOST("Connection to server lost!"),
    NO_RIGHTS("You are not authorized to do this!");

    private final String message;

    private ClientNotifications(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
