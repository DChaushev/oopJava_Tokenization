/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.bankCard;

import com.fmi.oopjava.interfaces.Storable;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Dimitar
 */
public class BankCard implements Serializable, Storable{
    
    private String cardNumber;
    private Set<String> tokens;

    public BankCard() {
        this(null);
    }

    public BankCard(String cardNumber) {
        this.cardNumber = cardNumber;
        tokens = new HashSet<>();
    }

    public void addToken(String token){
        if(!tokens.contains(token))
            tokens.add(token);
    }
    
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Set<String> getTokens() {
        return new HashSet<>(tokens);
    }

    @Override
    public boolean equals(Object obj) {
        BankCard bc = (BankCard) obj;
        return this.getCardNumber().equals(bc.getCardNumber());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.cardNumber);
        hash = 79 * hash + Objects.hashCode(this.tokens);
        return hash;
    }

    @Override
    public String getFileName() {
        return cardNumber;
    }
    
}
