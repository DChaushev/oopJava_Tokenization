/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.client;

import com.fmi.oopjava.interfaces.Storable;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Dimitar
 */
public class Client implements Serializable, Storable {

    private String name;

    private String username;
    private char[] password;
    
    private final Set<String> cards;


    public Client(String name, String username, char[] password) {
        setName(name);
        setUsername(username);
        setPassword(password);
        cards = new TreeSet<>();
    }

    public void addCard(String card) throws UnsupportedOperationException {
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


    @Override
    public String getFileName() {
        return username;
    }

    public boolean hasCard(String cardNumber) {
        return cards.contains(cardNumber);
    }

    @Override
    public boolean equals(Object obj) {
        Client c = (Client) obj;
        return this.username.equals(c.getUsername());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.username);
        return hash;
    }
    
}
