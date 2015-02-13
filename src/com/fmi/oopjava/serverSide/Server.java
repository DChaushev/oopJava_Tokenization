/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fmi.oopjava.serverSide;

import com.fmi.oopjava.client.Client;
import com.fmi.oopjava.remoteInterface.RemoteServer;
import com.fmi.oopjava.tokenGenerator.TokenGenerator;
import com.fmi.oopjava.xmlSerializor.ClientsStorer;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Dimitar
 */
public class Server
        extends UnicastRemoteObject implements RemoteServer {

    private final Map<String, String> tokenMap;
    private final Map<String, List<String>> cardToTokensMap;
    private final Set<String> allTokens;
    private final Set<String> online;

    public Server() throws RemoteException {
        allTokens = new HashSet<>();
        tokenMap = new TreeMap<>();
        cardToTokensMap = new TreeMap<>();
        online = new HashSet<>();
    }

    @Override
    public Client validateCredentials(String username, char[] password) {

        if (ClientsStorer.clientExists(username)) {
            Client client = (Client) ClientsStorer.readClient(username);
            if (client != null && client.checkPassword(password)) {
                return client;
            }
        }
        return null;
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
        if (!cardToTokensMap.containsKey(cardNumber)) {
            cardToTokensMap.put(cardNumber, new ArrayList<>());
        }
        cardToTokensMap.get(cardNumber).add(token);
        return token;
    }

    @Override
    public String getCardNumber(String token) {
        if (tokenMap.containsKey(token)) {
            return tokenMap.get(token);
        }
        return null;
    }

    @Override
    public String getAllTokens(String cardNumber) throws RemoteException {
        StringBuilder result;
        if (cardToTokensMap.containsKey(cardNumber)) {
            result = new StringBuilder();
            List tokens = cardToTokensMap.get(cardNumber);
            tokens.stream().forEach((token) -> {
                result.append(String.format("%s\n", token));
            });
            return result.toString();
        }
        return null;
    }

    @Override
    public boolean isUp() throws RemoteException {
        return true;
    }

    @Override
    public void serializeClient(Client client) {
        ClientsStorer.writeClient(client);
    }

    public Client deserialzeClient(String fileName) {
        return ClientsStorer.readClient(fileName);
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
}
