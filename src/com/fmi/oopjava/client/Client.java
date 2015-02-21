package com.fmi.oopjava.client;

import com.fmi.oopjava.interfaces.Storable;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * Client class has four properties: - name - the actual name of the client. -
 * username - the username the client uses to log-in. This is unique property.
 * Clients are compared by their usernames. - password - no need to say what
 * that one is. - each client holds a set of their bank cards, but we are not
 * using the BankCard class to represent that one, but Strings. Because the
 * BankCard class holds also the tokens of each card. We want to be more
 * cautious, so just Strings, the server knows how to get the tokens from a
 * String.
 *
 * The Client class is implementing Serializable for the same reasons as the
 * BankCard class: - network transfer - serializing as XML
 *
 * Storable - because it will be stored as XML file.
 *
 * @author Dimitar
 */
public class Client implements Serializable, Storable {

    private String name;
    private String username;
    private char[] password;

    private boolean tokenizationRight;
    private boolean gettingCardRights;

    private final Set<String> cards;

    public Client(String name, String username, char[] password, boolean tokenizationRight, boolean gettingCardRights) {
        setName(name);
        setUsername(username);
        setPassword(password);
        setTokenizationRight(tokenizationRight);
        setGettingCardRights(gettingCardRights);
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

    public boolean hasTokenizationRight() {
        return tokenizationRight;
    }

    private void setTokenizationRight(boolean tokenizationRight) {
        this.tokenizationRight = tokenizationRight;
    }

    public boolean hasGettingCardRights() {
        return gettingCardRights;
    }

    private void setGettingCardRights(boolean gettingCardRights) {
        this.gettingCardRights = gettingCardRights;
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
