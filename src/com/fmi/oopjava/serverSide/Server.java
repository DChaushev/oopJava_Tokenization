/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.serverSide;

import com.fmi.oopjava.bankCard.BankCard;
import com.fmi.oopjava.tokenGenerator.TokenGenerator;
import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.interfaces.RemoteServer;
import com.fmi.oopjava.interfaces.Storable;
import com.fmi.oopjava.txtOutputWriter.TxtOutputWriter;
import com.fmi.oopjava.xmlSerializor.Storer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Dimitar
 */
public class Server<T>
        extends UnicastRemoteObject implements RemoteServer {

    private final Storer storer;
    private final Map<String, String> tokenMap;
    private final Set<String> allTokens;
    private final Set<String> online;

    public Server() throws RemoteException {
        storer = new Storer();
        allTokens = new HashSet<>();
        tokenMap = new TreeMap<>();
        online = new HashSet<>();
        
        collectCardNumbers();
    }

    @Override
    public boolean validateCredentials(String username, char[] password) {

        if (Storer.clientExists(username)) {
            Client client = (Client) storer.readObject(username, Client.class);
            if (client != null && client.checkPassword(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String generateToken(String cardNumber) {
        String token;
        boolean check = false;
        do {
            token = TokenGenerator.generateToken(cardNumber);
            if (!allTokens.contains(token)) {
                check = true;
            }
        } while (!check);
        allTokens.add(token);

        tokenMap.put(token, cardNumber);

        return token;
    }

    @Override
    public String getCardNumber(String token, Client client) {
        System.out.println(tokenMap);
        if (tokenMap.containsKey(token)) {
            String cardNumber = tokenMap.get(token);
            if (client.hasCard(cardNumber)) {
                return tokenMap.get(token);
            }
        }
        return null;
    }

    public String getAllTokens(String cardNumber) throws RemoteException {

        return null;
    }

    @Override
    public boolean isUp() throws RemoteException {
        return true;
    }

    @Override
    public void logout(Client client) {
        if (online.contains(client.getUsername())) {
            online.remove(client.getUsername());
        }
    }

    @Override
    public boolean isLogged(Client client) throws RemoteException {
        return online.contains(client.getUsername());
    }

    @Override
    public void login(Client client) throws RemoteException {
        online.add(client.getUsername());
    }

    @Override
    public void serializeObject(Storable obj) throws RemoteException {
        storer.writeObject(obj, obj.getClass());
    }

    @Override
    public T deserializeObject(String fileName, Class objectType) throws RemoteException {
        return (T) storer.readObject(fileName, objectType);
    }

    @Override
    public boolean cardExists(String cardNumber) throws RemoteException {
        return storer.cardExists(cardNumber);
    }

    boolean userExists(String username) {
        return storer.clientExists(username);
    }

    boolean generateOutput() {

        Set<BankCard> allCards = storer.getAllCards();
        if (allCards.isEmpty()) {
            return false;
        }

        TxtOutputWriter.writeOutput(allCards);

        return true;

    }

    private void collectCardNumbers() {
        Set<BankCard> cards = storer.getAllCards();
        for (BankCard card : cards) {
            Set<String> tokens = card.getTokens();
            for (String token : tokens) {
                tokenMap.put(token, card.getCardNumber());
                allTokens.add(token);
            }
        }
    }
}
