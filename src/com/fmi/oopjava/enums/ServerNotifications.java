/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.enums;

/**
 *
 * @author Dimitar
 */
public enum ServerNotifications {

    NO_CARDS("No cards!"), INVALID_CREDENTIALS("Invalid credentials format!"), USER_ALREADY_EXISTS("User already exists!"), USER_ADDED("User added!");

    private final String message;

    private ServerNotifications(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
