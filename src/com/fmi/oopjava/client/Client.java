/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.client;

import com.fmi.oopjava.serverSide.BankCard;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Dimitar
 */
public class Client implements Serializable {

    private String name;

    private String username;
    private char[] password;

    //@XStreamOmitField
    private final Set<BankCard> cards;

    public Client(String name, String username, char[] password) {
        setName(name);
        setUsername(username);
        setPassword(password);
        cards = new HashSet<>();
    }

    public void addCard(BankCard card) throws UnsupportedOperationException {
        if (!cards.contains(card)) {
            cards.add(card);
        } else {
            throw new UnsupportedOperationException("Card already exists!");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(char[] password) {
        this.password = new char[password.length];
        System.arraycopy(password, 0, this.password, 0, password.length);
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(char[] password) {
        if (password.length != this.password.length) {
            return false;
        }
        for (int i = 0; i < password.length; i++) {
            if (password[i] != this.password[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s\n%s", name, username);
    }

    public BankCard getCard(String cardNumber) {

        for (BankCard card : cards) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }

}
