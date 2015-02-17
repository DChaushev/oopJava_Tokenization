package com.fmi.oopjava.bankCard;

import com.fmi.oopjava.interfaces.Storable;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 * The bank card class has only two properties:
 *      - cardNumber, holding as String the number of the card.
 *      - and a Set of Strings, representing tokens, as one card can have more than one tokens.
 * 
 * It is implementing Serializable for two reasons:
 *      - it will be send through network.
 *      - it will be serialized as XML.
 * 
 * The Storable interface is giving us abstraction to writing(storing) objects as
 * XML with the XStream library. For that purpose we are implementing it.
 * 
 * Bank cards are compared by their numbers, as they should be unique.
 * 
 * 
 * @author Dimitar
 */
public class BankCard implements Serializable, Storable, Comparable{
    
    private String cardNumber;
    private Set<String> tokens;

    public BankCard() {
        this(null);
    }

    public BankCard(String cardNumber) {
        this.cardNumber = cardNumber;
        tokens = new TreeSet<>();
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
        return new TreeSet<>(tokens);
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

    @Override
    public int compareTo(Object o) {
        BankCard bc = (BankCard) o;
        if(equals(bc)){
            return 0;
        }
        return this.getCardNumber().compareTo(bc.getCardNumber());
    }
    
}
